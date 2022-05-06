package com.ccsw.coedevon.codingdojo.trickortreat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author ccsw
 *
 */
@SuppressWarnings("javadoc")
public class TrickOrTreatTest {

  @Test
  public void sameChildrenThanPackagesResultOk() {

    check(2, new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY }, { TrickOrTreat.CANDY, TrickOrTreat.CANDY } },
        TrickOrTreat.THANK_YOU);

  }

  @Test
  public void differentNumberOfChildrenThanPackagesResultError() {

    check(3, new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY }, { TrickOrTreat.CANDY, TrickOrTreat.CANDY } },
        TrickOrTreat.TRICK_OR_TREAT);

  }

  @Test
  public void allChildrenHaveAtLeastTwoCandiesReturnOk() {

    check(2, new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY }, { TrickOrTreat.CANDY, TrickOrTreat.CANDY } },
        TrickOrTreat.THANK_YOU);

  }

  @Test
  public void someChildrenWithLessThanTwoCandiesReturnError() {

    check(2, new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY }, { TrickOrTreat.CANDY, "apple" } },
        TrickOrTreat.TRICK_OR_TREAT);

  }

  @Test
  public void allChildrenHaveMoreCandiesThanFruitsReturnOk() {

    check(2, new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY },
    { TrickOrTreat.CANDY, TrickOrTreat.CANDY, "apple" } }, TrickOrTreat.THANK_YOU);
  }

  @Test
  public void someChildrenHaveLessOrEqualCandiesThanFruitsReturnError() {

    check(2, new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY },
    { TrickOrTreat.CANDY, TrickOrTreat.CANDY, "apple", "apple" } }, TrickOrTreat.TRICK_OR_TREAT);
  }

  @Test
  public void allChildrenHaveSameCandiesReturnOk() {

    check(2, new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY },
    { TrickOrTreat.CANDY, TrickOrTreat.CANDY, "apple" } }, TrickOrTreat.THANK_YOU);
  }

  @Test
  public void someChildrenHaveDifferentCandiesReturnError() {

    check(2,
        new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY },
        { TrickOrTreat.CANDY, TrickOrTreat.CANDY, TrickOrTreat.CANDY, "apple" } }, //
        TrickOrTreat.TRICK_OR_TREAT);
  }

  @Test
  public void someChildrenHaveKhakiReturnError() {

    check(2,
        new String[][] { { TrickOrTreat.CANDY, TrickOrTreat.CANDY },
        { TrickOrTreat.CANDY, TrickOrTreat.CANDY, TrickOrTreat.CANDY, "khaki" } }, //
        TrickOrTreat.ARGH_I_HAVE_KHAKI);
  }

  private void check(int children, String[][] candies, String expectedResult) {

    TrickOrTreat trickOrTreat = new TrickOrTreat();

    String result = trickOrTreat.validateSets(children, candies);

    assertEquals(expectedResult, result);

  }

}
