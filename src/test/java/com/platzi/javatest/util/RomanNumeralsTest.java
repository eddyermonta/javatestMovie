package com.platzi.javatest.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class RomanNumeralsTest {

    @Test
    public void romanI() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
    }

    @Test
    public void romanII() {
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
    }

    @Test
    public void romanIII() {
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
    }

    @Test
    public void romanV() {
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
    }

    @Test
    public void romanVI() {
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
    }

    @Test
    public void romanVII() {
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
    }

    @Test
    public void romanX() {
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
    }

    @Test
    public void romanXI() {
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
    }

    @Test
    public void romanXVI() {
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));
    }

    @Test
    public void romanL() {
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
    }

    @Test
    public void romanLI() {
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
    }

    @Test
    public void romanLV() {
        assertThat(RomanNumerals.arabicToRoman(55), is("LV"));
    }

    @Test
    public void romanLVI() {
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));
    }

    @Test
    public void romanLX() {
        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
    }

    @Test
    public void romanLXX() {
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));
    }

    @Test
    public void romanLXXX() {
        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
    }

    @Test
    public void romanLXXXI() {
        assertThat(RomanNumerals.arabicToRoman(81), is("LXXXI"));
    }

    @Test
    public void romanLXXXV() {
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
    }

    @Test
    public void romanLXXXVI() {
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));
    }

    @Test
    public void romanCXXVI() {
        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
    }

    @Test
    public void romanMMDVII() {
        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void romanIV() {
        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
    }

    @Test
    public void romanIX() {
        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
    }

    @Test
    public void romanXIV() {
        assertThat(RomanNumerals.arabicToRoman(14), is("XIV"));
    }

    @Test
    public void romanXIX() {
        assertThat(RomanNumerals.arabicToRoman(19), is("XIX"));
    }

    @Test
    public void romanXXIV() {
        assertThat(RomanNumerals.arabicToRoman(24), is("XXIV"));
    }

    @Test
    public void romanXL() {
        assertThat(RomanNumerals.arabicToRoman(40), is("XL"));
    }

    @Test
    public void romanXLIX() {
        assertThat(RomanNumerals.arabicToRoman(49), is("XLIX"));
    }

    @Test
    public void romanXC() {
        assertThat(RomanNumerals.arabicToRoman(90), is("XC"));
    }

    @Test
    public void romanXCIX() {
        assertThat(RomanNumerals.arabicToRoman(99), is("XCIX"));
    }

    @Test
    public void romanCD() {
        assertThat(RomanNumerals.arabicToRoman(400), is("CD"));
    }

    @Test
    public void romanCM() {
        assertThat(RomanNumerals.arabicToRoman(900), is("CM"));
    }
}