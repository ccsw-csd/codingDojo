package com.ccsw.coedevon.codingdojo.gildedrose;

import com.ccsw.coedevon.codingdojo.gildedrose.item.Item;

/**
 * @author pajimene
 *
 */
public class GildedRoseOriginal {
  Item[] items;

  public GildedRoseOriginal(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {

    for (int i = 0; i < this.items.length; i++) {
      if (!this.items[i].getName().equals("Aged Brie")
          && !this.items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (this.items[i].getQuality() > 0) {
          if (!this.items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
            this.items[i].setQuality(this.items[i].getQuality() - 1);
          }
        }
      } else {
        if (this.items[i].getQuality() < 50) {
          this.items[i].setQuality(this.items[i].getQuality() + 1);

          if (this.items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (this.items[i].getSellIn() < 11) {
              if (this.items[i].getQuality() < 50) {
                this.items[i].setQuality(this.items[i].getQuality() + 1);
              }
            }

            if (this.items[i].getSellIn() < 6) {
              if (this.items[i].getQuality() < 50) {
                this.items[i].setQuality(this.items[i].getQuality() + 1);
              }
            }
          }
        }
      }

      if (!this.items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
        this.items[i].setSellIn(this.items[i].getSellIn() - 1);
      }

      if (this.items[i].getSellIn() < 0) {
        if (!this.items[i].getName().equals("Aged Brie")) {
          if (!this.items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (this.items[i].getQuality() > 0) {
              if (!this.items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                this.items[i].setQuality(this.items[i].getQuality() - 1);
              }
            }
          } else {
            this.items[i].setQuality(this.items[i].getQuality() - this.items[i].getQuality());
          }
        } else {
          if (this.items[i].getQuality() < 50) {
            this.items[i].setQuality(this.items[i].getQuality() + 1);
          }
        }
      }
    }
  }
}
