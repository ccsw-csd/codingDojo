package com.capgemini.coedevon.codingdojo.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

@SuppressWarnings("javadoc")
public abstract class AbstractGildedRoseTest {

  protected void testItemQuality(Item item, int initialSellIn, int initialQuality, int deltaQuality) {

    item.setQuality(initialQuality);
    item.setSellIn(initialSellIn);

    GildedRose app = new GildedRose(Arrays.asList(item));
    app.updateQuality();

    assertEquals(initialQuality + deltaQuality, item.quality);
    assertEquals(initialSellIn - 1, item.sellIn);
  }

  protected void testItemQualityAndSellin(Item item, int initialSellIn, int initialQuality, int deltaSellin,
      int deltaQuality) {

    item.setQuality(initialQuality);
    item.setSellIn(initialSellIn);

    GildedRose app = new GildedRose(Arrays.asList(item));
    app.updateQuality();

    assertEquals(initialQuality + deltaQuality, item.quality);
    assertEquals(initialSellIn + deltaSellin, item.sellIn);
  }

}
