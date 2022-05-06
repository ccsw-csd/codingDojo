package com.ccsw.coedevon.codingdojo.katapotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * jUnit Test KataPotter
 */
@SuppressWarnings("javadoc")
public class TestKataPotter {

  private static final double UNIT_PRICE = 8.0;

  private ShoppingCart cart;

  @Before
  public void init() {

    this.cart = new ShoppingCart();

  }

  @Test
  public void three_first_book_two_second_book_one_third_book_has_one_discount_for_three_and_one_discount_for_two() {

    addToCart("One", "One", "One", "Two", "Two", "Three");

    Assert.assertEquals((UNIT_PRICE * 3.0 * 0.90) + (UNIT_PRICE * 2.0 * 0.95) + (UNIT_PRICE), this.cart.checkout(), 0);
  }

  @Test
  public void five_books_of_all_collection_has_discount_for_seven() {

    addToCart("One", "Two", "Three", "Four", "Five", "Six", "Seven", //
        "One", "Two", "Three", "Four", "Five", "Six", "Seven", //
        "One", "Two", "Three", "Four", "Five", "Six", "Seven", //
        "One", "Two", "Three", "Four", "Five", "Six", "Seven", //
        "One", "Two", "Three", "Four", "Five", "Six", "Seven");

    Assert.assertEquals(5.0 * (UNIT_PRICE * 7.0 * 0.55), this.cart.checkout(), 0);
  }

  @Test
  public void two_first_book_and_one_second_book_and_third_book_has_discount_for_three() {

    addToCart("One", "Two", "One", "Three");
    Assert.assertEquals(UNIT_PRICE + UNIT_PRICE * 3 * 0.90, this.cart.checkout(), 0);
  }

  @Test
  public void two_first_book_and_one_second_book_has_discount_for_two() {

    addToCart("One", "Two", "One");
    Assert.assertEquals(UNIT_PRICE + UNIT_PRICE * 2 * 0.95, this.cart.checkout(), 0);
  }

  @Test
  public void seven_different_books_has_discount_for_seven() {

    addToCart("One", "Two", "Three", "Four", "Five", "Six", "Seven");
    Assert.assertEquals(UNIT_PRICE * 7 * 0.55, this.cart.checkout(), 0);
  }

  @Test
  public void six_different_books_has_discount_for_six() {

    addToCart("One", "Two", "Three", "Four", "Five", "Six");
    Assert.assertEquals(UNIT_PRICE * 6 * 0.70, this.cart.checkout(), 0);
  }

  @Test
  public void five_different_books_has_discount_for_five() {

    addToCart("One", "Two", "Three", "Four", "Five");
    Assert.assertEquals(UNIT_PRICE * 5 * 0.80, this.cart.checkout(), 0);
  }

  @Test
  public void four_different_books_has_discount_for_four() {

    addToCart("One", "Two", "Three", "Four");
    Assert.assertEquals(UNIT_PRICE * 4 * 0.85, this.cart.checkout(), 0);
  }

  @Test
  public void three_different_books_has_discount_for_three() {

    addToCart("One", "Two", "Three");
    Assert.assertEquals(UNIT_PRICE * 3 * 0.90, this.cart.checkout(), 0);

    addToCart("Two", "Four", "Three");
    Assert.assertEquals(UNIT_PRICE * 3 * 0.90, this.cart.checkout(), 0);

    addToCart("Six", "Four", "Five");
    Assert.assertEquals(UNIT_PRICE * 3 * 0.90, this.cart.checkout(), 0);
  }

  @Test
  public void two_different_books_has_discount_for_two() {

    addToCart("One", "Two");
    Assert.assertEquals(UNIT_PRICE * 2 * 0.95, this.cart.checkout(), 0);

    addToCart("One", "Three");
    Assert.assertEquals(UNIT_PRICE * 2 * 0.95, this.cart.checkout(), 0);

    addToCart("Five", "One");
    Assert.assertEquals(UNIT_PRICE * 2 * 0.95, this.cart.checkout(), 0);
  }

  @Test
  public void one_book_has_no_discount() {

    addToCart("One");
    Assert.assertEquals(UNIT_PRICE, this.cart.checkout(), 0);

    addToCart("Two");
    Assert.assertEquals(UNIT_PRICE, this.cart.checkout(), 0);

    addToCart("Three");
    Assert.assertEquals(UNIT_PRICE, this.cart.checkout(), 0);

    addToCart("Four");
    Assert.assertEquals(UNIT_PRICE, this.cart.checkout(), 0);

    addToCart("Five");
    Assert.assertEquals(UNIT_PRICE, this.cart.checkout(), 0);

    addToCart("Six");
    Assert.assertEquals(UNIT_PRICE, this.cart.checkout(), 0);

    addToCart("Seven");
    Assert.assertEquals(UNIT_PRICE, this.cart.checkout(), 0);
  }

  @Test
  public void zero_books_return_zero() {

    Assert.assertEquals(0, this.cart.checkout(), 0);
  }

  private void addToCart(String... books) {

    this.cart.clear();

    for (String book : books) {
      this.cart.add(new Book(book));
    }

  }

}
