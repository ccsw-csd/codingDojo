package main

type Item struct {
	name            string
	sellIn, quality int
}

var items = []*Item{
	&Item{"+5 Dexterity Vest", 10, 20},
	&Item{"Aged Brie", 2, 0},
	&Item{"Elixir of the Mongoose", 5, 7},
	&Item{"Sulfuras, Hand of Ragnaros", 0, 80},
	&Item{"Conjured Mana Cake", 3, 6},
	&Item{"Backstage passes to a TAFKAL80ETC concert", 15, 20},
	&Item{"Generic Name", 15, 20},
}

const DEXTERITY = "+5 Dexterity Vest"
const AGED_BRIE = "Aged Brie"
const ELIXIR = "Elixir of the Mongoose"
const SULFURAS = "Sulfuras, Hand of Ragnaros"
const PASSES = "Backstage passes to a TAFKAL80ETC concert"
const CONJURED = "Conjured Mana Cake"
const GENERIC_ITEM = "Generic Name"

const QUALITY_UNIT = 1
const SELLIN_UNIT = 1

const MAX_QUALITY = 50
const MIN_QUALITY = 0

const SELLIN_EXPIRED_VALUE = 0

const PASSES_THRESHOLD_DOUBLE_QUALITY = 10
const PASSES_THRESHOLD_TRIPLE_QUALITY = 5

func main() {
	updateQuality()
}

/* NAMES COMPARE */
func isNotAged(itemName string) bool {
	return itemName != AGED_BRIE
}

func isNotPasses(itemName string) bool {
	return itemName != PASSES
}

func isNotSulfuras(itemName string) bool {
	return itemName != SULFURAS
}

/* QUALITY */
func notMaxQuality(itemQuality int) bool {
	return itemQuality < MAX_QUALITY
}

func notMinQuality(itemQuality int) bool {
	return itemQuality > MIN_QUALITY
}

/* ADD AND SUBSTRACT QUALITY */
func increaseQuality(item *Item) {
	item.quality += QUALITY_UNIT
}

func decreaseQuality(item *Item) {
	item.quality -= QUALITY_UNIT
}

/* ADD AND SUBSTRACT SELLIN */
func decreaseSellIn(item *Item) {
	item.sellIn -= SELLIN_UNIT
}

func isExpired(item *Item) bool {
	return item.sellIn < SELLIN_EXPIRED_VALUE
}

func setZeroQuality(item *Item) {
	item.quality = 0
}

func updateQuality() {
	for i := 0; i < len(items); i++ {
		item := items[i]
		itemName := item.name
		itemQuality := item.quality

		isNotAged := isNotAged(itemName)
		isNotPasses := isNotPasses(itemName)
		isPasses := !isNotPasses
		isNotSulfuras := isNotSulfuras(itemName)

		belowThreasholdDoubleQuality := item.sellIn <= PASSES_THRESHOLD_DOUBLE_QUALITY
		belowThreasholdTripleQuality := item.sellIn <= PASSES_THRESHOLD_TRIPLE_QUALITY

		if isNotAged && isNotPasses {
			if notMinQuality(itemQuality) {
				if isNotSulfuras {
					decreaseQuality(items[i])
				}
			}
		} else {
			if notMaxQuality(itemQuality) {
				increaseQuality(items[i])
				if isPasses {
					if belowThreasholdDoubleQuality {
						if notMaxQuality(itemQuality) {
							increaseQuality(items[i])
						}
					}
					if belowThreasholdTripleQuality {
						if notMaxQuality(itemQuality) {
							increaseQuality(items[i])
						}
					}
				}
			}
		}

		if isNotSulfuras {
			decreaseSellIn(items[i])
		}

		if isExpired(items[i]) {
			if isNotAged {
				if isNotPasses {
					if notMinQuality(itemQuality) {
						if isNotSulfuras {
							decreaseQuality(items[i])
						}
					}
				} else {
					setZeroQuality(items[i])
				}
			} else {
				if notMaxQuality(itemQuality) {
					increaseQuality(items[i])
				}
			}
		}
	}
}
