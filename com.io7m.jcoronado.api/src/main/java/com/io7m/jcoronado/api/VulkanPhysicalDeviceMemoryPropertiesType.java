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

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The memory properties for a physical device.
 *
 * @see "VkPhysicalDeviceMemoryProperties"
 */

@VulkanAPIStructType(vulkanStruct = "VkPhysicalDeviceMemoryProperties")
@ImmutablesStyleType
@Value.Immutable
public interface VulkanPhysicalDeviceMemoryPropertiesType
{
  /**
   * @return The memory heaps from which memory can be allocated.
   */

  @Value.Parameter
  List<VulkanMemoryHeap> heaps();

  /**
   * @return The memory types that can be used to access memory allocated from the heaps specified
   * by {@link #heaps()}
   */

  @Value.Parameter
  List<VulkanMemoryType> types();

  /**
   * Find a suitable memory type for the given requirements and properties.
   *
   * @param requirements The memory requirements
   * @param flags        The memory properties
   *
   * @return A memory type
   *
   * @throws VulkanMissingRequiredMemoryTypeException If no suitable memory type exists
   */

  default VulkanMemoryType findSuitableMemoryType(
    final VulkanMemoryRequirements requirements,
    final Set<VulkanMemoryPropertyFlag> flags)
    throws VulkanMissingRequiredMemoryTypeException
  {
    Objects.requireNonNull(requirements, "requirements");
    Objects.requireNonNull(flags, "flags");

    final var type_filter = requirements.memoryTypeBits();
    final var types = this.types();
    final var type_count = types.size();
    for (var index = 0; index < type_count; ++index) {
      final var type = types.get(index);
      final var bit = 1 << index;
      if (((type_filter & bit) == bit) && (type.flags().containsAll(flags))) {
        return type;
      }
    }

    throw new VulkanMissingRequiredMemoryTypeException(
      "No suitable memory type is available.",
      requirements,
      flags,
      this.heaps(),
      types);
  }
}
