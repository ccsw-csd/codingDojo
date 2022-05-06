package com.ccsw.coedevon.codingdojo.stringcalculator;

/**
 * Kata String Calculator
 */
public class StringCalculator {
  /**
   *
   * @param input
   * @return
   */
  public int add(String input) {

    if (input.isEmpty())
      return 0;

    String delimiter = getDelimiter(input);
    String numbers = getNumbers(input);
    return calculateSum(numbers.split(delimiter));

  }

  /**
   * @param input
   * @return
   */
  private String getNumbers(String input) {

    String numbers = input;
    Integer numbersPosition = 1;
    if (input.contains("//")) {
      numbers = input.split("\n")[numbersPosition];
    }
    return numbers;
  }

  /**
   * @param input
   * @return
   */
  private String getDelimiter(String input) {

    String delimiter = ",|\n";
    Integer delimiterPosition = 2;
    if (input.contains("//")) {
      delimiter = String.valueOf(input.charAt(delimiterPosition));
    }
    return delimiter;
  }

  private int calculateSum(String[] numbers) {

    int result = 0;
    for (String number : numbers) {
      result += Integer.parseInt(number);
    }

    return result;
  }

}
