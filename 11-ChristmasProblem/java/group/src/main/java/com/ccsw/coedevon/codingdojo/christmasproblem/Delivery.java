package com.ccsw.coedevon.codingdojo.christmasproblem;

import java.util.List;

/**
 * @author ccsw
 *
 */
public class Delivery {

  public String name;

  public List<String> presents;

  /**
   * @param present
   */
  public void addPresent(String present) {

    if (notInDelivery(present)) {
      this.presents.add(present);
    }
  }

  /**
   *
   * @param wish
   * @return
   */
  public boolean notInDelivery(String wish) {

    return !this.presents.contains(wish);
  }

}
