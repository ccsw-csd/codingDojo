package main

import (
	"testing"
)

func Test_backstageItemIncreaseQualityOnePerDay(t *testing.T) {
	testItemQuality(t, PASSES, 20, 20, 1)
}

func Test_backstageItemIncreaseQualityTwoPerDayWhenTenOrMinusDaysSellin(t *testing.T) {
	testItemQuality(t, PASSES, 10, 20, 2)
}

func Test_backstageItemIncreaseQualityThreePerDayWhenFiveOrMinusDaysSellin(t *testing.T) {
	testItemQuality(t, PASSES, 5, 20, 3)
}

func Test_backstageItemQualityZeroWhenSellinPassed(t *testing.T) {
	testItemQuality(t, PASSES, 0, 20, -20)
}
