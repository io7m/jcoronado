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

import java.util.Map;
import java.util.Optional;

/**
 * Note: This enum is not hand-written: See formats.sh
 *
 * @see "VkFormat"
 */

@VulkanAPIEnumType(vulkanEnum = "VkFormat")
public enum VulkanFormat implements VulkanEnumIntegerType
{
  /**
   * The format is not specified.
   */

  VK_FORMAT_UNDEFINED(0),

  /**
   * A two-component, 8-bit packed unsigned normalized format that has a 4-bit R component in bits
   * 4..7, and a 4-bit G component in bits 0..3.
   */

  VK_FORMAT_R4G4_UNORM_PACK8(1),

  /**
   * A four-component, 16-bit packed unsigned normalized format that has a 4-bit R component in bits
   * 12..15, a 4-bit G component in bits 8..11, a 4-bit B component in bits 4..7, and a 4-bit A
   * component in bits 0..3.
   */

  VK_FORMAT_R4G4B4A4_UNORM_PACK16(2),

  /**
   * A four-component, 16-bit packed unsigned normalized format that has a 4-bit B component in bits
   * 12..15, a 4-bit G component in bits 8..11, a 4-bit R component in bits 4..7, and a 4-bit A
   * component in bits 0..3.
   */

  VK_FORMAT_B4G4R4A4_UNORM_PACK16(3),

  /**
   * A three-component, 16-bit packed unsigned normalized format that has a 5-bit R component in
   * bits 11..15, a 6-bit G component in bits 5..10, and a 5-bit B component in bits 0..4.
   */

  VK_FORMAT_R5G6B5_UNORM_PACK16(4),

  /**
   * A three-component, 16-bit packed unsigned normalized format that has a 5-bit B component in
   * bits 11..15, a 6-bit G component in bits 5..10, and a 5-bit R component in bits 0..4.
   */

  VK_FORMAT_B5G6R5_UNORM_PACK16(5),

  /**
   * A four-component, 16-bit packed unsigned normalized format that has a 5-bit R component in bits
   * 11..15, a 5-bit G component in bits 6..10, a 5-bit B component in bits 1..5, and a 1-bit A
   * component in bit 0.
   */

  VK_FORMAT_R5G5B5A1_UNORM_PACK16(6),

  /**
   * A four-component, 16-bit packed unsigned normalized format that has a 5-bit B component in bits
   * 11..15, a 5-bit G component in bits 6..10, a 5-bit R component in bits 1..5, and a 1-bit A
   * component in bit 0.
   */

  VK_FORMAT_B5G5R5A1_UNORM_PACK16(7),

  /**
   * A four-component, 16-bit packed unsigned normalized format that has a 1-bit A component in bit
   * 15, a 5-bit R component in bits 10..14, a 5-bit G component in bits 5..9, and a 5-bit B
   * component in bits 0..4.
   */

  VK_FORMAT_A1R5G5B5_UNORM_PACK16(8),

  /**
   * A one-component, 8-bit unsigned normalized format that has a single 8-bit R component.
   */

  VK_FORMAT_R8_UNORM(9),

  /**
   * A one-component, 8-bit signed normalized format that has a single 8-bit R component.
   */

  VK_FORMAT_R8_SNORM(10),

  /**
   * A one-component, 8-bit unsigned scaled integer format that has a single 8-bit R component.
   */

  VK_FORMAT_R8_USCALED(11),

  /**
   * A one-component, 8-bit signed scaled integer format that has a single 8-bit R component.
   */

  VK_FORMAT_R8_SSCALED(12),

  /**
   * A one-component, 8-bit unsigned integer format that has a single 8-bit R component.
   */

  VK_FORMAT_R8_UINT(13),

  /**
   * A one-component, 8-bit signed integer format that has a single 8-bit R component.
   */

  VK_FORMAT_R8_SINT(14),

  /**
   * A one-component, 8-bit unsigned normalized format that has a single 8-bit R component stored
   * with sRGB nonlinear encoding.
   */

  VK_FORMAT_R8_SRGB(15),

  /**
   * A two-component, 16-bit unsigned normalized format that has an 8-bit R component in byte 0, and
   * an 8-bit G component in byte 1.
   */

  VK_FORMAT_R8G8_UNORM(16),

  /**
   * A two-component, 16-bit signed normalized format that has an 8-bit R component in byte 0, and
   * an 8-bit G component in byte 1.
   */

  VK_FORMAT_R8G8_SNORM(17),

  /**
   * A two-component, 16-bit unsigned scaled integer format that has an 8-bit R component in byte 0,
   * and an 8-bit G component in byte 1.
   */

  VK_FORMAT_R8G8_USCALED(18),

  /**
   * A two-component, 16-bit signed scaled integer format that has an 8-bit R component in byte 0,
   * and an 8-bit G component in byte 1.
   */

  VK_FORMAT_R8G8_SSCALED(19),

  /**
   * A two-component, 16-bit unsigned integer format that has an 8-bit R component in byte 0, and an
   * 8-bit G component in byte 1.
   */

