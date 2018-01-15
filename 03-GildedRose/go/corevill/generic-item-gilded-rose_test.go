package main

import (
	"testing"
)

func Test_genericItemDecreaseQualityOnePerDay(t *testing.T) {
	testItemQuality(t, GENERIC_ITEM, 10, 10, -1)
}

func Test_genericItemDecreaseQualityTwoPerDayWhenSellDatePass(t *testing.T) {
	testItemQuality(t, GENERIC_ITEM, 0, 10, -2)
}

func Test_genericItemQualityCanNeverBeNegative(t *testing.T) {
	testItemQuality(t, GENERIC_ITEM, 10, 0, 0)
}
