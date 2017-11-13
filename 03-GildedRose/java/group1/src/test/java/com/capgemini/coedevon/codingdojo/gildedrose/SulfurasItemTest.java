package com.capgemini.coedevon.codingdojo.gildedrose;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class SulfurasItemTest extends AbstractGildedRoseTest {

  protected static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

  @Test
  public void sulfurasItemNeverChangeQualityOrSellin() {

    testItemQualityAndSellin(new Item(SULFURAS_ITEM), 10, 80, 0, 0);

  }

}
