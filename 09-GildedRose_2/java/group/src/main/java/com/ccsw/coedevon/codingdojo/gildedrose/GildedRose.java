package com.ccsw.coedevon.codingdojo.gildedrose;

class GildedRose {
  /**
   *
   */
  private static final int TRIPLE_QUALITY_THERSHOLD = 5;

  /**
   *
   */
  private static final int DOUBLE_QUALITY_THRESHOLD = 10;

  /**
   *
   */
  private static final int MAX_QUALITY = 50;

  /**
   *
   */
  private static final int UNIT_QUALITY = 1;

  /**
   *
   */
  private static final int MIN_QUALITY = 0;

  /**
   *
   */
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  /**
   *
   */
  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  /**
   *
   */
  private static final String AGED_BRIE = "Aged Brie";

  Item[] items;

  public GildedRose(Item[] items) {

    this.items = items;
  }

  public void updateQuality() {

    for (Item item : this.items) {

      String itemName = item.getName();

      boolean notAgedBrie = !(AGED_BRIE).equals(itemName);
      boolean isBackStage = itemName.equals(BACKSTAGE_PASSES);
      boolean notBackStage = !isBackStage;
      boolean notSulfuras = !itemName.equals(SULFURAS);
      boolean isInsideDoubleQualityThreshold = item.getSellIn() <= DOUBLE_QUALITY_THRESHOLD;
      boolean isInsideTripleQualityThreshold = item.getSellIn() <= TRIPLE_QUALITY_THERSHOLD;

      if (notAgedBrie && notBackStage) {
        decreaseQuality(item);

      } else {
        increaseQuality(item);

        if (isBackStage) {
          if (isInsideDoubleQualityThreshold) {
            increaseQuality(item);

          }

          if (isInsideTripleQualityThreshold) {
            increaseQuality(item);

          }
        }

      }

      if (notSulfuras) {
        decreaseSellIn(item);
      }

      if (isExpired(item)) {
        if (notAgedBrie) {
          if (notBackStage) {
            decreaseQuality(item);

          } else {
            item.setQuality(MIN_QUALITY);
          }
        } else {
          increaseQuality(item);

        }
      }
    }
  }

  /**
   * @param item
   * @return
   */
  private boolean isExpired(Item item) {

    return item.getSellIn() < 0;
  }

  /**
   * @param item
   */
  private void decreaseSellIn(Item item) {

    item.setSellIn(item.getSellIn() - 1);
  }

  /**
   * @param item
   */
  private void increaseQuality(Item item) {

    boolean notMaxQuality = item.getQuality() < MAX_QUALITY;
    if (notMaxQuality) {
      item.setQuality(item.getQuality() + UNIT_QUALITY);
    }
  }

  /**
   * @param item
   */
  private void decreaseQuality(Item item) {

    boolean hasQuality = item.getQuality() > MIN_QUALITY;
    boolean notSulfuras = !item.getName().equals(SULFURAS);
    if (hasQuality && notSulfuras) {
      item.setQuality(item.getQuality() - UNIT_QUALITY);
    }
  }
}
