package com.capgemini.coedevon.codingdojo.katafinder;

import java.util.Date;

@SuppressWarnings({ "javadoc" })
public class Person {
  private String name;

  private Date birthDate;

  /**
   * The constructor.
   * 
   * @param name
   * @param birthDate
   */
  public Person(String name, Date birthDate) {

    super();
    this.name = name;
    this.birthDate = birthDate;
  }

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Date getBirthDate() {

    return this.birthDate;
  }

  public void setBirthDate(Date birthDate) {

    this.birthDate = birthDate;
  }
}
