package com.capgemini.coedevon.codingdojo.stringcalculator.completo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * jUnit Test String Calculator
 */
public class TestStringCalculator {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  private StringCalculator calculator;

  @Before
  public void init() {

    this.calculator = new StringCalculator();

  }

  @Test
  public void empty_string_return_zero() {

    Assert.assertEquals(0, this.calculator.add(""));
  }

  @Test
  public void one_number_return_number() {

    Assert.assertEquals(1, this.calculator.add("1"));
    Assert.assertEquals(2, this.calculator.add("2"));
  }

  @Test
  public void two_comma_separated_number_return_sum() {

    Assert.assertEquals(3, this.calculator.add("1,2"));
  }

  @Test
  public void comma_separated_numbers_return_sum() {

    Assert.assertEquals(6, this.calculator.add("1,2,3"));
  }

  @Test
  public void comma_or_return_line_separated_numbers_return_sum() {

    Assert.assertEquals(6, this.calculator.add("1\n2,3"));
  }

  @Test
  public void any_delimited_numbers_return_sum() {

    Assert.assertEquals(3, this.calculator.add("//;\n1;2"));
  }

  @Test
  public void negative_number_throw_exception() {

    this.exception.expect(RuntimeException.class);
    this.exception.expectMessage("negativos no soportados: -1");

    this.calculator.add("-1");
  }

  @Test
  public void multiple_negative_number_throw_exception() {

    this.exception.expect(RuntimeException.class);
    this.exception.expectMessage("negativos no soportados: -1,-2");

    this.calculator.add("-1,-2");
  }

  @Test
  public void numbers_greater_than_thousand_not_sum() {

    Assert.assertEquals(3, this.calculator.add("1,2,1001"));
  }

  @Test
  public void any_length_delimiter() {

    Assert.assertEquals(6, this.calculator.add("//[;;;]\n1;;;2;;;3"));
  }

  @Test
  public void any_multiple_length_delimiter() {

    Assert.assertEquals(6, this.calculator.add("//[;;][##]\n1;;2##3"));
  }

}
