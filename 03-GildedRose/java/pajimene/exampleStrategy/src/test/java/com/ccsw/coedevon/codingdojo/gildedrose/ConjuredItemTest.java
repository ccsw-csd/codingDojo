package com.ccsw.coedevon.codingdojo.gildedrose;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ConjuredItemTest extends AbstractGildedRoseTest {

  protected static final String CONJURED_ITEM = "Conjured Item";

  @Test
  public void conjuredItemsDecreaseQualityTwoPerDay() {

    testItemQuality(CONJURED_ITEM, 10, 20, -2);

  }

  @Test
  public void conjuredItemsDecreaseQualityDoubleIsExpired() {

    testItemQuality(CONJURED_ITEM, 0, 10, -4);

  }

}