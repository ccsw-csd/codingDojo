package com.capgemini.coedevon.codingdojo.romannumerals;

public class RomanRule {

	protected RomanConversionData data;
	protected int ruleThreshold;
	protected String ruleConversion;

	public RomanRule(int threshold, String conversion) {
		this.ruleThreshold = threshold;
		this.ruleConversion = conversion;

		data = new RomanConversionData();
	}

	public RomanConversionData applyRomanRule(int number) {

		if (number >= ruleThreshold)
			return data.set(ruleThreshold, ruleConversion);

		return data.nullInstance();

	}

	public RomanConversionData applyNumberRule(String roman) {

		if (roman.startsWith(ruleConversion))
			return data.set(ruleThreshold, ruleConversion);

		return data.nullInstance();

	}
}
