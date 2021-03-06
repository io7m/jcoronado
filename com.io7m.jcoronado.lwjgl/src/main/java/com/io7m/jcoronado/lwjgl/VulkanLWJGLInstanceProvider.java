/*
 * Copyright © 2018 Mark Raynsford <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jcoronado.lwjgl;

import com.io7m.jcoronado.api.VulkanException;
import com.io7m.jcoronado.api.VulkanExtensionProperties;
import com.io7m.jcoronado.api.VulkanHostAllocatorType;
import com.io7m.jcoronado.api.VulkanInstanceCreateInfo;
import com.io7m.jcoronado.api.VulkanInstanceProviderType;
import com.io7m.jcoronado.api.VulkanInstanceType;
import com.io7m.jcoronado.api.VulkanLayerProperties;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.lwjgl.vulkan.VkLayerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.io7m.jcoronado.api.VulkanChecks.checkReturnCode;

/**
 * A LWJGL-based instance provider.
 */

public final class VulkanLWJGLInstanceProvider
  implements VulkanInstanceProviderType
{
  private static final Logger LOG =
    LoggerFactory.getLogger(VulkanLWJGLInstanceProvider.class);

  private final MemoryStack initial_stack;
  private final VulkanLWJGLExtensionsRegistry extensions;

  private VulkanLWJGLInstanceProvider(
    final MemoryStack in_stack,
    final VulkanLWJGLExtensionsRegistry in_extensions)
  {
    this.initial_stack =
      Objects.requireNonNull(in_stack, "stack");
    this.extensions =
      Objects.requireNonNull(in_extensions, "extensions");
  }

  /**
   * @return A new instance provider
   */

  public static VulkanInstanceProviderType create()
  {
    return new VulkanLWJGLInstanceProvider(
      MemoryStack.create(),
      new VulkanLWJGLExtensionsRegistry());
  }

  /**
   * @return The extension registry for this provider
   */

  VulkanLWJGLExtensionsRegistry extensionRegistry()
  {
    return this.extensions;
  }

  @Override
  public String providerName()
  {
    return "com.io7m.jcoronado.lwjgl";
  }

  @Override
  public String providerVersion()
  {
    final var pack = this.getClass().getPackage();
    final var version = pack.getImplementationVersion();
    return version == null ? "0.0.0" : version;
  }

  @Override
  public Map<String, VulkanExtensionProperties> extensions()
    throws VulkanException
  {
    try (var stack = this.initial_stack.push()) {
      final var count = new int[1];

      checkReturnCode(
        VK10.vkEnumerateInstanceExtensionProperties(
          (CharSequence) null,
          count,
          null),
        "vkEnumerateInstanceExtensionProperties");

      final var size = count[0];
      if (size == 0) {
        return Map.of();
      }

      final var instance_extensions =
        VkExtensionProperties.mallocStack(size, stack);

      checkReturnCode(
        VK10.vkEnumerateInstanceExtensionProperties(
          (CharSequence) null,
          count,
          instance_extensions),
        "vkEnumerateInstanceExtensionProperties");

      final HashMap<String, VulkanExtensionProperties> available_extensions = new HashMap<>(size);
      for (var index = 0; index < size; ++index) {
        instance_extensions.position(index);
        final var extension =
          VulkanExtensionProperties.of(
            instance_extensions.extensionNameString(),
            instance_extensions.specVersion());
        available_extensions.put(extension.name(), extension);
      }

      return available_extensions;
    }
  }

  @Override
  public Map<String, VulkanLayerProperties> layers()
    throws VulkanException
  {
    try (var stack = this.initial_stack.push()) {
      final var count = new int[1];

      checkReturnCode(
        VK10.vkEnumerateInstanceLayerProperties(
          count,
          null),
        "vkEnumerateInstanceLayerProperties");

      final var size = count[0];
      if (size == 0) {
        return Map.of();
      }

      final var layers_buffer =
        VkLayerProperties.mallocStack(size, stack);

      checkReturnCode(
        VK10.vkEnumerateInstanceLayerProperties(
          count,
          layers_buffer),
        "vkEnumerateInstanceLayerProperties");

      final HashMap<String, VulkanLayerProperties> layers = new HashMap<>(size);
      for (var index = 0; index < size; ++index) {
        layers_buffer.position(index);

        final var layer =
          VulkanLayerProperties.of(
            layers_buffer.layerNameString(),
            layers_buffer.descriptionString(),
            layers_buffer.specVersion(),
            layers_buffer.implementationVersion());

        layers.put(layer.name(), layer);
      }
      return layers;
    }
  }

  @Override
  public VulkanInstanceType createInstance(
    final VulkanInstanceCreateInfo info,
    final Optional<VulkanHostAllocatorType> allocator)
    throws VulkanException
  {
    Objects.requireNonNull(info, "info");
    Objects.requireNonNull(allocator, "allocator");

    final var enabled_layers = info.enabledLayers();
    final var enabled_extensions = info.enabledExtensions();

    if (LOG.isDebugEnabled()) {
      LOG.debug("creating instance");
      enabled_layers.forEach(layer -> LOG.debug("enabling layer: {}", layer));
      enabled_extensions.forEach(extension -> LOG.debug("enabling extension: {}", extension));
    }

    try (var stack = this.initial_stack.push()) {
      final var enable_layers_ptr =
        VulkanStrings.stringsToPointerBuffer(stack, enabled_layers);
      final var enable_extensions_ptr =
        VulkanStrings.stringsToPointerBuffer(stack, enabled_extensions);

      final var app_info =
        info.applicationInfo();
      final var app_name_ptr =
        stack.ASCII(app_info.applicationName());
      final var engine_name_ptr =
        stack.ASCII(app_info.engineName());

      final var application_info =
        VkApplicationInfo.mallocStack(stack)
          .sType(VK10.VK_STRUCTURE_TYPE_APPLICATION_INFO)
          .pNext(0L)
          .pApplicationName(app_name_ptr)
          .applicationVersion(app_info.applicationVersion())
          .pEngineName(engine_name_ptr)
          .engineVersion(app_info.engineVersion())
          .apiVersion(app_info.vulkanAPIVersion());

      LOG.trace("application_info: {}", application_info);

      final var instance_info =
        VkInstanceCreateInfo.mallocStack(stack)
          .sType(VK10.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO)
          .pNext(0L)
          .flags(0)
          .pApplicationInfo(application_info)
          .ppEnabledLayerNames(enable_layers_ptr)
          .ppEnabledExtensionNames(enable_extensions_ptr);

      LOG.trace("instance_info: {}", instance_info);

      final var instance_ptr = stack.mallocPointer(1);

      final var allocator_proxy =
        VulkanLWJGLHostAllocatorProxy.create(stack, allocator);

      final var err =
        VK10.vkCreateInstance(instance_info, allocator_proxy.callbackBuffer(), instance_ptr);
      checkReturnCode(err, "vkCreateInstance");

      final var instance =
        new VkInstance(instance_ptr.get(), instance_info);

      LOG.debug("created instance: {}", instance);

      final var enabled =
        this.extensions.ofNames(info.enabledExtensions());

      return new VulkanLWJGLInstance(instance, this.extensions, enabled, allocator_proxy);
    }
  }

}
