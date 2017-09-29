package com.capgemini.coedevon.codingdojo.stringcalculator;

/**
 * Kata String Calculator
 */
public class StringCalculator {
  private static final String prefix = "//";

  /**
   *
   * @param input
   * @return
   */
  public int add(String input) {

    if ("".equals(input)) {
      return 0;
    }

    String numbers = extractNumbers(input);
    String delimiter = extractDelimiter(input);

    return stringSum(numbers, delimiter);
  }

  /**
   * @param input
   * @param prefix
   * @return
   */
  private String extractDelimiter(String input) {

    String delimiter = ",|\n";
    int delimiterPosition = 2;

    if (input.startsWith(prefix)) {
      delimiter = String.valueOf(input.charAt(delimiterPosition));
    }

    return delimiter;
  }

  /**
   * @param input
   * @param prefix
   * @return
   */
  private String extractNumbers(String input) {

    String numbers = input;
    int numbersPosition = 4;

    if (input.startsWith(prefix)) {
      numbers = input.substring(numbersPosition);
    }

    return numbers;
  }

  /**
   * @param input
   * @param sumDelimiter
   * @return
   */
  private int stringSum(String input, String delimiter) {

    String[] numbers = input.split(delimiter);
    int sum = 0;

    for (String number : numbers) {
      sum += Integer.parseInt(number);
    }

    return sum;
  }

}
