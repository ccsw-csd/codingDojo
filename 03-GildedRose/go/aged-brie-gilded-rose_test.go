package main

import (
	"testing"
)

func Test_agedBrieIncreaseQualityOnePerDay(t *testing.T) {
	testItemQuality(t, AGED_BRIE, 10, 10, 1)
}

func Test_agedBrieIncreaseQualityTwoPerDayWhenSellDatePass(t *testing.T) {
	testItemQuality(t, AGED_BRIE, 0, 10, 2)
}

func Test_qualityOfItemNeverMoreThan50(t *testing.T) {
	testItemQuality(t, AGED_BRIE, 10, 50, 0)
	testItemQuality(t, AGED_BRIE, 0, 50, 0)
}