  VK_FORMAT_R8G8_UINT(20),

  /**
   * A two-component, 16-bit signed integer format that has an 8-bit R component in byte 0, and an
   * 8-bit G component in byte 1.
   */

  VK_FORMAT_R8G8_SINT(21),

  /**
   * A two-component, 16-bit unsigned normalized format that has an 8-bit R component stored with
   * sRGB nonlinear encoding in byte 0, and an 8-bit G component stored with sRGB nonlinear encoding
   * in byte 1.
   */

  VK_FORMAT_R8G8_SRGB(22),

  /**
   * A three-component, 24-bit unsigned normalized format that has an 8-bit R component in byte 0,
   * an 8-bit G component in byte 1, and an 8-bit B component in byte 2.
   */

  VK_FORMAT_R8G8B8_UNORM(23),

  /**
   * A three-component, 24-bit signed normalized format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit B component in byte 2.
   */

  VK_FORMAT_R8G8B8_SNORM(24),

  /**
   * A three-component, 24-bit unsigned scaled format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit B component in byte 2.
   */

  VK_FORMAT_R8G8B8_USCALED(25),

  /**
   * A three-component, 24-bit signed scaled format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit B component in byte 2.
   */

  VK_FORMAT_R8G8B8_SSCALED(26),

  /**
   * A three-component, 24-bit unsigned integer format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit B component in byte 2.
   */

  VK_FORMAT_R8G8B8_UINT(27),

  /**
   * A three-component, 24-bit signed integer format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit B component in byte 2.
   */

  VK_FORMAT_R8G8B8_SINT(28),

  /**
   * A three-component, 24-bit unsigned normalized format that has an 8-bit R component stored with
   * sRGB nonlinear encoding in byte 0, an 8-bit G component stored with sRGB nonlinear encoding in
   * byte 1, and an 8-bit B component stored with sRGB nonlinear encoding in byte 2.
   */

  VK_FORMAT_R8G8B8_SRGB(29),

  /**
   * A three-component, 24-bit unsigned normalized format that has an 8-bit B component in byte 0,
   * an 8-bit G component in byte 1, and an 8-bit R component in byte 2.
   */

  VK_FORMAT_B8G8R8_UNORM(30),

  /**
   * A three-component, 24-bit signed normalized format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit R component in byte 2.
   */

  VK_FORMAT_B8G8R8_SNORM(31),

  /**
   * A three-component, 24-bit unsigned scaled format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit R component in byte 2.
   */

  VK_FORMAT_B8G8R8_USCALED(32),

  /**
   * A three-component, 24-bit signed scaled format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit R component in byte 2.
   */

  VK_FORMAT_B8G8R8_SSCALED(33),

  /**
   * A three-component, 24-bit unsigned integer format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit R component in byte 2.
   */

  VK_FORMAT_B8G8R8_UINT(34),

  /**
   * A three-component, 24-bit signed integer format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, and an 8-bit R component in byte 2.
   */

  VK_FORMAT_B8G8R8_SINT(35),

  /**
   * A three-component, 24-bit unsigned normalized format that has an 8-bit B component stored with
   * sRGB nonlinear encoding in byte 0, an 8-bit G component stored with sRGB nonlinear encoding in
   * byte 1, and an 8-bit R component stored with sRGB nonlinear encoding in byte 2.
   */

  VK_FORMAT_B8G8R8_SRGB(36),

  /**
   * A four-component, 32-bit unsigned normalized format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit B component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_R8G8B8A8_UNORM(37),

  /**
   * A four-component, 32-bit signed normalized format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit B component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_R8G8B8A8_SNORM(38),

  /**
   * A four-component, 32-bit unsigned scaled format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit B component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_R8G8B8A8_USCALED(39),

  /**
   * A four-component, 32-bit signed scaled format that has an 8-bit R component in byte 0, an 8-bit
   * G component in byte 1, an 8-bit B component in byte 2, and an 8-bit A component in byte 3.
   */

  VK_FORMAT_R8G8B8A8_SSCALED(40),

  /**
   * A four-component, 32-bit unsigned integer format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit B component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_R8G8B8A8_UINT(41),

  /**
   * A four-component, 32-bit signed integer format that has an 8-bit R component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit B component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_R8G8B8A8_SINT(42),

  /**
   * A four-component, 32-bit unsigned normalized format that has an 8-bit R component stored with
   * sRGB nonlinear encoding in byte 0, an 8-bit G component stored with sRGB nonlinear encoding in
   * byte 1, an 8-bit B component stored with sRGB nonlinear encoding in byte 2, and an 8-bit A
   * component in byte 3.
   */

  VK_FORMAT_R8G8B8A8_SRGB(43),

