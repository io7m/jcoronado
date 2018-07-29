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

package com.io7m.jcoronado.extensions.api;

import com.io7m.immutables.styles.ImmutablesStyleType;
import com.io7m.jcoronado.api.VulkanSemaphoreType;
import org.immutables.value.Value;

import java.util.List;

import static com.io7m.jcoronado.extensions.api.VulkanExtKHRSwapChainType.VulkanKHRSwapChainType;

/**
 * @see "VkPresentInfoKHR"
 */

@ImmutablesStyleType
@Value.Immutable
public interface VulkanPresentInfoKHRType
{
  /**
   * @return The semaphores upon which to wait before issuing the present request.
   */

  @Value.Parameter
  List<VulkanSemaphoreType> waitSemaphores();

  /**
   * @return The list of swapchains
   */

  @Value.Parameter
  List<VulkanKHRSwapChainType> swapChains();

  /**
   * Each entry in this array identifies the image to present on the corresponding entry in the
   * {@link #swapChains()} list.
   *
   * @return An array of images to be presented
   */

  @Value.Parameter
  List<Integer> imageIndices();
}
