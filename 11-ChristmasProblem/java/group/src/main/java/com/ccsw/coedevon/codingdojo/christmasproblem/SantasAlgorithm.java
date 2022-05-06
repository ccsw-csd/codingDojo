package com.ccsw.coedevon.codingdojo.christmasproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ccsw
 */
public class SantasAlgorithm {

  /**
   *
   */
  private static final int CHARCOAL_AGE_MINIMUM = 5;

  /**
   *
   */
  private static final int EVIL_LIMIT = 5;

  /**
   *
   */
  private static final String FROZEN_2 = "Frozen 2";

  /**
   *
   */
  private static final String CHARCOAL = "Charcoal";

  /**
   *
   */
  private static final String SNACKS = "Snacks";

  Map<String, Integer> warehouse;

  public SantasAlgorithm(Map<String, Integer> warehouse) {

    this.warehouse = warehouse;
  }

  public List<Delivery> prepare(List<Letter> letters) {

    Collections.sort(letters);
    List<Delivery> listDeliveries = new ArrayList<>();

    for (Letter letter : letters) {

      Delivery delivery = new Delivery();
      delivery.presents = new ArrayList<>();
      delivery.name = letter.name;
      listDeliveries.add(delivery);

      for (String wish : letter.wishes) {

        giveWish(delivery, wish);

        givePunishment(delivery, letter);
      }
    }

    return listDeliveries;

  }

  /**
   * @param delivery
   * @param childWasBad
   * @param charcoalElegibility
   */
  private void givePunishment(Delivery delivery, Letter letter) {

    boolean childWasBad = letter.good <= EVIL_LIMIT;
    boolean charcoalElegibility = letter.age > CHARCOAL_AGE_MINIMUM;

    if (childWasBad) {
      if (charcoalElegibility) {
        delivery.addPresent(CHARCOAL);
      }
    }
  }

  /**
   * @param delivery
   * @param wish
   * @param wishIsCharcoal
   * @param wishIsFrozen2
   */
  private void giveWish(Delivery delivery, String wish) {

    boolean wishIsCharcoal = wish.equals(CHARCOAL);
    boolean wishIsFrozen2 = wish.equals(FROZEN_2);

    if (wishIsCharcoal || wishIsFrozen2) {
      delivery.addPresent(wish);
    } else {
      if (hasStock(wish)) {
        decreaseStock(wish);
        delivery.addPresent(wish);
      } else {
        delivery.addPresent(SNACKS);
      }
    }
  }

  /**
   * @param wish
   */
  private void decreaseStock(String wish) {

    this.warehouse.put(wish, this.warehouse.get(wish) - 1);
  }

  /**
   * @param wish
   * @return
   */
  private boolean hasStock(String wish) {

    return this.warehouse.containsKey(wish) && this.warehouse.get(wish).intValue() > 0;
  }

}
