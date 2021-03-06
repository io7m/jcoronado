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

import java.nio.ByteBuffer;

/**
 * A pointer to an area of mapped memory.
 */

public interface VulkanMappedMemoryType extends AutoCloseable
{
  /**
   * @return {@code true} iff {@link #close()} has not been called
   */

  boolean isMapped();

  /**
   * Flush the given memory range.
   *
   * @param offset The offset
   * @param size   The size
   *
   * @throws VulkanException On errors
   * @see VulkanLogicalDeviceType#flushMappedMemoryRange(VulkanMappedMemoryRange)
   */

  @VulkanAPIFunctionType(vulkanFunction = "vkFlushMappedMemoryRanges")
  void flushRange(
    long offset,
    long size)
    throws VulkanException;

  /**
   * Flush this mapped memory.
   *
   * @throws VulkanException On errors
   * @see VulkanLogicalDeviceType#flushMappedMemoryRange(VulkanMappedMemoryRange)
   */

  @VulkanAPIFunctionType(vulkanFunction = "vkFlushMappedMemoryRanges")
  void flush()
    throws VulkanException;

  /**
   * Unmap the memory.
   *
   * @throws VulkanException On errors
   */

  @VulkanAPIFunctionType(vulkanFunction = "vkUnmapMemory")
  @VulkanAPIFunctionType(vulkanFunction = "vmaUnmapMemory")
  @Override
  void close()
    throws VulkanException;

  /**
   * @return The mapped memory as a byte buffer
   */

  ByteBuffer asByteBuffer();
}
