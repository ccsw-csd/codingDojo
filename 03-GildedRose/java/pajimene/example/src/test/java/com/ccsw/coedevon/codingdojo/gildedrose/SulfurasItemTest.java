package com.ccsw.coedevon.codingdojo.gildedrose;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class SulfurasItemTest extends AbstractGildedRoseTest {

  protected static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

  @Test
  public void sulfurasItemNeverChangeQualityOrSellin() {

    testItemQualityAndSellin(SULFURAS_ITEM, 10, 80, 0, 0);

  }

}