  /**
   * A four-component, 32-bit unsigned normalized format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit R component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_B8G8R8A8_UNORM(44),

  /**
   * A four-component, 32-bit signed normalized format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit R component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_B8G8R8A8_SNORM(45),

  /**
   * A four-component, 32-bit unsigned scaled format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit R component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_B8G8R8A8_USCALED(46),

  /**
   * A four-component, 32-bit signed scaled format that has an 8-bit B component in byte 0, an 8-bit
   * G component in byte 1, an 8-bit R component in byte 2, and an 8-bit A component in byte 3.
   */

  VK_FORMAT_B8G8R8A8_SSCALED(47),

  /**
   * A four-component, 32-bit unsigned integer format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit R component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_B8G8R8A8_UINT(48),

  /**
   * A four-component, 32-bit signed integer format that has an 8-bit B component in byte 0, an
   * 8-bit G component in byte 1, an 8-bit R component in byte 2, and an 8-bit A component in byte
   * 3.
   */

  VK_FORMAT_B8G8R8A8_SINT(49),

  /**
   * A four-component, 32-bit unsigned normalized format that has an 8-bit B component stored with
   * sRGB nonlinear encoding in byte 0, an 8-bit G component stored with sRGB nonlinear encoding in
   * byte 1, an 8-bit R component stored with sRGB nonlinear encoding in byte 2, and an 8-bit A
   * component in byte 3.
   */

  VK_FORMAT_B8G8R8A8_SRGB(50),

  /**
   * A four-component, 32-bit packed unsigned normalized format that has an 8-bit A component in
   * bits 24..31, an 8-bit B component in bits 16..23, an 8-bit G component in bits 8..15, and an
   * 8-bit R component in bits 0..7.
   */

  VK_FORMAT_A8B8G8R8_UNORM_PACK32(51),

  /**
   * A four-component, 32-bit packed signed normalized format that has an 8-bit A component in bits
   * 24..31, an 8-bit B component in bits 16..23, an 8-bit G component in bits 8..15, and an 8-bit R
   * component in bits 0..7.
   */

  VK_FORMAT_A8B8G8R8_SNORM_PACK32(52),

  /**
   * A four-component, 32-bit packed unsigned scaled integer format that has an 8-bit A component in
   * bits 24..31, an 8-bit B component in bits 16..23, an 8-bit G component in bits 8..15, and an
   * 8-bit R component in bits 0..7.
   */

  VK_FORMAT_A8B8G8R8_USCALED_PACK32(53),

  /**
   * A four-component, 32-bit packed signed scaled integer format that has an 8-bit A component in
   * bits 24..31, an 8-bit B component in bits 16..23, an 8-bit G component in bits 8..15, and an
   * 8-bit R component in bits 0..7.
   */

  VK_FORMAT_A8B8G8R8_SSCALED_PACK32(54),

  /**
   * A four-component, 32-bit packed unsigned integer format that has an 8-bit A component in bits
   * 24..31, an 8-bit B component in bits 16..23, an 8-bit G component in bits 8..15, and an 8-bit R
   * component in bits 0..7.
   */

  VK_FORMAT_A8B8G8R8_UINT_PACK32(55),

  /**
   * A four-component, 32-bit packed signed integer format that has an 8-bit A component in bits
   * 24..31, an 8-bit B component in bits 16..23, an 8-bit G component in bits 8..15, and an 8-bit R
   * component in bits 0..7.
   */

  VK_FORMAT_A8B8G8R8_SINT_PACK32(56),

  /**
   * A four-component, 32-bit packed unsigned normalized format that has an 8-bit A component in
   * bits 24..31, an 8-bit B component stored with sRGB nonlinear encoding in bits 16..23, an 8-bit
   * G component stored with sRGB nonlinear encoding in bits 8..15, and an 8-bit R component stored
   * with sRGB nonlinear encoding in bits 0..7.
   */

  VK_FORMAT_A8B8G8R8_SRGB_PACK32(57),

  /**
   * A four-component, 32-bit packed unsigned normalized format that has a 2-bit A component in bits
   * 30..31, a 10-bit R component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * B component in bits 0..9.
   */

  VK_FORMAT_A2R10G10B10_UNORM_PACK32(58),

  /**
   * A four-component, 32-bit packed signed normalized format that has a 2-bit A component in bits
   * 30..31, a 10-bit R component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * B component in bits 0..9.
   */

  VK_FORMAT_A2R10G10B10_SNORM_PACK32(59),

  /**
   * A four-component, 32-bit packed unsigned scaled integer format that has a 2-bit A component in
   * bits 30..31, a 10-bit R component in bits 20..29, a 10-bit G component in bits 10..19, and a
   * 10-bit B component in bits 0..9.
   */

  VK_FORMAT_A2R10G10B10_USCALED_PACK32(60),

  /**
   * A four-component, 32-bit packed signed scaled integer format that has a 2-bit A component in
   * bits 30..31, a 10-bit R component in bits 20..29, a 10-bit G component in bits 10..19, and a
   * 10-bit B component in bits 0..9.
   */

  VK_FORMAT_A2R10G10B10_SSCALED_PACK32(61),

  /**
   * A four-component, 32-bit packed unsigned integer format that has a 2-bit A component in bits
   * 30..31, a 10-bit R component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * B component in bits 0..9.
   */

