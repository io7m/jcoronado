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

import com.io7m.immutables.styles.ImmutablesStyleType;
import org.immutables.value.Value;

import static com.io7m.jcoronado.api.VulkanComponentSwizzle.VK_COMPONENT_SWIZZLE_IDENTITY;

/**
 * A structure specifying a color component mapping.
 *
 * @see "VkComponentMapping"
 */

@VulkanAPIStructType(vulkanStruct = "VkComponentMapping")
@ImmutablesStyleType
@Value.Immutable
public interface VulkanComponentMappingType
{
  /**
   * @return A mapping with all fields set to {@link VulkanComponentSwizzle#VK_COMPONENT_SWIZZLE_IDENTITY}
   */

  static VulkanComponentMapping identity()
  {
    return VulkanComponentMapping.builder()
      .setA(VK_COMPONENT_SWIZZLE_IDENTITY)
      .setR(VK_COMPONENT_SWIZZLE_IDENTITY)
      .setG(VK_COMPONENT_SWIZZLE_IDENTITY)
      .setB(VK_COMPONENT_SWIZZLE_IDENTITY)
      .build();
  }

  /**
   * @return The component value placed in the R component of the output vector.
   */

  @Value.Parameter
  VulkanComponentSwizzle r();

  /**
   * @return The component value placed in the G component of the output vector.
   */

  @Value.Parameter
  VulkanComponentSwizzle g();

  /**
   * @return The component value placed in the G component of the output vector.
   */

  @Value.Parameter
  VulkanComponentSwizzle b();

  /**
   * @return The component value placed in the A component of the output vector.
   */

  @Value.Parameter
  VulkanComponentSwizzle a();
}
