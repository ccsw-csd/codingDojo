package com.capgemini.coedevon.codingdojo.gildedrose;

import org.junit.Test;

/**
 * @author pajimene
 *
 */
public class ConjuredItemTest extends AbstractGildedRoseTest {

  protected static final String CONJURED_ITEM = "Conjured Item";

  @Test
  public void conjuredItemDecreaseQualityTwoPerDay() {

    testItemQuality(CONJURED_ITEM, 10, 10, -2);
  }

  @Test
  public void conjuredItemDecreaseQualityFourPerDayWhenHasExpired() {

    testItemQuality(CONJURED_ITEM, 0, 10, -4);
  }

}