  VK_FORMAT_A2R10G10B10_UINT_PACK32(62),

  /**
   * A four-component, 32-bit packed signed integer format that has a 2-bit A component in bits
   * 30..31, a 10-bit R component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * B component in bits 0..9.
   */

  VK_FORMAT_A2R10G10B10_SINT_PACK32(63),

  /**
   * A four-component, 32-bit packed unsigned normalized format that has a 2-bit A component in bits
   * 30..31, a 10-bit B component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * R component in bits 0..9.
   */

  VK_FORMAT_A2B10G10R10_UNORM_PACK32(64),

  /**
   * A four-component, 32-bit packed signed normalized format that has a 2-bit A component in bits
   * 30..31, a 10-bit B component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * R component in bits 0..9.
   */

  VK_FORMAT_A2B10G10R10_SNORM_PACK32(65),

  /**
   * A four-component, 32-bit packed unsigned scaled integer format that has a 2-bit A component in
   * bits 30..31, a 10-bit B component in bits 20..29, a 10-bit G component in bits 10..19, and a
   * 10-bit R component in bits 0..9.
   */

  VK_FORMAT_A2B10G10R10_USCALED_PACK32(66),

  /**
   * A four-component, 32-bit packed signed scaled integer format that has a 2-bit A component in
   * bits 30..31, a 10-bit B component in bits 20..29, a 10-bit G component in bits 10..19, and a
   * 10-bit R component in bits 0..9.
   */

  VK_FORMAT_A2B10G10R10_SSCALED_PACK32(67),

  /**
   * A four-component, 32-bit packed unsigned integer format that has a 2-bit A component in bits
   * 30..31, a 10-bit B component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * R component in bits 0..9.
   */

  VK_FORMAT_A2B10G10R10_UINT_PACK32(68),

  /**
   * A four-component, 32-bit packed signed integer format that has a 2-bit A component in bits
   * 30..31, a 10-bit B component in bits 20..29, a 10-bit G component in bits 10..19, and a 10-bit
   * R component in bits 0..9.
   */

  VK_FORMAT_A2B10G10R10_SINT_PACK32(69),

  /**
   * A one-component, 16-bit unsigned normalized format that has a single 16-bit R component.
   */

  VK_FORMAT_R16_UNORM(70),

  /**
   * A one-component, 16-bit signed normalized format that has a single 16-bit R component.
   */

  VK_FORMAT_R16_SNORM(71),

  /**
   * A one-component, 16-bit unsigned scaled integer format that has a single 16-bit R component.
   */

  VK_FORMAT_R16_USCALED(72),

  /**
   * A one-component, 16-bit signed scaled integer format that has a single 16-bit R component.
   */

  VK_FORMAT_R16_SSCALED(73),

  /**
   * A one-component, 16-bit unsigned integer format that has a single 16-bit R component.
   */

  VK_FORMAT_R16_UINT(74),

  /**
   * A one-component, 16-bit signed integer format that has a single 16-bit R component.
   */

  VK_FORMAT_R16_SINT(75),

  /**
   * A one-component, 16-bit signed floating-point format that has a single 16-bit R component.
   */

  VK_FORMAT_R16_SFLOAT(76),

  /**
   * A two-component, 32-bit unsigned normalized format that has a 16-bit R component in bytes 0..1,
   * and a 16-bit G component in bytes 2..3.
   */

  VK_FORMAT_R16G16_UNORM(77),

  /**
   * A two-component, 32-bit signed normalized format that has a 16-bit R component in bytes 0..1,
   * and a 16-bit G component in bytes 2..3.
   */

  VK_FORMAT_R16G16_SNORM(78),

  /**
   * A two-component, 32-bit unsigned scaled integer format that has a 16-bit R component in bytes
   * 0..1, and a 16-bit G component in bytes 2..3.
   */

  VK_FORMAT_R16G16_USCALED(79),

  /**
   * A two-component, 32-bit signed scaled integer format that has a 16-bit R component in bytes
   * 0..1, and a 16-bit G component in bytes 2..3.
   */

  VK_FORMAT_R16G16_SSCALED(80),

  /**
   * A two-component, 32-bit unsigned integer format that has a 16-bit R component in bytes 0..1,
   * and a 16-bit G component in bytes 2..3.
   */

  VK_FORMAT_R16G16_UINT(81),

  /**
   * A two-component, 32-bit signed integer format that has a 16-bit R component in bytes 0..1, and
   * a 16-bit G component in bytes 2..3.
   */

  VK_FORMAT_R16G16_SINT(82),

  /**
   * A two-component, 32-bit signed floating-point format that has a 16-bit R component in bytes
   * 0..1, and a 16-bit G component in bytes 2..3.
   */

  VK_FORMAT_R16G16_SFLOAT(83),

  /**
   * A three-component, 48-bit unsigned normalized format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, and a 16-bit B component in bytes 4..5.
   */

  VK_FORMAT_R16G16B16_UNORM(84),

