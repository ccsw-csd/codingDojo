package com.capgemini.coedevon.codingdojo.christmasproblem;

/**
 * @author ccsw
 *
 */
public class Letter implements Comparable<Letter> {

  public String[] wishes;

  public String name;

  public int good;

  public int age;

  public Letter(String name, int age, int good, String[] whishList) {

    this.name = name;
    this.age = age;
    this.good = good;
    this.wishes = whishList;
  }

  @Override
  public int compareTo(Letter let) {

    int compareOne = this.age - let.age;
    if (compareOne == 0)
      return this.good - let.good;

    return compareOne;
  }
}
