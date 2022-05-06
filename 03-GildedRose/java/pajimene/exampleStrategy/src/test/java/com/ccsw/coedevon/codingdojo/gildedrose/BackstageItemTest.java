package com.ccsw.coedevon.codingdojo.gildedrose;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class BackstageItemTest extends AbstractGildedRoseTest {

  protected static final String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";

  @Test
  public void backstageItemIncreaseQualityOnePerDay() {

    testItemQuality(BACKSTAGE_ITEM, 20, 20, 1);

  }

  @Test
  public void backstageItemIncreaseQualityTwoPerDayWhenTenOrMinusDaysSellin() {

    testItemQuality(BACKSTAGE_ITEM, 10, 20, 2);

  }

  @Test
  public void backstageItemIncreaseQualityThreePerDayWhenFiveOrMinusDaysSellin() {

    testItemQuality(BACKSTAGE_ITEM, 5, 20, 3);

  }

  @Test
  public void backstageItemQualityZeroWhenSellinPassed() {

    testItemQuality(BACKSTAGE_ITEM, 0, 20, -20);

  }

}