  /**
   * A three-component, 48-bit signed normalized format that has a 16-bit R component in bytes 0..1,
   * a 16-bit G component in bytes 2..3, and a 16-bit B component in bytes 4..5.
   */

  VK_FORMAT_R16G16B16_SNORM(85),

  /**
   * A three-component, 48-bit unsigned scaled integer format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, and a 16-bit B component in bytes 4..5.
   */

  VK_FORMAT_R16G16B16_USCALED(86),

  /**
   * A three-component, 48-bit signed scaled integer format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, and a 16-bit B component in bytes 4..5.
   */

  VK_FORMAT_R16G16B16_SSCALED(87),

  /**
   * A three-component, 48-bit unsigned integer format that has a 16-bit R component in bytes 0..1,
   * a 16-bit G component in bytes 2..3, and a 16-bit B component in bytes 4..5.
   */

  VK_FORMAT_R16G16B16_UINT(88),

  /**
   * A three-component, 48-bit signed integer format that has a 16-bit R component in bytes 0..1, a
   * 16-bit G component in bytes 2..3, and a 16-bit B component in bytes 4..5.
   */

  VK_FORMAT_R16G16B16_SINT(89),

  /**
   * A three-component, 48-bit signed floating-point format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, and a 16-bit B component in bytes 4..5.
   */

  VK_FORMAT_R16G16B16_SFLOAT(90),

  /**
   * A four-component, 64-bit unsigned normalized format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, a 16-bit B component in bytes 4..5, and a 16-bit A
   * component in bytes 6..7.
   */

  VK_FORMAT_R16G16B16A16_UNORM(91),

  /**
   * A four-component, 64-bit signed normalized format that has a 16-bit R component in bytes 0..1,
   * a 16-bit G component in bytes 2..3, a 16-bit B component in bytes 4..5, and a 16-bit A
   * component in bytes 6..7.
   */

  VK_FORMAT_R16G16B16A16_SNORM(92),

  /**
   * A four-component, 64-bit unsigned scaled integer format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, a 16-bit B component in bytes 4..5, and a 16-bit A
   * component in bytes 6..7.
   */

  VK_FORMAT_R16G16B16A16_USCALED(93),

  /**
   * A four-component, 64-bit signed scaled integer format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, a 16-bit B component in bytes 4..5, and a 16-bit A
   * component in bytes 6..7.
   */

  VK_FORMAT_R16G16B16A16_SSCALED(94),

  /**
   * A four-component, 64-bit unsigned integer format that has a 16-bit R component in bytes 0..1, a
   * 16-bit G component in bytes 2..3, a 16-bit B component in bytes 4..5, and a 16-bit A component
   * in bytes 6..7.
   */

  VK_FORMAT_R16G16B16A16_UINT(95),

  /**
   * A four-component, 64-bit signed integer format that has a 16-bit R component in bytes 0..1, a
   * 16-bit G component in bytes 2..3, a 16-bit B component in bytes 4..5, and a 16-bit A component
   * in bytes 6..7.
   */

  VK_FORMAT_R16G16B16A16_SINT(96),

  /**
   * A four-component, 64-bit signed floating-point format that has a 16-bit R component in bytes
   * 0..1, a 16-bit G component in bytes 2..3, a 16-bit B component in bytes 4..5, and a 16-bit A
   * component in bytes 6..7.
   */

  VK_FORMAT_R16G16B16A16_SFLOAT(97),

  /**
   * A one-component, 32-bit unsigned integer format that has a single 32-bit R component.
   */

  VK_FORMAT_R32_UINT(98),

  /**
   * A one-component, 32-bit signed integer format that has a single 32-bit R component.
   */

  VK_FORMAT_R32_SINT(99),

  /**
   * A one-component, 32-bit signed floating-point format that has a single 32-bit R component.
   */

  VK_FORMAT_R32_SFLOAT(100),

  /**
   * A two-component, 64-bit unsigned integer format that has a 32-bit R component in bytes 0..3,
   * and a 32-bit G component in bytes 4..7.
   */

  VK_FORMAT_R32G32_UINT(101),

  /**
   * A two-component, 64-bit signed integer format that has a 32-bit R component in bytes 0..3, and
   * a 32-bit G component in bytes 4..7.
   */

  VK_FORMAT_R32G32_SINT(102),

  /**
   * A two-component, 64-bit signed floating-point format that has a 32-bit R component in bytes
   * 0..3, and a 32-bit G component in bytes 4..7.
   */

  VK_FORMAT_R32G32_SFLOAT(103),

  /**
   * A three-component, 96-bit unsigned integer format that has a 32-bit R component in bytes 0..3,
   * a 32-bit G component in bytes 4..7, and a 32-bit B component in bytes 8..11.
   */

  VK_FORMAT_R32G32B32_UINT(104),

  /**
   * A three-component, 96-bit signed integer format that has a 32-bit R component in bytes 0..3, a
   * 32-bit G component in bytes 4..7, and a 32-bit B component in bytes 8..11.
   */

