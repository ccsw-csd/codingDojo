package com.ccsw.coedevon.codingdojo.gildedrose.item;

@SuppressWarnings("javadoc")
public abstract class Item {

  private static final int SELLIN_STEP = 1;

  protected static final int QUALITY_STEP = 1;

  private static final int MIN_SELLIN = 0;

  private static final int MAX_QUALITY = 50;

  private static final int MIN_QUALITY = 0;

  private static final String AGED_BRIE_ITEM = "Aged Brie";

  private static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

  private static final String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";

  private static final String CONJURED_ITEM = "Conjured Item";

  public String name;

  public int sellIn;

  public int quality;

  public static Item createItem(String name, int sellIn, int quality) {

    if (AGED_BRIE_ITEM.equals(name))
      return new AgedBrieItem(name, sellIn, quality);
    else if (SULFURAS_ITEM.equals(name))
      return new SulfurasItem(name, sellIn, quality);
    else if (BACKSTAGE_ITEM.equals(name))
      return new BackstageItem(name, sellIn, quality);
    else if (CONJURED_ITEM.equals(name))
      return new ConjuredItem(name, sellIn, quality);
    else
      return new GenericItem(name, sellIn, quality);

  }

  public abstract void updateQuality();

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {

    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return sellIn
   */
  public int getSellIn() {

    return this.sellIn;
  }

  /**
   * @param sellIn new value of {@link #getsellIn}.
   */
  public void setSellIn(int sellIn) {

    this.sellIn = sellIn;
  }

  /**
   * @return quality
   */
  public int getQuality() {

    return this.quality;
  }

  /**
   * @param quality new value of {@link #getquality}.
   */
  public void setQuality(int quality) {

    this.quality = quality;
  }

  /**
   * @param item
   * @return
   */
  protected boolean sellInExpired() {

    boolean hasNotSellIn = getSellIn() < MIN_SELLIN;
    return hasNotSellIn;
  }

  /**
   * @param item
   */
  protected void dropQuality() {

    setQuality(0);
  }

  /**
   * @param item
   */
  protected void decrementSellIn() {

    setSellIn(getSellIn() - SELLIN_STEP);
  }

  /**
   * @param item
   */
  protected void increaseQuality() {

    if (maxQualityReached())
      return;

    setQuality(getQuality() + QUALITY_STEP);
  }

  /**
   * @param item
   * @return
   */
  protected boolean maxQualityReached() {

    return getQuality() >= MAX_QUALITY;
  }

  protected void decreaseQuality() {

    decreaseQuality(QUALITY_STEP);
  }

  /**
   * @param item
   */
  protected void decreaseQuality(int qualityStep) {

    if (hasNotQuality())
      return;

    setQuality(getQuality() - qualityStep);
  }

  /**
   * @param item
   * @return
   */
  protected boolean hasNotQuality() {

    return getQuality() <= MIN_QUALITY;
  }
}
