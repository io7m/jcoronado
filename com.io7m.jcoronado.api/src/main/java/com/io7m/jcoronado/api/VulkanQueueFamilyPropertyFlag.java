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

/**
 * The queue family property flags.
 *
 * @see "VkQueueFlagBits"
 */

@VulkanAPIEnumType(vulkanEnum = "VkQueueFlagBits")
public enum VulkanQueueFamilyPropertyFlag implements VulkanEnumBitmaskType
{
  /**
   * Queues in this queue family support graphics operations.
   */

  VK_QUEUE_GRAPHICS_BIT(0x00000001),

  /**
   * Queues in this queue family support compute operations.
   */

  VK_QUEUE_COMPUTE_BIT(0x00000002),

  /**
   * Queues in this queue family support transfer operations.
   */

  VK_QUEUE_TRANSFER_BIT(0x00000004),

  /**
   * Queues in this queue family support sparse memory management operations.
   */

  VK_QUEUE_SPARSE_BINDING_BIT(0x00000008),

  /**
   * Queues in this queue family support the VK_DEVICE_QUEUE_CREATE_PROTECTED_BIT bit.
   */

  VK_QUEUE_PROTECTED_BIT(0x00000010);

  private final int value;

  VulkanQueueFamilyPropertyFlag(
    final int i)
  {
    this.value = i;
  }

  @Override
  public int value()
  {
    return this.value;
  }
}
