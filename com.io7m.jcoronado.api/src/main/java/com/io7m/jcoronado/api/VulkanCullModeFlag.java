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
 * @see "VkCullModeFlagBits"
 */

@VulkanAPIEnumType(vulkanEnum = "VkCullModeFlagBits")
public enum VulkanCullModeFlag implements VulkanEnumBitmaskType
{
  /**
   * Specifies that no triangles are discarded
   */

  VK_CULL_MODE_NONE(0),

  /**
   * Specifies that front-facing triangles are discarded
   */

  VK_CULL_MODE_FRONT_BIT(0x00000001),

  /**
   * Specifies that back-facing triangles are discarded
   */

  VK_CULL_MODE_BACK_BIT(0x00000002),

  /**
   * Specifies that all triangles are discarded
   */

  VK_CULL_MODE_FRONT_AND_BACK(0x00000003);

  private final int value;

  VulkanCullModeFlag(final int i)
  {
    this.value = i;
  }

  @Override
  public int value()
  {
    return this.value;
  }
}
