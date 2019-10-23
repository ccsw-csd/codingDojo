package com.capgemini.coedevon.codingdojo.trickortreat;

/**
 * @author ccsw
 *
 */
@SuppressWarnings("javadoc")
public class TrickOrTreat {

  /**
   *
   */
  public static final String ARGH_I_HAVE_KHAKI = "Argh! I have khaki";

  /**
   *
   */
  private static final String KHAKI = "khaki";

  /**
   *
   */
  private static final int MINIMUM_CANDY_PER_CHILDREN = 2;

  /**
   *
   */
  public static final String CANDY = "candy";

  /**
   *
   */
  public static final String TRICK_OR_TREAT = "Trick or Treat";

  public static final String THANK_YOU = "Thank You";

  /**
   *  Que todos los niños tengan algún paquete, aunque sea vacío
  Que todos los niños tengan al menos 2 caramelos
  Que todos los niños tengan más caramelos que frutas
  Que todos los niños tengan el mismo número de caramelos
  Que ningún niño tenga un caqui

   */

  public String validateSets(int children, String[][] candies) {

    boolean differentChildrenNumberThanPackages = children != candies.length;

    if (differentChildrenNumberThanPackages) {

      return TRICK_OR_TREAT;

    }
    try {
      if (checkRules(candies)) {
        return THANK_YOU;
      }
    } catch (RuntimeException e) {
      return e.getMessage();
    }
    return TRICK_OR_TREAT;
  }

  /**
   * @param packs
   */
  private boolean checkRules(String[][] packs) {

    int firstCandyCounter = 0;

    for (int i = 0; i < packs.length; i++) {

      int candyCounter = countCandies(packs[i]);
      int fruitCounter = packs[i].length - candyCounter;

      if (i == 0) {
        firstCandyCounter = candyCounter;
      } else if (firstCandyCounter != candyCounter) {
        return false;
      }

      if (candyCounter < MINIMUM_CANDY_PER_CHILDREN) {
        return false;
      }

      if (fruitCounter >= candyCounter) {
        return false;
      }
    }

    return true;
  }

  private int countCandies(String[] candies) {

    int candyCounter = 0;

    for (int j = 0; j < candies.length; j++) {

      if (CANDY.equals(candies[j])) {
        candyCounter++;
      }
      if (KHAKI.equals(candies[j])) {
        throw new RuntimeException(ARGH_I_HAVE_KHAKI);
      }

    }

    return candyCounter;
  }
}
