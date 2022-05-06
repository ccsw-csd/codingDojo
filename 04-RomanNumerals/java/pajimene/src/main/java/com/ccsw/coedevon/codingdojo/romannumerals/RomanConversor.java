package com.ccsw.coedevon.codingdojo.romannumerals;

import java.util.ArrayList;
import java.util.List;

/**
 * Kata Roman Numerals
 */
public class RomanConversor {

	private static List<RomanRule> conversionRules;

	static {
		conversionRules = new ArrayList<>();

		conversionRules.add(new RomanRule(1000, "M"));
		conversionRules.add(new RomanRule(900, "CM"));
		conversionRules.add(new RomanRule(500, "D"));
		conversionRules.add(new RomanRule(400, "CD"));
		conversionRules.add(new RomanRule(100, "C"));
		conversionRules.add(new RomanRule(90, "XC"));
		conversionRules.add(new RomanRule(50, "L"));
		conversionRules.add(new RomanRule(40, "XL"));
		conversionRules.add(new RomanRule(10, "X"));
		conversionRules.add(new RomanRule(9, "IX"));
		conversionRules.add(new RomanRule(5, "V"));
		conversionRules.add(new RomanRule(4, "IV"));
		conversionRules.add(new RomanRule(1, "I"));
	}

	public static String convertToRoman(int number) {

		StringBuilder romanNumber = new StringBuilder();

		while (number > 0) {

			for (RomanRule rule : conversionRules) {

				RomanConversionData conversionData = rule.applyRomanRule(number);

				if (conversionData.isRuleApply()) {

					number -= conversionData.getDecrement();
					romanNumber.append(conversionData.getConversion());

					break;
				}
			}

		}

		return romanNumber.toString();
	}

	public static int convertToNumeral(String romanNumber) {

		int number = 0;

		while (romanNumber.length() > 0) {

			for (RomanRule rule : conversionRules) {

				RomanConversionData conversionData = rule.applyNumberRule(romanNumber);

				if (conversionData.isRuleApply()) {

					number += conversionData.getDecrement();

					int maxLength = conversionData.getConversion().length();
					romanNumber = romanNumber.substring(maxLength);

					break;
				}
			}

		}

		return number;
	}

}
