package com.ccsw.coedevon.codingdojo.katapotter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pajimene
 *
 */
@SuppressWarnings("javadoc")
public class Set {

  private List<Book> books;

  public Set() {
    this.books = new ArrayList<>();
  }

  public int size() {

    return this.books.size();
  }

  public boolean add(Book book) {

    if (this.books.contains(book))
      return false;

    this.books.add(book);
    return true;
  }

}
