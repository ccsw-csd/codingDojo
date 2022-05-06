package com.ccsw.coedevon.codingdojo.gildedrose;

import java.util.List;

class GildedRose {

  private static final int SELLIN_STEP = 1;

  private static final int QUALITY_STEP = 1;

  private static final int MIN_SELLIN = 0;

  private static final int TRIPLE_THRESOLD = 5;

  private static final int DOUBLE_THRESOLD = 10;

  private static final int MAX_QUALITY = 50;

  private static final int MIN_QUALITY = 0;

  private static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

  private static final String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";

  private static final String AGED_BRIE_ITEM = "Aged Brie";

  private static final String CONJURED_ITEM = "Conjured Item";

  private List<Item> items;

  public GildedRose(List<Item> items) {
    this.items = items;
  }

  public void updateQuality() {

    for (Item item : this.items) {

      updateQualityItem(item);

      decrementSellIn(item);

      checkSellInExpired(item);

    }

  }

  /**
   * @param item
   */
  private void updateQualityItem(Item item) {

    if (isBackstage(item)) {
      updateQualityBackstage(item);
    }

    else if (isAgedBrie(item)) {
      increaseQuality(item);
    }

    else if (isConjuredItem(item)) {
      decreaseQuality(item, QUALITY_STEP * 2);
    }

    else {
      decreaseQuality(item);
    }
  }

  /**
   * @param item
   */
  private void updateQualityBackstage(Item item) {

    increaseQuality(item);

    if (hasDoubleThresold(item)) {
      increaseQuality(item);
    }

    if (hasTripleThresold(item)) {
      increaseQuality(item);
    }
  }

  /**
   * @param item
   */
  private void checkSellInExpired(Item item) {

    if (sellInNotExpired(item))
      return;

    if (isAgedBrie(item)) {
      increaseQuality(item);
    }

    else if (isBackstage(item)) {
      dropQuality(item);
    }

    else if (isConjuredItem(item)) {
      decreaseQuality(item, QUALITY_STEP * 2);
    }

    else {
      decreaseQuality(item);
    }
  }

  /**
   * @param item
   * @return
   */
  private boolean sellInNotExpired(Item item) {

    boolean hasSomeSellIn = item.getSellIn() >= MIN_SELLIN;
    return hasSomeSellIn;
  }

  /**
   * @param item
   * @return
   */
  private boolean isBackstage(Item item) {

    boolean isBackstage = BACKSTAGE_ITEM.equals(item.getName());
    return isBackstage;
  }

  /**
   * @param item
   * @return
   */
  private boolean isAgedBrie(Item item) {

    boolean isAgedBrid = AGED_BRIE_ITEM.equals(item.getName());
    return isAgedBrid;
  }

  /**
   * @param item
   * @return
   */
  private boolean isSulfuras(Item item) {

    boolean isSulfuras = SULFURAS_ITEM.equals(item.getName());
    return isSulfuras;
  }

  /**
   * @param item
   * @return
   */
  private boolean isConjuredItem(Item item) {

    return CONJURED_ITEM.equals(item.getName());
  }

  /**
   * @param item
   */
  private void dropQuality(Item item) {

    item.setQuality(0);
  }

  /**
   * @param item
   * @return
   */
  private boolean hasDoubleThresold(Item item) {

    boolean hasDoubleThresold = item.getSellIn() <= DOUBLE_THRESOLD;
    return hasDoubleThresold;
  }

  /**
   * @param item
   * @return
   */
  private boolean hasTripleThresold(Item item) {

    boolean hasTripleThresold = item.getSellIn() <= TRIPLE_THRESOLD;
    return hasTripleThresold;
  }

  /**
   * @param item
   */
  private void decrementSellIn(Item item) {

    if (isSulfuras(item))
      return;

    item.setSellIn(item.getSellIn() - SELLIN_STEP);
  }

  /**
   * @param item
   */
  private void increaseQuality(Item item) {

    if (maxQualityReached(item))
      return;

    item.setQuality(item.getQuality() + QUALITY_STEP);
  }

  /**
   * @param item
   * @return
   */
  private boolean maxQualityReached(Item item) {

    return item.getQuality() >= MAX_QUALITY;
  }

  private void decreaseQuality(Item item) {

    decreaseQuality(item, QUALITY_STEP);
  }

  /**
   * @param item
   */
  private void decreaseQuality(Item item, int qualityStep) {

    if (hasNotQuality(item))
      return;

    if (isSulfuras(item))
      return;

    item.setQuality(item.getQuality() - qualityStep);
  }

  /**
   * @param item
   * @return
   */
  private boolean hasNotQuality(Item item) {

    return item.getQuality() <= MIN_QUALITY;
  }

}