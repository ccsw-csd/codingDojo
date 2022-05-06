package com.ccsw.coedevon.codingdojo.gildedrose.item;

/**
 * @author pajimene
 *
 */
public class AgedBrieItem extends Item {
  public AgedBrieItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {

    increaseQuality();

    decrementSellIn();

    if (sellInExpired())
      increaseQuality();

  }

}
