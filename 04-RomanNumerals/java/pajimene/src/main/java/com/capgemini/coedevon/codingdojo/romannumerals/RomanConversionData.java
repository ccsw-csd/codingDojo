package com.capgemini.coedevon.codingdojo.romannumerals;

public class RomanConversionData {

	private boolean ruleApply;
	private int decrement;
	private String conversion;

	public RomanConversionData() {
		this.setRuleApply(false);
	}

	public RomanConversionData nullInstance() {
		this.setRuleApply(false);

		return this;
	}

	public RomanConversionData set(int decrement, String conversion) {
		setConversion(conversion);
		setDecrement(decrement);
		setRuleApply(true);

		return this;
	}

	public void setRuleApply(boolean ruleApply) {
		this.ruleApply = ruleApply;
	}

	public boolean isRuleApply() {
		return ruleApply;
	}

	public int getDecrement() {
		return decrement;
	}

	public void setDecrement(int decrement) {
		this.decrement = decrement;
	}

	public String getConversion() {
		return conversion;
	}

	public void setConversion(String conversion) {
		this.conversion = conversion;
	}

}
