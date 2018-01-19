package com.capgemini.coedevon.codingdojo.katapotter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CoE Java Devon
 *
 */
@SuppressWarnings("javadoc")
public class ShoppingCart {

  /**
   *
   */
  private static final double DISCOUNT_FOR_TWO_BOOKS = 0.95;

  private static final double DISCOUNT_FOR_THREE_BOOKS = 0.90;

  private static final double DISCOUNT_FOR_FOUR_BOOKS = 0.85;

  private static final double DISCOUNT_FOR_FIVE_BOOKS = 0.80;

  private static final double DISCOUNT_FOR_SIX_BOOKS = 0.70;

  private static final double DISCOUNT_FOR_SEVEN_BOOKS = 0.55;

  /**
   *
   */
  private static final double UNITARY_COST = 8d;

  List<Books> listBooks;

  Map<Integer, Double> discounts = new HashMap<>();

  public ShoppingCart() {
    this.discounts.put(0, 1d);
    this.discounts.put(1, 1d);
    this.discounts.put(2, DISCOUNT_FOR_TWO_BOOKS);
    this.discounts.put(3, DISCOUNT_FOR_THREE_BOOKS);
    this.discounts.put(4, DISCOUNT_FOR_FOUR_BOOKS);
    this.discounts.put(5, DISCOUNT_FOR_FIVE_BOOKS);
    this.discounts.put(6, DISCOUNT_FOR_SIX_BOOKS);
    this.discounts.put(7, DISCOUNT_FOR_SEVEN_BOOKS);
  }

  public void addToCart(List<Books> listBooks) {

    this.listBooks = listBooks;
  }

  public double checkout() {

    if (emptyCart())
      return 0.0d;

    List<SetOfBooks> differentCollections = new ArrayList<>();
    for (Books book : this.listBooks) {
      Boolean hasNotBeenAdded = Boolean.TRUE;
      for (SetOfBooks collection : differentCollections) {
        if (collection.hasNoBook(book)) {
          collection.add(book);
          hasNotBeenAdded = Boolean.FALSE;
          break;
        }
      }
      if (hasNotBeenAdded) {
        SetOfBooks newCollection = new SetOfBooks();
        newCollection.add(book);
        differentCollections.add(newCollection);
      }
    }
    Double price = 0.0d;
    for (SetOfBooks collection : differentCollections) {
      price += getPrice(collection);
    }

    return price;
    // List<Books> uniqueBooks = getUniqueBooks();
    // int uniqueBooksSize = uniqueBooks.size();
    // Double uniqueBooksPrice = getUniqueBooksPrice(uniqueBooksSize);
    // return uniqueBooksPrice + (this.listBooks.size() - uniqueBooksSize) * UNITARY_COST;

  }

  /**
   * @param collection
   * @return
   */
  private Double getPrice(SetOfBooks collection) {

    Integer collectionSize = collection.size();
    return UNITARY_COST * collectionSize * this.discounts.get(collectionSize);
  }

  /**
   * @param uniqueBooksSize
   * @return
   */
  private double getUniqueBooksPrice(int uniqueBooksSize) {

    return UNITARY_COST * uniqueBooksSize * this.discounts.get(uniqueBooksSize);
  }

  /**
   * @return
   */
  private List<Books> getUniqueBooks() {

    return this.listBooks.stream().distinct().collect(Collectors.toList());
  }

  /**
   * @return
   */
  private boolean emptyCart() {

    return this.listBooks == null || this.listBooks.size() == 0;
  }

}
