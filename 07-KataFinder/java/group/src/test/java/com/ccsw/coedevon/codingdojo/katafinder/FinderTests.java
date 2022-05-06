package com.ccsw.coedevon.codingdojo.katafinder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings({ "javadoc", "deprecation" })
public class FinderTests {

  Person sue;

  Person greg;

  Person sarah;

  Person mike;

  @Before
  public void setup() {

    this.sue = new Person("Sue", new Date(50, 0, 1));

    this.greg = new Person("Greg", new Date(52, 5, 1));

    this.sarah = new Person("Sarah", new Date(82, 0, 1));

    this.mike = new Person("Mike", new Date(79, 0, 1));

  }

  @Test
  public void Returns_Empty_Results_When_Given_Empty_List() {

    List<Person> list = new ArrayList<>();
    Finder finder = new Finder(list);

    PersonCouple result = finder.Find(CriteriaFinder.Closest);
    assertEquals(null, result.getYounger());

    assertEquals(null, result.getOlder());
  }

  @Test
  public void Returns_Empty_Results_When_Given_One_Person() {

    List<Person> list = new ArrayList<>();
    list.add(this.sue);

    Finder finder = new Finder(list);

    PersonCouple result = finder.Find(CriteriaFinder.Closest);

    assertEquals(null, result.getYounger());
    assertEquals(null, result.getOlder());
  }

  @Test
  public void Returns_Closest_Two_For_Two_People() {

    List<Person> list = new ArrayList<>();
    list.add(this.sue);
    list.add(this.greg);
    Finder finder = new Finder(list);

    PersonCouple result = finder.Find(CriteriaFinder.Closest);

    assertEquals(this.sue, result.getYounger());
    assertEquals(this.greg, result.getOlder());
  }

  @Test
  public void Returns_Furthest_Two_For_Two_People() {

    List<Person> list = new ArrayList<>();
    list.add(this.mike);
    list.add(this.greg);

    Finder finder = new Finder(list);

    PersonCouple result = finder.Find(CriteriaFinder.Furthest);

    assertEquals(this.greg, result.getYounger());
    assertEquals(this.mike, result.getOlder());
  }

  @Test
  public void Returns_Furthest_Two_For_Four_People() {

    List<Person> list = new ArrayList<>();
    list.add(this.sue);
    list.add(this.sarah);
    list.add(this.mike);
    list.add(this.greg);
    Finder finder = new Finder(list);

    PersonCouple result = finder.Find(CriteriaFinder.Furthest);

    assertEquals(this.sue, result.getYounger());
    assertEquals(this.sarah, result.getOlder());
  }

  @Test
  public void Returns_Closest_Two_For_Four_People() {

    List<Person> list = new ArrayList<>();
    list.add(this.sue);
    list.add(this.sarah);
    list.add(this.mike);
    list.add(this.greg);

    Finder finder = new Finder(list);

    PersonCouple result = finder.Find(CriteriaFinder.Closest);

    assertEquals(this.sue, result.getYounger());
    assertEquals(this.greg, result.getOlder());
  }

}
