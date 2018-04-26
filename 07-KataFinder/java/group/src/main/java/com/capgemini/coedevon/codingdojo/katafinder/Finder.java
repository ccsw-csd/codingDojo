package com.capgemini.coedevon.codingdojo.katafinder;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "javadoc" })
public class Finder {
  private final List<Person> persons;

  public Finder(List<Person> persons) {

    this.persons = persons;
  }

  public PersonCouple Find(CriteriaFinder criteria) {

    List<PersonCouple> coupleList = generateCoupleList();

    if (coupleList.isEmpty()) {
      return new PersonCouple();
    }

    PersonCouple answer = coupleList.get(0);
    for (PersonCouple result : coupleList) {
      answer = criteria.execute(answer, result);
    }

    return answer;
  }

  /**
   * @return
   */
  private List<PersonCouple> generateCoupleList() {

    List<PersonCouple> coupleList = new ArrayList<>();

    for (int i = 0; i < this.persons.size() - 1; i++) {
      Person personA = this.persons.get(i);

      for (int j = i + 1; j < this.persons.size(); j++) {

        Person personB = this.persons.get(j);
        PersonCouple couple = sortCouple(personA, personB);
        coupleList.add(couple);
      }
    }
    return coupleList;
  }

  /**
   * @param couple
   * @param personA
   * @param personB
   */
  private PersonCouple sortCouple(Person personA, Person personB) {

    PersonCouple couple = new PersonCouple();
    if (isYounger(personA, personB)) {
      couple.setYounger(personA);
      couple.setOlder(personB);
    } else {
      couple.setYounger(personB);
      couple.setOlder(personA);
    }

    return couple;
  }

  /**
   * @param personA
   * @param personB
   * @return
   */
  private boolean isYounger(Person personA, Person personB) {

    return personA.getBirthDate().getTime() < personB.getBirthDate().getTime();
  }
}
