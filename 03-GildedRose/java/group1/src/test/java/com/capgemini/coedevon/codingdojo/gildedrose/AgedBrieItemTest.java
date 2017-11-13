package com.capgemini.coedevon.codingdojo.gildedrose;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class AgedBrieItemTest extends AbstractGildedRoseTest {

  protected static final String AGED_BRIE_ITEM = "Aged Brie";

  @Test
  public void agedBrieIncreaseQualityOnePerDay() {

    testItemQuality(new Item(AGED_BRIE_ITEM), 10, 10, 1);

  }

  @Test
  public void agedBrieIncreaseQualityTwoPerDayWhenSellDatePass() {

    testItemQuality(new Item(AGED_BRIE_ITEM), 0, 10, 2);

  }

  @Test
  public void qualityOfItemNeverMoreThan50() {

    testItemQuality(new Item(AGED_BRIE_ITEM), 10, 50, 0);
    testItemQuality(new Item(AGED_BRIE_ITEM), 0, 50, 0);

  }

}
