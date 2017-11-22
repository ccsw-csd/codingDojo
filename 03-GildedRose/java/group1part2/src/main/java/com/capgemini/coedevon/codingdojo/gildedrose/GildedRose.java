package com.capgemini.coedevon.codingdojo.gildedrose;

import java.util.List;

@SuppressWarnings("javadoc")
public class GildedRose {

  private static final int DEADLINE_SELL_IN = 0;

  private static final int SELL_IN_UNIT = 1;

  private static final int PASSES_THRESHOLD_TRIPLE_QUALITY = 5;

  private static final int PASSES_THRESHOLD_DOUBLE_QUALITY = 10;

  private static final int MAX_QUALITY = 50;

  private static final int MIN_QUALITY = 0;

  private static final int QUALITY_UNIT = 1;

  private static final int DOUBLE_QUALITY_UNIT = 2;

  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  private static final String AGED_BRIE = "Aged Brie";

  private static final String CONJURED_ITEM = "Conjured Item";

  private List<Item> items;

  public GildedRose(List<Item> items) {
    this.items = items;
  }

  public void updateQuality() {

    for (Item item : this.items) {

      applyQualityRules(item);
      decreaseSellIn(item);
      applyExpiredRules(item);
    }
  }

  /**
   * @param item
   */
  private void applyExpiredRules(Item item) {

    if (hasExpired(item)) {
      if (isPasses(item)) {
        setZeroQuality(item);
      } else if (isAgedBrie(item)) {
        increaseQuality(item);
      } else if (isConjured(item)) {
        decreaseQuality(item, DOUBLE_QUALITY_UNIT);
      } else {
        decreaseQuality(item);
      }
    }
  }

  /**
   * @param item
   */
  private void applyQualityRules(Item item) {

    boolean belowThresholdDoubleQuality = item.getSellIn() <= PASSES_THRESHOLD_DOUBLE_QUALITY;
    boolean belowThresholdTripleQuality = item.getSellIn() <= PASSES_THRESHOLD_TRIPLE_QUALITY;

    if (isPasses(item)) {
      increaseQuality(item);

      if (belowThresholdDoubleQuality) {
        increaseQuality(item);
      }

      if (belowThresholdTripleQuality) {
        increaseQuality(item);
      }
    } else if (isAgedBrie(item)) {
      increaseQuality(item);
    } else if (isConjured(item)) {
      decreaseQuality(item, DOUBLE_QUALITY_UNIT);
    } else {
      decreaseQuality(item);
    }
  }

  /**
   * @param item
   * @return
   */
  private boolean isConjured(Item item) {

    return CONJURED_ITEM.equals(item.getName());
  }

  /**
   * @param item
   * @return
   */
  private boolean isAgedBrie(Item item) {

    boolean isAgedBrie = AGED_BRIE.equals(item.getName());
    return isAgedBrie;
  }

  /**
   * @param item
   * @return
   */
  private boolean isPasses(Item item) {

    boolean isPasses = BACKSTAGE_PASSES.equals(item.getName());
    return isPasses;
  }

  private void setZeroQuality(Item item) {

    item.setQuality(0);
  }

  private boolean hasExpired(Item item) {

    boolean hasExpired = item.getSellIn() < DEADLINE_SELL_IN;
    return hasExpired;
  }

  private void decreaseSellIn(Item item) {

    if (isSulfuras(item))
      return;
    item.setSellIn(item.getSellIn() - SELL_IN_UNIT);
  }

  /**
   * @param name
   * @return
   */
  private boolean isSulfuras(Item item) {

    return SULFURAS.equals(item.getName());
  }

  private boolean notMaxQuality(Item item) {

    boolean notMaxQuality = item.getQuality() < MAX_QUALITY;
    return notMaxQuality;
  }

  private boolean isMinQuality(Item item) {

    boolean isMinQuality = item.getQuality() <= MIN_QUALITY;
    return isMinQuality;
  }

  private void increaseQuality(Item item) {

    boolean isMaxQuality = !notMaxQuality(item);
    if (isMaxQuality)
      return;
    item.setQuality(item.getQuality() + QUALITY_UNIT);
  }

  private void decreaseQuality(Item item, int decreaseUnits) {

    item.setQuality(item.getQuality() - decreaseUnits);
  }

  private void decreaseQuality(Item item) {

    if (isSulfuras(item))
      return;

    if (isMinQuality(item))
      return;

    decreaseQuality(item, QUALITY_UNIT);
  }
}