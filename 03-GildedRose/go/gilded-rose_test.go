package main

import (
	"fmt"
	"testing"
)

const EQUALSERROR = "Expected %v but was %v"

func testItemQuality(t *testing.T, itemName string, initialSellIn int, initialQuality int, deltaQuality int) {
	testItemQualityAndSellin(t, itemName, initialSellIn, initialQuality, deltaQuality, 1)
}

func testItemQualityAndSellin(t *testing.T, itemName string, initialSellIn int, initialQuality int, deltaQuality int, deltaSellin int) {
	items = []*Item{
		&Item{itemName, initialSellIn, initialQuality},
	}

	main()

	assertEqual(t, initialQuality+deltaQuality, items[0].quality)
	assertEqual(t, initialSellIn-deltaSellin, items[0].sellIn)
}

func assertEqual(t *testing.T, a interface{}, b interface{}) {
	if a == b {
		return
	}

	message := fmt.Sprintf(EQUALSERROR, a, b)

	t.Fatal(message)
}
