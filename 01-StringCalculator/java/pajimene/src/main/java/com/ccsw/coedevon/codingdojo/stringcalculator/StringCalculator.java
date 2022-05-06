package com.ccsw.coedevon.codingdojo.stringcalculator;

/**
 * Kata String Calculator
 */
public class StringCalculator {
  /**
   *
   */
  private static final int MAXIMUM_NUMBER = 1000;

  private static final int DELIMITER_POSITION_INPUT = 0;

  private static final int NUMBER_POSITION_INPUT = 1;

  public int add(String input) {

    if ("".equals(input))
      return 0;

    String delimiter = extractDelimiter(input);
    String[] numberArray = extractNumbers(input, delimiter);

    return sumNumberArray(numberArray);

  }

  /**
   * @param input
   * @param delimiter
   * @return
   */
  private String[] extractNumbers(String input, String delimiter) {

    if (isDefaultDelimiter(input))
      return input.split(delimiter);

    String parts[] = input.split("\n");
    String numberString = parts[NUMBER_POSITION_INPUT];

    return numberString.split(delimiter);
  }

  /**
   * @param input
   * @return
   */
  private boolean isDefaultDelimiter(String input) {

    return !input.startsWith("//");
  }

  /**
   * @param input
   * @return
   */
  private String extractDelimiter(String input) {

    String delimiter = ",|\n";

    if (isDefaultDelimiter(input))
      return delimiter;

    String parts[] = input.split("\n");

    delimiter = parts[DELIMITER_POSITION_INPUT].substring(2);

    if (hasLongDelimiter(delimiter)) {
      delimiter = delimiter.substring(1, delimiter.length() - 1);
    }

    StringBuilder delimiterRegex = new StringBuilder();
    String[] delimiterArray = delimiter.split("\\]\\[");
    for (String singleDelimiter : delimiterArray) {
      delimiterRegex.append("|" + singleDelimiter);
    }

    return delimiterRegex.substring(1);
  }

  /**
   * @param delimiter
   * @return
   */
  private boolean hasLongDelimiter(String delimiter) {

    return delimiter.startsWith("[") && delimiter.endsWith("]");
  }

  /**
   * @param numbers
   * @return
   */
  private int sumNumberArray(String[] numbers) {

    checkNegativeNumbers(numbers);

    int total = 0;
    for (String number : numbers) {
      int numberParsed = Integer.parseInt(number);

      if (numberParsed <= MAXIMUM_NUMBER)
        total += numberParsed;
    }

    return total;
  }

  private void checkNegativeNumbers(String[] numbers) throws RuntimeException {

    StringBuilder exceptionMessage = new StringBuilder();

    for (String number : numbers) {
      int numberParsed = Integer.parseInt(number);

      if (numberParsed < 0) {
        exceptionMessage.append(numberParsed + ",");
      }

    }

    if (exceptionMessage.length() > 0) {
      throw new RuntimeException(
          "negativos no soportados: " + exceptionMessage.toString().substring(0, exceptionMessage.length() - 1));
    }

  }

}
