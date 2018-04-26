package com.capgemini.coedevon.codingdojo.katafinder;

@SuppressWarnings({ "javadoc" })
public class PersonCouple {
  private Person younger;

  private Person older;

  /**
   * @return younger
   */
  public Person getYounger() {

    return this.younger;
  }

  /**
   * @param younger new value of {@link #getyounger}.
   */
  public void setYounger(Person younger) {

    this.younger = younger;
  }

  /**
   * @return older
   */
  public Person getOlder() {

    return this.older;
  }

  /**
   * @param older new value of {@link #getolder}.
   */
  public void setOlder(Person older) {

    this.older = older;
  }

  /**
   * @return ageDiff
   */
  public long getAgeDiff() {

    return getOlder().getBirthDate().getTime() - getYounger().getBirthDate().getTime();
  }

}