  VK_FORMAT_R32G32B32_SINT(105),

  /**
   * A three-component, 96-bit signed floating-point format that has a 32-bit R component in bytes
   * 0..3, a 32-bit G component in bytes 4..7, and a 32-bit B component in bytes 8..11.
   */

  VK_FORMAT_R32G32B32_SFLOAT(106),

  /**
   * A four-component, 128-bit unsigned integer format that has a 32-bit R component in bytes 0..3,
   * a 32-bit G component in bytes 4..7, a 32-bit B component in bytes 8..11, and a 32-bit A
   * component in bytes 12..15.
   */

  VK_FORMAT_R32G32B32A32_UINT(107),

  /**
   * A four-component, 128-bit signed integer format that has a 32-bit R component in bytes 0..3, a
   * 32-bit G component in bytes 4..7, a 32-bit B component in bytes 8..11, and a 32-bit A component
   * in bytes 12..15.
   */

  VK_FORMAT_R32G32B32A32_SINT(108),

  /**
   * A four-component, 128-bit signed floating-point format that has a 32-bit R component in bytes
   * 0..3, a 32-bit G component in bytes 4..7, a 32-bit B component in bytes 8..11, and a 32-bit A
   * component in bytes 12..15.
   */

  VK_FORMAT_R32G32B32A32_SFLOAT(109),

  /**
   * A one-component, 64-bit unsigned integer format that has a single 64-bit R component.
   */

  VK_FORMAT_R64_UINT(110),

  /**
   * A one-component, 64-bit signed integer format that has a single 64-bit R component.
   */

  VK_FORMAT_R64_SINT(111),

  /**
   * A one-component, 64-bit signed floating-point format that has a single 64-bit R component.
   */

  VK_FORMAT_R64_SFLOAT(112),

  /**
   * A two-component, 128-bit unsigned integer format that has a 64-bit R component in bytes 0..7,
   * and a 64-bit G component in bytes 8..15.
   */

  VK_FORMAT_R64G64_UINT(113),

  /**
   * A two-component, 128-bit signed integer format that has a 64-bit R component in bytes 0..7, and
   * a 64-bit G component in bytes 8..15.
   */

  VK_FORMAT_R64G64_SINT(114),

  /**
   * A two-component, 128-bit signed floating-point format that has a 64-bit R component in bytes
   * 0..7, and a 64-bit G component in bytes 8..15.
   */

  VK_FORMAT_R64G64_SFLOAT(115),

  /**
   * A three-component, 192-bit unsigned integer format that has a 64-bit R component in bytes 0..7,
   * a 64-bit G component in bytes 8..15, and a 64-bit B component in bytes 16..23.
   */

  VK_FORMAT_R64G64B64_UINT(116),

  /**
   * A three-component, 192-bit signed integer format that has a 64-bit R component in bytes 0..7, a
   * 64-bit G component in bytes 8..15, and a 64-bit B component in bytes 16..23.
   */

  VK_FORMAT_R64G64B64_SINT(117),

  /**
   * A three-component, 192-bit signed floating-point format that has a 64-bit R component in bytes
   * 0..7, a 64-bit G component in bytes 8..15, and a 64-bit B component in bytes 16..23.
   */

  VK_FORMAT_R64G64B64_SFLOAT(118),

  /**
   * A four-component, 256-bit unsigned integer format that has a 64-bit R component in bytes 0..7,
   * a 64-bit G component in bytes 8..15, a 64-bit B component in bytes 16..23, and a 64-bit A
   * component in bytes 24..31.
   */

  VK_FORMAT_R64G64B64A64_UINT(119),

  /**
   * A four-component, 256-bit signed integer format that has a 64-bit R component in bytes 0..7, a
   * 64-bit G component in bytes 8..15, a 64-bit B component in bytes 16..23, and a 64-bit A
   * component in bytes 24..31.
   */

  VK_FORMAT_R64G64B64A64_SINT(120),

  /**
   * A four-component, 256-bit signed floating-point format that has a 64-bit R component in bytes
   * 0..7, a 64-bit G component in bytes 8..15, a 64-bit B component in bytes 16..23, and a 64-bit A
   * component in bytes 24..31.
   */

  VK_FORMAT_R64G64B64A64_SFLOAT(121),

  /**
   * A three-component, 32-bit packed unsigned floating-point format that has a 10-bit B component
   * in bits 22..31, an 11-bit G component in bits 11..21, an 11-bit R component in bits 0..10. See
   * Section 2.7.4, “Unsigned 10-Bit Floating-Point Numbers” and Section 2.7.3, “Unsigned 11-Bit
   * Floating-Point Numbers”.
   */

  VK_FORMAT_B10G11R11_UFLOAT_PACK32(122),

  /**
   * A three-component, 32-bit packed unsigned floating-point format that has a 5-bit shared
   * exponent in bits 27..31, a 9-bit B component mantissa in bits 18..26, a 9-bit G component
   * mantissa in bits 9..17, and a 9-bit R component mantissa in bits 0..8.
   */

