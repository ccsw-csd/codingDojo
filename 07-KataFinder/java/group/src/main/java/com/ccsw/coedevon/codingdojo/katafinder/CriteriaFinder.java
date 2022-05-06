package com.ccsw.coedevon.codingdojo.katafinder;

@SuppressWarnings({ "javadoc" })
public enum CriteriaFinder {
  Closest {
    @Override
    public PersonCouple execute(PersonCouple coupleA, PersonCouple coupleB) {

      PersonCouple result = coupleA;
      if (isClosest(coupleA, coupleB)) {
        result = coupleB;
      }
      return result;
    }
  },
  Furthest {
    @Override
    public PersonCouple execute(PersonCouple coupleA, PersonCouple coupleB) {

      PersonCouple result = coupleA;
      if (isFurthest(coupleA, coupleB)) {
        result = coupleB;
      }
      return result;
    }
  };
  public abstract PersonCouple execute(PersonCouple coupleA, PersonCouple coupleB);

  /**
   * @param answer
   * @param result
   * @return
   */
  private static boolean isFurthest(PersonCouple answer, PersonCouple result) {

    return result.getAgeDiff() > answer.getAgeDiff();
  }

  /**
   * @param answer
   * @param result
   * @return
   */
  private static boolean isClosest(PersonCouple answer, PersonCouple result) {

    return result.getAgeDiff() < answer.getAgeDiff();
  }

}
