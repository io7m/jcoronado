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

import com.io7m.jcoronado.api.VulkanBufferType;
import org.lwjgl.vulkan.VkDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * LWJGL {@link VulkanBufferType}.
 */

public final class VulkanLWJGLBuffer extends VulkanLWJGLHandle implements
  VulkanBufferType
{
  private static final Logger LOG = LoggerFactory.getLogger(VulkanLWJGLBuffer.class);

  private final long handle;
  private final VkDevice device;
  private final Runnable deallocate;

  VulkanLWJGLBuffer(
    final Ownership ownership,
    final VkDevice in_device,
    final long in_handle,
    final Runnable in_deallocate,
    final VulkanLWJGLHostAllocatorProxy in_host_allocator_proxy)
  {
    super(ownership, in_host_allocator_proxy);
    this.device = Objects.requireNonNull(in_device, "device");
    this.handle = in_handle;
    this.deallocate = Objects.requireNonNull(in_deallocate, "deallocate");
  }

  @Override
  public boolean equals(final Object o)
  {
    if (this == o) {
      return true;
    }
    if (o == null || !Objects.equals(this.getClass(), o.getClass())) {
      return false;
    }
    final var that = (VulkanLWJGLBuffer) o;
    return this.handle == that.handle;
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(Long.valueOf(this.handle));
  }

  @Override
  public String toString()
  {
    return new StringBuilder(32)
      .append("[VulkanLWJGLBuffer 0x")
      .append(Long.toUnsignedString(this.handle, 16))
      .append("]")
      .toString();
  }

  @Override
  protected Logger logger()
  {
    return LOG;
  }

  @Override
  protected void closeActual()
  {
    if (LOG.isTraceEnabled()) {
      LOG.trace("destroying buffer: {}", this);
    }

    this.deallocate.run();
  }

  /**
   * @return The underlying Vulkan handle
   */

  public long handle()
  {
    return this.handle;
  }
}
