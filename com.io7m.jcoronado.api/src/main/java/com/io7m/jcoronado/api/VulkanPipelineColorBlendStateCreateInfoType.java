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
import java.util.Optional;
import java.util.Set;

/**
 * Structure specifying parameters of a newly created pipeline color blend state.
 *
 * @see "VkPipelineColorBlendStateCreateInfo"
 */

@VulkanAPIStructType(vulkanStruct = "VkPipelineColorBlendStateCreateInfo")
@ImmutablesStyleType
@Value.Immutable
public interface VulkanPipelineColorBlendStateCreateInfoType
{
  /**
   * @return The logical operation to apply (if any)
   */

  @Value.Parameter
  Optional<VulkanLogicOp> logicOp();

  /**
   * @return The creation flags
   */

  @Value.Parameter
  Set<VulkanPipelineColorBlendStateCreateFlag> flags();

  /**
   * @return The per-target attachment states.
   */

  @Value.Parameter
  List<VulkanPipelineColorBlendAttachmentState> attachments();

  /**
   * @return The constants used for blending
   */

  @Value.Parameter
  @Value.Default
  default VulkanBlendConstants blendConstants()
  {
    return VulkanBlendConstants.of(0.0f, 0.0f, 0.0f, 0.0f);
  }
}
