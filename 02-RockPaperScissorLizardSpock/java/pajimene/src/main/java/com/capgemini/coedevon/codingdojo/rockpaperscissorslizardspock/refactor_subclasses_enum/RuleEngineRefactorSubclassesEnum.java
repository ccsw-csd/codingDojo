package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses_enum;

/**
 * Tip #4. Replace Conditional with Polymorphism
 */
public class RuleEngineRefactorSubclassesEnum {

  public enum Result {
    DRAW, WIN, LOSE
  }

  public Result play(Move movePlayer1, Move movePlayer2) {

    if (isSameMoves(movePlayer1, movePlayer2))
      return Result.DRAW;

    return movePlayer1.calculateResult(movePlayer2);
  }

  private boolean isSameMoves(Move movePlayer1, Move movePlayer2) {

    return movePlayer1.equals(movePlayer2);
  };

}
