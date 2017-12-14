package com.capgemini.coedevon.codingdojo.romannumerals;

import org.junit.Assert;
import org.junit.Test;

/**
 * jUnit Test String Calculator
 */
public class TestNumeralToRoman {

	@Test
	public void numeral_1_is_roman_I() {
		checkConversion("I", 1);
	}

	@Test
	public void numeral_2_is_roman_II() {
		checkConversion("II", 2);
	}

	@Test
	public void numeral_3_is_roman_III() {
		checkConversion("III", 3);
	}

	@Test
	public void numeral_4_is_roman_IV() {
		checkConversion("IV", 4);
	}

	@Test
	public void numeral_5_is_roman_V() {
		checkConversion("V", 5);
	}

	@Test
	public void numeral_6_is_roman_VI() {
		checkConversion("VI", 6);
	}

	@Test
	public void numeral_7_is_roman_VII() {
		checkConversion("VII", 7);
	}

	@Test
	public void numeral_8_is_roman_VIII() {
		checkConversion("VIII", 8);
	}

	@Test
	public void numeral_9_is_roman_IX() {
		checkConversion("IX", 9);
	}

	@Test
	public void numeral_10_is_roman_X() {
		checkConversion("X", 10);
	}

	@Test
	public void numeral_11_is_roman_XI() {
		checkConversion("XI", 11);
	}

	@Test
	public void numeral_14_is_roman_XIV() {
		checkConversion("XIV", 14);
	}

	@Test
	public void numeral_15_is_roman_XV() {
		checkConversion("XV", 15);
	}

	@Test
	public void numeral_16_is_roman_XVI() {
		checkConversion("XVI", 16);
	}

	@Test
	public void numeral_19_is_roman_XIX() {
		checkConversion("XIX", 19);
	}

	@Test
	public void numeral_20_is_roman_XX() {
		checkConversion("XX", 20);
	}

	@Test
	public void numeral_48_is_roman_XLVIII() {
		checkConversion("XLVIII", 48);
	}

	@Test
	public void numeral_49_is_roman_XLIX() {
		checkConversion("XLIX", 49);
	}

	@Test
	public void numeral_50_is_roman_L() {
		checkConversion("L", 50);
	}

	@Test
	public void numeral_73_is_roman_LXXIII() {
		checkConversion("LXXIII", 73);
	}

	@Test
	public void numeral_79_is_roman_LXXIX() {
		checkConversion("LXXIX", 79);
	}

	@Test
	public void numeral_99_is_roman_XCIX() {
		checkConversion("XCIX", 99);
	}

	@Test
	public void numeral_100_is_roman_C() {
		checkConversion("C", 100);
	}

	@Test
	public void numeral_467_is_roman_CDLXVII() {
		checkConversion("CDLXVII", 467);
	}

	@Test
	public void numeral_499_is_roman_CDXCIX() {
		checkConversion("CDXCIX", 499);
	}

	@Test
	public void numeral_500_is_roman_D() {
		checkConversion("D", 500);
	}

	@Test
	public void numeral_874_is_roman_DCCCLXXIV() {
		checkConversion("DCCCLXXIV", 874);
	}

	@Test
	public void numeral_999_is_roman_CMXCIX() {
		checkConversion("CMXCIX", 999);
	}

	@Test
	public void numeral_1000_is_roman_M() {
		checkConversion("M", 1000);
	}

	@Test
	public void numeral_1990_is_roman_MCMXC() {
		checkConversion("MCMXC", 1990);
	}

	@Test
	public void numeral_2008_is_roman_MMVIII() {
		checkConversion("MMVIII", 2008);
	}

	private void checkConversion(String roman, int numeral) {
		Assert.assertEquals(roman, RomanConversor.convertToRoman(numeral));
	}

}
