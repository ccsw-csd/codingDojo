package com.ccsw.coedevon.codingdojo.christmasproblem;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ccsw
 *
 */
public class SantasAlgorithmTest {

  @Test
  public void noneChildReceiveAnyRepeatedWish() {

    List<Delivery> deliveries = launchAlgorithm();
    assertNumberPresentsByName(deliveries, "child6", 1);
  }

  @Test
  public void starPresentIsAllwaysReceived() {

    List<Delivery> deliveries = launchAlgorithm();

    assertExistsPresentsByName(deliveries, "child2", "Frozen 2");
    assertExistsPresentsByName(deliveries, "child4", "Frozen 2");
    assertExistsPresentsByName(deliveries, "child5", "Frozen 2");
    assertExistsPresentsByName(deliveries, "child8", "Frozen 2");
    assertExistsPresentsByName(deliveries, "child9", "Frozen 2");
  }

  @Test
  public void onlyBadChildrenOver5YearsReceiveCharcoal() {

    List<Delivery> deliveries = launchAlgorithm();
    assertNotExistsPresentsByName(deliveries, "child1", "Charcoal");
    assertExistsPresentsByName(deliveries, "child3", "Charcoal");
  }

  @Test
  public void goodChildrenNotReceiveCharcoal() {

    List<Delivery> deliveries = launchAlgorithm();
    assertNotExistsPresentsByName(deliveries, "child2", "Charcoal");
  }

  @Test
  public void allChildReceiveOurWishesInStock() {

    List<Delivery> deliveries = launchAlgorithm();
    assertNumberPresentsByName(deliveries, "child1", 2);
    assertNumberPresentsByName(deliveries, "child2", 3);
    assertNumberPresentsByName(deliveries, "child3", 5);
    assertNumberPresentsByName(deliveries, "child5", 3);
    assertNumberPresentsByName(deliveries, "child6", 1);
    assertNumberPresentsByName(deliveries, "child7", 4);
  }

  @Test
  public void whishesWithoutStockReceivesSnacks() {

    List<Delivery> deliveries = launchAlgorithm();
    assertExistsPresentsByName(deliveries, "child8", "Snacks");
  }

  private void assertNotExistsPresentsByName(List<Delivery> deliveries, String childName, String wish) {

    Delivery delivery = findDeliveryByChildName(childName, deliveries);

    if (delivery.presents.contains(wish))
      Assert.fail();

  }

  private void assertExistsPresentsByName(List<Delivery> deliveries, String childName, String wish) {

    Delivery delivery = findDeliveryByChildName(childName, deliveries);

    if (delivery.presents.contains(wish))
      return;

    Assert.fail();
  }

  private void assertNumberPresentsByName(List<Delivery> deliveries, String childName, int numPresents) {

    Delivery delivery = findDeliveryByChildName(childName, deliveries);
    assertEquals(delivery.toString(), numPresents, delivery.presents.size());
  }

  private List<Delivery> launchAlgorithm() {

    SantasAlgorithm santaAlgorithm = new SantasAlgorithm(createTestWharehouse());

    List<Letter> letters = createTestLetters();

    List<Delivery> deliveries = santaAlgorithm.prepare(letters);
    return deliveries;
  }

  private Delivery findDeliveryByChildName(String childName, List<Delivery> deliveries) {

    for (Delivery delivery : deliveries) {
      if (delivery.name.equals(childName))
        return delivery;
    }

    return null;
  }

  private List<Letter> createTestLetters() {

    List<Letter> letters = new ArrayList<>();
    letters.add(createLetter("child1", 2, 1, "Toy Story 5 DVD", "Dragon Snacks"));
    letters.add(createLetter("child2", 2, 10, "Frozen 2", "Dragon Snacks", "Toy Story 5 DVD"));
    letters.add(createLetter("child3", 6, 1, "Mega Bloks", "Bike", "Turbo Racers", "Dragon Snacks"));
    letters.add(createLetter("child4", 6, 4, "Turbo Racers", "Bike", "Mega Bloks", "Frozen 2"));
    letters.add(createLetter("child5", 6, 10, "Frozen 2", "Mega Bloks", "Dragon Snacks"));
    letters.add(createLetter("child6", 10, 10, "Dragon Snacks", "Dragon Snacks", "Dragon Snacks"));
    letters.add(createLetter("child7", 17, 3, "Toy Story 5 DVD", "Bike", "Turbo Racers"));
    letters.add(createLetter("child8", 17, 7, "Bike", "Frozen 2"));
    letters.add(createLetter("child9", 19, 10, "Bike", "Frozen 2"));
    return letters;
  }

  private Letter createLetter(String nameChild, int ageChild, int goodChild, String... whises) {

    return new Letter(nameChild, ageChild, goodChild, whises);
  }

  private Map<String, Integer> createTestWharehouse() {

    Map<String, Integer> stock = new HashMap<>();

    stock.put("Frozen 2", -1);
    stock.put("Charcoal", -1);

    stock.put("Dragon Snacks", 100);
    stock.put("Toy Story 5 DVD", 100);
    stock.put("Mega Bloks", 100);
    stock.put("Turbo Racers", 100);
    stock.put("Bike", 1);

    return stock;
  }

}
