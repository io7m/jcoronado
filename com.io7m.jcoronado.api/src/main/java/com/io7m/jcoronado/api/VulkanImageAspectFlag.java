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
 * Bitmask specifying which aspects of an image are included in a view.
 *
 * @see "VkImageAspectFlagBits"
 */

@VulkanAPIEnumType(vulkanEnum = "VkImageAspectFlagBits")
public enum VulkanImageAspectFlag implements VulkanEnumBitmaskType
{
  /**
   * Specifies the color aspect
   */

  VK_IMAGE_ASPECT_COLOR_BIT(0x00000001),

  /**
   * Specifies the depth aspect
   */

  VK_IMAGE_ASPECT_DEPTH_BIT(0x00000002),

  /**
   * Specifies the stencil aspect
   */

  VK_IMAGE_ASPECT_STENCIL_BIT(0x00000004),

  /**
   * Specifies the metadata aspect, used for sparse sparse resource operations
   */

  VK_IMAGE_ASPECT_METADATA_BIT(0x00000008),

  /**
   * Specifies plane 0
   */

  VK_IMAGE_ASPECT_PLANE_0_BIT(0x00000010),

  /**
   * Specifies plane 1
   */

  VK_IMAGE_ASPECT_PLANE_1_BIT(0x00000020),

  /**
   * Specifies plane 2
   */

  VK_IMAGE_ASPECT_PLANE_2_BIT(0x00000040);

  private final int value;

  VulkanImageAspectFlag(final int i)
  {
    this.value = i;
  }

  @Override
  public int value()
  {
    return this.value;
  }
}
