package main

import (
	"testing"
)

func Test_sulfurasItemNeverChangeQualityOrSellin(t *testing.T) {
	testItemQualityAndSellin(t, SULFURAS, 10, 80, 0, 0)
}
