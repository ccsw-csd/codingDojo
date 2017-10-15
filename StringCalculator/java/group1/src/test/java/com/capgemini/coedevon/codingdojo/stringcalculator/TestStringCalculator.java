package com.capgemini.coedevon.codingdojo.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.coedevon.codingdojo.stringcalculator.StringCalculator;

/**
 * jUnit Test String Calculator
 */
public class TestStringCalculator {
  private StringCalculator stringCalculator;

  @Before
  public void init() {

    this.stringCalculator = new StringCalculator();
  }

  @Test
  public void emptyStringReturnsZero() {

    assertEquals(0, this.stringCalculator.add(""));
  }

  @Test
  public void numberStringReturnsNumber() {

    assertEquals(1, this.stringCalculator.add("1"));
  }

  @Test
  public void stringNumbersCommaDelimitedReturnsSum() {

    assertEquals(3, this.stringCalculator.add("1,2"));
  }

  @Test
  public void multipleStringNumbersCommaDelimitedReturnsSum() {

    assertEquals(6, this.stringCalculator.add("1,2,3"));
  }

  @Test
  public void multipleStringNumbersCommaOrReturnLineDelimitedReturnsSum() {

    assertEquals(6, this.stringCalculator.add("1\n2,3"));
    assertEquals(6, this.stringCalculator.add("1,2\n3"));
  }

  @Test
  public void multipleStringNumbersCustomDelimitedReturnsSum() {

    assertEquals("Should return 3", 3, this.stringCalculator.add("//;\n1;2"));
  }
}
