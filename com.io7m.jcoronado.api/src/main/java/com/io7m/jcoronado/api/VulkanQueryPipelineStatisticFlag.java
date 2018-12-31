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
 * Bitmask specifying queried pipeline statistics.
 *
 * @see "VkQueryPipelineStatisticFlagBits"
 */

@VulkanAPIEnumType(vulkanEnum = "VkQueryPipelineStatisticFlagBits")
public enum VulkanQueryPipelineStatisticFlag implements VulkanEnumBitmaskType
{
  /**
   * Specifies that queries managed by the pool will count the number of vertices processed by the
   * input assembly stage. Vertices corresponding to incomplete primitives may contribute to the
   * count.
   */

  VK_QUERY_PIPELINE_STATISTIC_INPUT_ASSEMBLY_VERTICES_BIT(0x00000001),

  /**
   * Specifies that queries managed by the pool will count the number of primitives processed by the
   * input assembly stage. If primitive restart is enabled, restarting the primitive topology has no
   * effect on the count. Incomplete primitives may be counted.
   */

  VK_QUERY_PIPELINE_STATISTIC_INPUT_ASSEMBLY_PRIMITIVES_BIT(0x00000002),

  /**
   * Specifies that queries managed by the pool will count the number of vertex shader invocations.
   * This counter’s value is incremented each time a vertex shader is invoked.
   */

  VK_QUERY_PIPELINE_STATISTIC_VERTEX_SHADER_INVOCATIONS_BIT(0x00000004),

  /**
   * Specifies that queries managed by the pool will count the number of geometry shader
   * invocations. This counter’s value is incremented each time a geometry shader is invoked. In the
   * case of instanced geometry shaders, the geometry shader invocations count is incremented for
   * each separate instanced invocation.
   */

  VK_QUERY_PIPELINE_STATISTIC_GEOMETRY_SHADER_INVOCATIONS_BIT(0x00000008),

  /**
   * Specifies that queries managed by the pool will count the number of primitives generated by
   * geometry shader invocations. The counter’s value is incremented each time the geometry shader
   * emits a primitive. Restarting primitive topology using the SPIR-V instructions OpEndPrimitive
   * or OpEndStreamPrimitive has no effect on the geometry shader output primitives count.
   */

  VK_QUERY_PIPELINE_STATISTIC_GEOMETRY_SHADER_PRIMITIVES_BIT(0x00000010),

  /**
   * Specifies that queries managed by the pool will count the number of primitives processed by the
   * Primitive Clipping stage of the pipeline. The counter’s value is incremented each time a
   * primitive reaches the primitive clipping stage.
   */

  VK_QUERY_PIPELINE_STATISTIC_CLIPPING_INVOCATIONS_BIT(0x00000020),

  /**
   * Specifies that queries managed by the pool will count the number of primitives output by the
   * Primitive Clipping stage of the pipeline. The counter’s value is incremented each time a
   * primitive passes the primitive clipping stage.
   */

  VK_QUERY_PIPELINE_STATISTIC_CLIPPING_PRIMITIVES_BIT(0x00000040),

  /**
   * Specifies that queries managed by the pool will count the number of fragment shader
   * invocations. The counter’s value is incremented each time the fragment shader is invoked.
   */

  VK_QUERY_PIPELINE_STATISTIC_FRAGMENT_SHADER_INVOCATIONS_BIT(0x00000080),

  /**
   * Specifies that queries managed by the pool will count the number of patches processed by the
   * tessellation control shader. The counter’s value is incremented once for each patch for which a
   * tessellation control shader is invoked.
   */

  VK_QUERY_PIPELINE_STATISTIC_TESSELLATION_CONTROL_SHADER_PATCHES_BIT(0x00000100),

  /**
   * Specifies that queries managed by the pool will count the number of invocations of the
   * tessellation evaluation shader. The counter’s value is incremented each time the tessellation
   * evaluation shader is invoked.
   */

  VK_QUERY_PIPELINE_STATISTIC_TESSELLATION_EVALUATION_SHADER_INVOCATIONS_BIT(0x00000200),

  /**
   * Specifies that queries managed by the pool will count the number of compute shader invocations.
   * The counter’s value is incremented every time the compute shader is invoked. Implementations
   * may skip the execution of certain compute shader invocations or execute additional compute
   * shader invocations for implementation-dependent reasons as long as the results of rendering
   * otherwise remain unchanged.
   */

  VK_QUERY_PIPELINE_STATISTIC_COMPUTE_SHADER_INVOCATIONS_BIT(0x00000400);

  private final int value;

  VulkanQueryPipelineStatisticFlag(
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