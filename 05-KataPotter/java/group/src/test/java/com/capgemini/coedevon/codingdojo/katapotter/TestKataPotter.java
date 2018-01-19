package com.capgemini.coedevon.codingdojo.katapotter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * jUnit Test KataPotter
 */
@SuppressWarnings("javadoc")
public class TestKataPotter {

  ShoppingCart cart = new ShoppingCart();

  @Test
  public void zero_books_return_zero() {

    Assert.assertEquals(0, this.cart.checkout(), 0);
  }

  @Test
  public void two_sets_of_two_books_return_correct_price() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    listBooks.add(Books.TWO);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 4 * 0.95, this.cart.checkout(), 0);
  }

  @Test
  public void two_same_books_and_one_different_return_correct_price() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 2 * 0.95 + 8, this.cart.checkout(), 0);
  }

  @Test
  public void two_same_books_return_no_discount() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.ONE);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 2, this.cart.checkout(), 0);
  }

  @Test
  public void seven_different_book_return_discount_for_seven() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    listBooks.add(Books.THREE);
    listBooks.add(Books.FOUR);
    listBooks.add(Books.FIVE);
    listBooks.add(Books.SIX);
    listBooks.add(Books.SEVEN);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 7 * 0.55, this.cart.checkout(), 0);
  }

  @Test
  public void six_different_book_return_discount_for_six() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    listBooks.add(Books.THREE);
    listBooks.add(Books.FOUR);
    listBooks.add(Books.FIVE);
    listBooks.add(Books.SIX);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 6 * 0.70, this.cart.checkout(), 0);
  }

  @Test
  public void five_different_book_return_discount_for_five() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    listBooks.add(Books.THREE);
    listBooks.add(Books.FOUR);
    listBooks.add(Books.FIVE);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 5 * 0.80, this.cart.checkout(), 0);
  }

  @Test
  public void four_different_book_return_discount_for_four() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    listBooks.add(Books.THREE);
    listBooks.add(Books.FOUR);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 4 * 0.85, this.cart.checkout(), 0);
  }

  @Test
  public void three_different_book_return_discount_for_three() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    listBooks.add(Books.THREE);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 3 * 0.90, this.cart.checkout(), 0);
  }

  @Test
  public void two_different_book_return_discount_for_two() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    listBooks.add(Books.TWO);
    this.cart.addToCart(listBooks);

    Assert.assertEquals(8 * 2 * 0.95, this.cart.checkout(), 0);
  }

  @Test
  public void one_book_two_return_eight() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.TWO);
    this.cart.addToCart(listBooks);
    Assert.assertEquals(8, this.cart.checkout(), 0);
  }

  @Test
  public void one_book_return_eight() {

    List<Books> listBooks = new ArrayList<>();
    listBooks.add(Books.ONE);
    this.cart.addToCart(listBooks);
    Assert.assertEquals(8, this.cart.checkout(), 0);
  }

}
