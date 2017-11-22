package com.capgemini.coedevon.codingdojo.gildedrose.item;

import static com.capgemini.coedevon.codingdojo.gildedrose.item.Item.QUALITY_STEP;

/**
 * @author pajimene
 *
 */
public class ConjuredItem extends Item {

  /**
   * The constructor.
   *
   * @param name
   * @param sellIn
   * @param quality
   */
  public ConjuredItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {

    decreaseQuality(QUALITY_STEP * 2);

    decrementSellIn();

    if (sellInExpired())
      decreaseQuality(QUALITY_STEP * 2);

  }

}
