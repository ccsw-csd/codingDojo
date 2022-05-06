package com.ccsw.coedevon.codingdojo.katapotter;

/**
 * @author pajimene
 *
 */
@SuppressWarnings("javadoc")
public class Book {

  private String ISBN;

  public Book(String ISBN) {
    this.ISBN = ISBN;
  }

  @Override
  public boolean equals(Object o) {

    if (!(o instanceof Book))
      return false;

    Book other = (Book) o;

    return this.ISBN.equals(other.ISBN);
  }
}