  VK_FORMAT_E5B9G9R9_UFLOAT_PACK32(123),

  /**
   * A one-component, 16-bit unsigned normalized format that has a single 16-bit depth component.
   */

  VK_FORMAT_D16_UNORM(124),

  /**
   * A two-component, 32-bit format that has 24 unsigned normalized bits in the depth component and,
   * optionally, 8 bits that are unused.
   */

  VK_FORMAT_X8_D24_UNORM_PACK32(125),

  /**
   * A one-component, 32-bit signed floating-point format that has 32-bits in the depth component.
   */

  VK_FORMAT_D32_SFLOAT(126),

  /**
   * A one-component, 8-bit unsigned integer format that has 8-bits in the stencil component.
   */

  VK_FORMAT_S8_UINT(127),

  /**
   * A two-component, 24-bit format that has 16 unsigned normalized bits in the depth component and
   * 8 unsigned integer bits in the stencil component.
   */

  VK_FORMAT_D16_UNORM_S8_UINT(128),

  /**
   * A two-component, 32-bit packed format that has 8 unsigned integer bits in the stencil
   * component, and 24 unsigned normalized bits in the depth component.
   */

  VK_FORMAT_D24_UNORM_S8_UINT(129),

  /**
   * A two-component format that has 32 signed float bits in the depth component and 8 unsigned
   * integer bits in the stencil component. There are optionally 24-bits that are unused.
   */

  VK_FORMAT_D32_SFLOAT_S8_UINT(130),

  /**
   * A three-component, block-compressed format where each 64-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGB texel data. This format has no alpha and is considered
   * opaque.
   */

  VK_FORMAT_BC1_RGB_UNORM_BLOCK(131),

  /**
   * A three-component, block-compressed format where each 64-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGB texel data with sRGB nonlinear encoding. This format
   * has no alpha and is considered opaque.
   */

  VK_FORMAT_BC1_RGB_SRGB_BLOCK(132),

  /**
   * A four-component, block-compressed format where each 64-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGB texel data, and provides 1 bit of alpha.
   */

  VK_FORMAT_BC1_RGBA_UNORM_BLOCK(133),

  /**
   * A four-component, block-compressed format where each 64-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGB texel data with sRGB nonlinear encoding, and provides
   * 1 bit of alpha.
   */

  VK_FORMAT_BC1_RGBA_SRGB_BLOCK(134),

  /**
   * A four-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data with the first 64 bits encoding alpha
   * values followed by 64 bits encoding RGB values.
   */

  VK_FORMAT_BC2_UNORM_BLOCK(135),

  /**
   * A four-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data with the first 64 bits encoding alpha
   * values followed by 64 bits encoding RGB values with sRGB nonlinear encoding.
   */

  VK_FORMAT_BC2_SRGB_BLOCK(136),

  /**
   * A four-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data with the first 64 bits encoding alpha
   * values followed by 64 bits encoding RGB values.
   */

  VK_FORMAT_BC3_UNORM_BLOCK(137),

  /**
   * A four-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data with the first 64 bits encoding alpha
   * values followed by 64 bits encoding RGB values with sRGB nonlinear encoding.
   */

  VK_FORMAT_BC3_SRGB_BLOCK(138),

  /**
   * A one-component, block-compressed format where each 64-bit compressed texel block encodes a 4x4
   * rectangle of unsigned normalized red texel data.
   */

  VK_FORMAT_BC4_UNORM_BLOCK(139),

  /**
   * A one-component, block-compressed format where each 64-bit compressed texel block encodes a 4x4
   * rectangle of signed normalized red texel data.
   */

  VK_FORMAT_BC4_SNORM_BLOCK(140),

  /**
   * A two-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RG texel data with the first 64 bits encoding red values
   * followed by 64 bits encoding green values.
   */

  VK_FORMAT_BC5_UNORM_BLOCK(141),

  /**
   * A two-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of signed normalized RG texel data with the first 64 bits encoding red values
   * followed by 64 bits encoding green values.
   */

  VK_FORMAT_BC5_SNORM_BLOCK(142),

  /**
   * A three-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned floating-point RGB texel data.
   */

  VK_FORMAT_BC6H_UFLOAT_BLOCK(143),

  /**
   * A three-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of signed floating-point RGB texel data.
   */

  VK_FORMAT_BC6H_SFLOAT_BLOCK(144),

  /**
   * A four-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_BC7_UNORM_BLOCK(145),

  /**
   * A four-component, block-compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_BC7_SRGB_BLOCK(146),

  /**
   * A three-component, ETC2 compressed format where each 64-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGB texel data. This format has no alpha and is considered
   * opaque.
   */

  VK_FORMAT_ETC2_R8G8B8_UNORM_BLOCK(147),

  /**
   * A three-component, ETC2 compressed format where each 64-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGB texel data with sRGB nonlinear encoding. This format
   * has no alpha and is considered opaque.
   */

  VK_FORMAT_ETC2_R8G8B8_SRGB_BLOCK(148),

