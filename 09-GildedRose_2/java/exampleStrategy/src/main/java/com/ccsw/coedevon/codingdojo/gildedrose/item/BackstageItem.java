package com.ccsw.coedevon.codingdojo.gildedrose.item;

/**
 * @author pajimene
 *
 */
public class BackstageItem extends Item {

  private static final int TRIPLE_THRESOLD = 5;

  private static final int DOUBLE_THRESOLD = 10;

  /**
   * The constructor.
   *
   * @param name
   * @param sellIn
   * @param quality
   */
  public BackstageItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {

    updateQualityBackstage();

    decrementSellIn();

    if (sellInExpired())
      dropQuality();

  }

  /**
   * @param item
   */
  protected void updateQualityBackstage() {

    increaseQuality();

    if (hasDoubleThresold()) {
      increaseQuality();
    }

    if (hasTripleThresold()) {
      increaseQuality();
    }
  }

  /**
   * @param item
   * @return
   */
  protected boolean hasDoubleThresold() {

    boolean hasDoubleThresold = getSellIn() <= DOUBLE_THRESOLD;
    return hasDoubleThresold;
  }

  /**
   * @param item
   * @return
   */
  protected boolean hasTripleThresold() {

    boolean hasTripleThresold = getSellIn() <= TRIPLE_THRESOLD;
    return hasTripleThresold;
  }

}
