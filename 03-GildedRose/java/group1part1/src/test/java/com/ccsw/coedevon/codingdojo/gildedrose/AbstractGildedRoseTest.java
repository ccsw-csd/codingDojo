package com.ccsw.coedevon.codingdojo.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

@SuppressWarnings("javadoc")
public abstract class AbstractGildedRoseTest {

  protected void testItemQuality(String itemName, int initialSellIn, int initialQuality, int deltaQuality) {

    Item item = new Item(itemName, initialSellIn, initialQuality);
    GildedRose app = new GildedRose(Arrays.asList(item));
    app.updateQuality();

    assertEquals(initialQuality + deltaQuality, item.quality);
    assertEquals(initialSellIn - 1, item.sellIn);
  }

  protected void testItemQualityAndSellin(String itemName, int initialSellIn, int initialQuality, int deltaSellin,
      int deltaQuality) {

    Item item = new Item(itemName, initialSellIn, initialQuality);
    GildedRose app = new GildedRose(Arrays.asList(item));
    app.updateQuality();

    assertEquals(initialQuality + deltaQuality, item.quality);
    assertEquals(initialSellIn + deltaSellin, item.sellIn);
  }

}
