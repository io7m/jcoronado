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

package com.io7m.jcoronado.tests.contracts;

import com.io7m.jcoronado.api.VulkanApplicationInfo;
import com.io7m.jcoronado.api.VulkanInstanceCreateInfo;
import com.io7m.jcoronado.api.VulkanVersions;

import java.util.List;

public final class VulkanInstanceInfo
{
  private VulkanInstanceInfo()
  {

  }

  public static VulkanInstanceCreateInfo info()
  {
    return VulkanInstanceCreateInfo.builder()
      .setApplicationInfo(
        VulkanApplicationInfo.of(
          "com.io7m.jcoronado.tests.Test",
          VulkanVersions.encode(0, 0, 1),
          "com.io7m.jcoronado.tests",
          VulkanVersions.encode(0, 0, 1),
          VulkanVersions.encode(1, 0, 0)))
      .setEnabledExtensions(List.of())
      .setEnabledLayers(List.of("VK_LAYER_LUNARG_standard_validation"))
      .build();
  }
}
