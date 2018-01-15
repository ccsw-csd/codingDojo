package com.capgemini.coedevon.codingdojo.gildedrose.item;

/**
 * @author pajimene
 *
 */
public class GenericItem extends Item {

  /**
   * The constructor.
   * 
   * @param name
   * @param sellIn
   * @param quality
   */
  public GenericItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {

    decreaseQuality();

    decrementSellIn();

    if (sellInExpired())
      decreaseQuality();

  }
}
