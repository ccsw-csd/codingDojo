package com.ccsw.coedevon.codingdojo.katapotter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pajimene
 *
 */
@SuppressWarnings("javadoc")
public class ShoppingCart {

  private static final double UNIT_PRICE = 8.0;

  private Map<Integer, Double> discounts;

  private List<Book> books;

  public ShoppingCart() {
    this.books = new ArrayList<>();

    this.discounts = new HashMap<>();
    this.discounts.put(0, 1.0d);
    this.discounts.put(1, 1.0d);
    this.discounts.put(2, 0.95d);
    this.discounts.put(3, 0.90d);
    this.discounts.put(4, 0.85d);
    this.discounts.put(5, 0.80d);
    this.discounts.put(6, 0.70d);
    this.discounts.put(7, 0.55d);

  }

  public double checkout() {

    List<Set> sets = distributeInSets();

    double totalAmount = 0.0d;
    for (Set set : sets) {
      totalAmount += calculateSetPrice(set);
    }

    return totalAmount;
  }

  private List<Set> distributeInSets() {

    List<Set> sets = new ArrayList<>();

    for (Book book : this.books) {
      addToSet(sets, book);
    }

    return sets;
  }

  private void addToSet(List<Set> sets, Book book) {

    boolean isAdded = addToExistingSet(sets, book);

    if (!isAdded) {
      createNewSet(sets, book);
    }
  }

  private void createNewSet(List<Set> sets, Book book) {

    Set set = new Set();
    sets.add(set);

    set.add(book);
  }

  private boolean addToExistingSet(List<Set> sets, Book book) {

    for (Set set : sets) {
      boolean isAdded = set.add(book);

      if (isAdded)
        return true;
    }

    return false;
  }

  private double calculateSetPrice(Set set) {

    double discount = this.discounts.get(set.size());
    return set.size() * UNIT_PRICE * discount;
  }

  public void clear() {

    this.books.clear();
  }

  public void add(Book book) {

    this.books.add(book);
  }
}
