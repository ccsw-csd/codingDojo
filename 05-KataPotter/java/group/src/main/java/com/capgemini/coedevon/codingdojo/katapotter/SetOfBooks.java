package com.capgemini.coedevon.codingdojo.katapotter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pajimene
 *
 */
public class SetOfBooks {

  Set<Books> collection;

  public SetOfBooks() {
    this.collection = new HashSet<>();
  }

  public Boolean hasNoBook(Books book) {

    return !this.collection.contains(book);
  }

  public void add(Books book) {

    this.collection.add(book);

  }

  public Integer size() {

    return this.collection.size();
  }

}
