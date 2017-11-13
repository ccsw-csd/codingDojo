package com.capgemini.coedevon.codingdojo.gildedrose;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class GenericItemTest extends AbstractGildedRoseTest {

  protected static final String GENERIC_ITEM = "Generic Item";

  @Test
  public void genericItemDecreaseQualityOnePerDay() {

    testItemQuality(new Item(GENERIC_ITEM), 10, 10, -1);
  }

  @Test
  public void genericItemDecreaseQualityTwoPerDayWhenSellDatePass() {

    testItemQuality(new Item(GENERIC_ITEM), 0, 10, -2);

  }

  @Test
  public void genericItemQualityCanNeverBeNegative() {

    testItemQuality(new Item(GENERIC_ITEM), 10, 0, 0);

  }

}
