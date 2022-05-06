package com.ccsw.coedevon.codingdojo.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * jUnit Test String Calculator
 */
public class TestStringCalculator {

  private static final StringCalculator stringCalculator = new StringCalculator();

  @Test
  public void TestEmptyStringReturnZero() {

    Assert.assertEquals(0, stringCalculator.add(""));
  }

  @Test
  public void TestNumberStringReturnValue() {

    Assert.assertEquals(1, stringCalculator.add("1"));

    Assert.assertEquals(2, stringCalculator.add("2"));
  }

  @Test
  public void TestTwoNumbersStringReturnSum() {

    Assert.assertEquals(3, stringCalculator.add("1,2"));

    Assert.assertEquals(5, stringCalculator.add("2,3"));
  }

  @Test
  public void TestAnyNumbersStringReturnSum() {

    Assert.assertEquals(10, stringCalculator.add("1,2,3,4"));
  }

  @Test
  public void TestAnyNumbersComaOrReturnLineDelimiterStringReturnSum() {

    Assert.assertEquals(6, stringCalculator.add("1,2\n3"));
  }

  @Test
  public void TestAnyNumbersCustomDelimiterStringReturnSum() {

    Assert.assertEquals(3, stringCalculator.add("//;\n1;2"));
  }
}
