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

import com.io7m.jcoronado.api.VulkanException;
import com.io7m.jcoronado.api.VulkanInstanceProviderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public abstract class VulkanInstanceContract extends VulkanOnDeviceContract
{
  protected abstract VulkanInstanceProviderType instanceProvider();

  @Test
  public final void testInstance()
    throws VulkanException
  {
    Assumptions.assumeTrue(this.shouldRun(), "Test should run");

    final var provider = this.instanceProvider();
    final var logger = this.logger();
    try (var instance = provider.createInstance(VulkanInstanceInfo.info(), Optional.empty())) {
      instance.enabledExtensions().forEach(
        (name, extension) -> logger.debug("extension: {}", extension.name()));
    }
  }

  @Test
  public final void testInstancePhysicalDevices()
    throws VulkanException
  {
    Assumptions.assumeTrue(this.shouldRun(), "Test should run");

    final var provider = this.instanceProvider();
    final var logger = this.logger();
    try (var instance = provider.createInstance(VulkanInstanceInfo.info(), Optional.empty())) {
      final var devices = instance.physicalDevices();
      Assertions.assertTrue(devices.size() > 0, "At least one device required");
      for (final var device : devices) {
        logger.debug("device: {}", device.properties().name());
      }
    }
  }
}