  /**
   * A four-component, ETC2 compressed format where each 64-bit compressed texel block encodes a 4x4
   * rectangle of unsigned normalized RGB texel data, and provides 1 bit of alpha.
   */

  VK_FORMAT_ETC2_R8G8B8A1_UNORM_BLOCK(149),

  /**
   * A four-component, ETC2 compressed format where each 64-bit compressed texel block encodes a 4x4
   * rectangle of unsigned normalized RGB texel data with sRGB nonlinear encoding, and provides 1
   * bit of alpha.
   */

  VK_FORMAT_ETC2_R8G8B8A1_SRGB_BLOCK(150),

  /**
   * A four-component, ETC2 compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data with the first 64 bits encoding alpha
   * values followed by 64 bits encoding RGB values.
   */

  VK_FORMAT_ETC2_R8G8B8A8_UNORM_BLOCK(151),

  /**
   * A four-component, ETC2 compressed format where each 64-bit compressed texel block encodes a 4x4
   * rectangle of unsigned normalized RGBA texel data with the first 64 bits encoding alpha values
   * followed by 64 bits encoding RGB values with sRGB nonlinear encoding applied.
   */

  VK_FORMAT_ETC2_R8G8B8A8_SRGB_BLOCK(152),

  /**
   * A one-component, ETC2 compressed format where each 64-bit compressed texel block encodes a 4x4
   * rectangle of unsigned normalized red texel data.
   */

  VK_FORMAT_EAC_R11_UNORM_BLOCK(153),

  /**
   * A one-component, ETC2 compressed format where each 64-bit compressed texel block encodes a 4x4
   * rectangle of signed normalized red texel data.
   */

  VK_FORMAT_EAC_R11_SNORM_BLOCK(154),

  /**
   * A two-component, ETC2 compressed format where each 128-bit compressed texel block encodes a 4x4
   * rectangle of unsigned normalized RG texel data with the first 64 bits encoding red values
   * followed by 64 bits encoding green values.
   */

  VK_FORMAT_EAC_R11G11_UNORM_BLOCK(155),

  /**
   * A two-component, ETC2 compressed format where each 128-bit compressed texel block encodes a 4x4
   * rectangle of signed normalized RG texel data with the first 64 bits encoding red values
   * followed by 64 bits encoding green values.
   */

  VK_FORMAT_EAC_R11G11_SNORM_BLOCK(156),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_4x4_UNORM_BLOCK(157),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 4x4 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_4x4_SRGB_BLOCK(158),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 5x4 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_5x4_UNORM_BLOCK(159),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 5x4 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_5x4_SRGB_BLOCK(160),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 5x5 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_5x5_UNORM_BLOCK(161),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 5x5 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_5x5_SRGB_BLOCK(162),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 6x5 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_6x5_UNORM_BLOCK(163),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 6x5 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_6x5_SRGB_BLOCK(164),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 6x6 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_6x6_UNORM_BLOCK(165),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 6x6 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_6x6_SRGB_BLOCK(166),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 8x5 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_8x5_UNORM_BLOCK(167),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 8x5 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_8x5_SRGB_BLOCK(168),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 8x6 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_8x6_UNORM_BLOCK(169),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 8x6 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_8x6_SRGB_BLOCK(170),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 8x8 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_8x8_UNORM_BLOCK(171),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 8x8 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_8x8_SRGB_BLOCK(172),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x5 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_10x5_UNORM_BLOCK(173),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x5 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_10x5_SRGB_BLOCK(174),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x6 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_10x6_UNORM_BLOCK(175),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x6 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_10x6_SRGB_BLOCK(176),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x8 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_10x8_UNORM_BLOCK(177),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x8 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_10x8_SRGB_BLOCK(178),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x10 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_10x10_UNORM_BLOCK(179),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 10x10 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_10x10_SRGB_BLOCK(180),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 12x10 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_12x10_UNORM_BLOCK(181),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 12x10 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_12x10_SRGB_BLOCK(182),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 12x12 rectangle of unsigned normalized RGBA texel data.
   */

  VK_FORMAT_ASTC_12x12_UNORM_BLOCK(183),

  /**
   * A four-component, ASTC compressed format where each 128-bit compressed texel block encodes a
   * 12x12 rectangle of unsigned normalized RGBA texel data with sRGB nonlinear encoding applied to
   * the RGB components.
   */

  VK_FORMAT_ASTC_12x12_SRGB_BLOCK(184);

  private static final Map<Integer, VulkanFormat> VALUES =
    VulkanEnumMaps.map(values());

  private final int value;

  VulkanFormat(
    final int in_value)
  {
    this.value = in_value;
  }

  /**
   * @param v The constant's integer value
   *
   * @return The constant associated with the given integer value
   */

  public static Optional<VulkanFormat> fromInteger(
    final int v)
  {
    return Optional.ofNullable(VALUES.get(Integer.valueOf(v)));
  }

  @Override
  public int value()
  {
    return this.value;
  }
}
