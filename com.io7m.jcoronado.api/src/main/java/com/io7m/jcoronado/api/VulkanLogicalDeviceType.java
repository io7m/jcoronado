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

package com.io7m.jcoronado.api;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * A reference to a logical Vulkan device.
 *
 * @see "VkDevice"
 */

public interface VulkanLogicalDeviceType extends VulkanHandleDispatchableType
{
  /**
   * @return The physical device to which this logical device belongs
   */

  VulkanPhysicalDeviceType physicalDevice();

  /**
   * @return The queues present on the logical device
   *
   * @throws VulkanException On errors
   */

  List<VulkanQueueType> queues()
    throws VulkanException;

  /**
   * Find the queue with the given queue family and index.
   *
   * @param queue_family The queue family
   * @param queue_index  The queue index
   *
   * @return The matching queue, if any
   *
   * @throws VulkanException On errors
   */

  default Optional<VulkanQueueType> queue(
    final int queue_family,
    final int queue_index)
    throws VulkanException
  {
    return this.queues()
      .stream()
      .filter(queue -> queue.queueFamilyProperties().queueFamilyIndex() == queue_family
        && queue.queueIndex() == queue_index)
      .findFirst();
  }

  /**
   * @return The enabled extensions for the instance
   *
   * @throws VulkanException On errors
   */

  Map<String, VulkanExtensionType> enabledExtensions()
    throws VulkanException;

  /**
   * Create a shader module.
   *
   * @param create_info The creation info
   *
   * @return A shader module
   *
   * @throws VulkanException On errors
   */

  VulkanShaderModuleType createShaderModule(
    VulkanShaderModuleCreateInfo create_info)
    throws VulkanException;

  /**
   * Create an image view.
   *
   * @param info The image view creation info
   *
   * @return An image view
   *
   * @throws VulkanException On errors
   */

  VulkanImageViewType createImageView(
    VulkanImageViewCreateInfo info)
    throws VulkanException;

  /**
   * Find and cast an extension with a given name to the correct API type.
   *
   * @param name  The extension name
   * @param clazz The intended extension type
   * @param <T>   The precise type
   *
   * @return The extension with the correct type, or nothing if the extension either did not exist
   * or did not have the right type
   *
   * @throws VulkanException On errors
   */

  @SuppressWarnings("unchecked")
  default <T extends VulkanExtensionType> Optional<T> findEnabledExtension(
    final String name,
    final Class<T> clazz)
    throws VulkanException
  {
    Objects.requireNonNull(name, "name");
    Objects.requireNonNull(clazz, "clazz");

    final Map<String, VulkanExtensionType> map = this.enabledExtensions();
    return Optional.ofNullable(map.get(name))
      .flatMap(ext -> {
        final Class<? extends VulkanExtensionType> extension_class = ext.getClass();
        if (clazz.isAssignableFrom(extension_class)) {
          return Optional.of((T) ext);
        }
        return Optional.empty();
      });
  }

  /**
   * Create a pipeline layout.
   *
   * @param info The pipeline layout creation info
   *
   * @return A pipeline layout
   *
   * @throws VulkanException On errors
   */

  VulkanPipelineLayoutType createPipelineLayout(
    VulkanPipelineLayoutCreateInfo info)
    throws VulkanException;

  /**
   * Create a render pass.
   *
   * @param render_pass_create_info The render pass creation info
   *
   * @return A render pass
   *
   * @throws VulkanException On errors
   */

  VulkanRenderPassType createRenderPass(
    VulkanRenderPassCreateInfo render_pass_create_info)
    throws VulkanException;

  /**
   * Create a pipeline.
   *
   * @param pipeline_info The pipeline creation info
   *
   * @return A pipeline
   *
   * @throws VulkanException On errors
   */

  default VulkanPipelineType createPipeline(
    final VulkanGraphicsPipelineCreateInfo pipeline_info)
    throws VulkanException
  {
    Objects.requireNonNull(pipeline_info, "pipeline_info");
    return this.createPipelines(List.of(pipeline_info)).get(0);
  }

  /**
   * Create a set of pipelines.
   *
   * @param pipeline_infos The pipeline creation infos
   *
   * @return A pipeline
   *
   * @throws VulkanException On errors
   */

  List<VulkanPipelineType> createPipelines(
    List<VulkanGraphicsPipelineCreateInfo> pipeline_infos)
    throws VulkanException;

  /**
   * Create a framebuffer.
   *
   * @param create_info The framebuffer creation info
   *
   * @return A pipeline
   *
   * @throws VulkanException On errors
   */

  VulkanFramebufferType createFramebuffer(
    VulkanFramebufferCreateInfo create_info)
    throws VulkanException;

  /**
   * Create a command pool.
   *
   * @param create_info The pool creation info
   *
   * @return A command pool
   *
   * @throws VulkanException On errors
   */

  VulkanCommandPoolType createCommandPool(
    VulkanCommandPoolCreateInfo create_info)
    throws VulkanException;

  /**
   * Create a command buffer.
   *
   * @param create_info The command buffer creation info
   *
   * @return A list of command buffers
   *
   * @throws VulkanException On errors
   */

  List<VulkanCommandBufferType> createCommandBuffers(
    VulkanCommandBufferCreateInfo create_info)
    throws VulkanException;

  /**
   * Create a semaphore.
   *
   * @param create_info The semaphore creation info
   *
   * @return A semaphore
   *
   * @throws VulkanException On errors
   */

  VulkanSemaphoreType createSemaphore(
    VulkanSemaphoreCreateInfo create_info)
    throws VulkanException;

  /**
   * Create a fence.
   *
   * @param create_info The fence creation info
   *
   * @return A fence
   *
   * @throws VulkanException On errors
   */

  VulkanFenceType createFence(
    VulkanFenceCreateInfo create_info)
    throws VulkanException;

  /**
   * Reset the given fences.
   *
   * @param fences The fences
   *
   * @throws VulkanException On errors
   */

  void resetFences(
    List<VulkanFenceType> fences)
    throws VulkanException;

  /**
   * Wait for this device to become idle.
   *
   * @throws VulkanException On errors
   */

  void waitIdle()
    throws VulkanException;
}
