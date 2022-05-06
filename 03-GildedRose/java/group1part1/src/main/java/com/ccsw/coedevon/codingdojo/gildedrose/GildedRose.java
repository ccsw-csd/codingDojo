package com.ccsw.coedevon.codingdojo.gildedrose;

import java.util.List;

public class GildedRose {

  /**
   *
   */
  private static final int DEADLINE_SELL_IN = 0;

  /**
   *
   */
  private static final int SELL_IN_UNIT = 1;

  /**
   *
   */
  private static final int PASSES_THRESHOLD_TRIPLE_QUALITY = 5;

  /**
   *
   */
  private static final int PASSES_THRESHOLD_DOUBLE_QUALITY = 10;

  /**
   *
   */
  private static final int MAX_QUALITY = 50;

  /**
   *
   */
  private static final int QUALITY_UNIT = 1;

  /**
   *
   */
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  /**
   *
   */
  private static final int MIN_QUALITY = 0;

  /**
   *
   */
  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  /**
   *
   */
  private static final String AGED_BRIE = "Aged Brie";

  private List<Item> items;

  public GildedRose(List<Item> items) {
    this.items = items;
  }

  public void updateQuality() {

    for (Item item : this.items) {
      String itemName = item.getName();

      boolean isNotAgedBrie = !AGED_BRIE.equals(itemName);
      boolean isPasses = BACKSTAGE_PASSES.equals(itemName);
      boolean isNotPasses = !isPasses;
      boolean isNotSulfuras = !SULFURAS.equals(itemName);

      boolean belowThresholdDoubleQuality = item.getSellIn() <= PASSES_THRESHOLD_DOUBLE_QUALITY;
      boolean belowThresholdTripleQuality = item.getSellIn() <= PASSES_THRESHOLD_TRIPLE_QUALITY;

      if (isNotAgedBrie && isNotPasses) {
        if (notMinQuality(item)) {
          if (isNotSulfuras) {
            decreaseQuality(item);
          }
        }
      } else {
        if (notMaxQuality(item)) {
          increaseQuality(item);

          if (isPasses) {
            if (belowThresholdDoubleQuality) {
              if (notMaxQuality(item)) {
                increaseQuality(item);
              }
            }

            if (belowThresholdTripleQuality) {
              if (notMaxQuality(item)) {
                increaseQuality(item);
              }
            }
          }
        }
      }

      if (isNotSulfuras) {
        decreaseSellIn(item);
      }

      if (hasExpired(item)) {
        if (isNotAgedBrie) {
          if (isNotPasses) {
            if (notMinQuality(item)) {
              if (isNotSulfuras) {
                decreaseQuality(item);
              }
            }
          } else {
            setZeroQuality(item);
          }
        } else {
          if (notMaxQuality(item)) {
            increaseQuality(item);
          }
        }
      }
    }
  }

  /**
   * @param item
   */
  private void setZeroQuality(Item item) {

    item.setQuality(0);
  }

  /**
   * @param item
   * @return
   */
  private boolean hasExpired(Item item) {

    boolean hasExpired = item.getSellIn() < DEADLINE_SELL_IN;
    return hasExpired;
  }

  /**
   * @param item
   */
  private void decreaseSellIn(Item item) {

    item.setSellIn(item.getSellIn() - SELL_IN_UNIT);
  }

  /**
   * @param item
   * @return
   */
  private boolean notMaxQuality(Item item) {

    boolean notMaxQuality = item.getQuality() < MAX_QUALITY;
    return notMaxQuality;
  }

  /**
   * @param item
   * @return
   */
  private boolean notMinQuality(Item item) {

    boolean notMinQuality = item.getQuality() > MIN_QUALITY;
    return notMinQuality;
  }

  /**
   * @param item
   */
  private void increaseQuality(Item item) {

    item.setQuality(item.getQuality() + QUALITY_UNIT);
  }

  /**
   * @param item
   */
  private void decreaseQuality(Item item) {

    item.setQuality(item.getQuality() - QUALITY_UNIT);
  }
}