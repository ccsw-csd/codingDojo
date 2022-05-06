package com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor;

/**
 * Tip #1. Decompose Conditional
 * 
 * Tip #2. Replace Conditional with Guard Clauses
 */
public class RuleEngineRefactor {

  public enum Result {
    DRAW, WIN, LOSE
  }

  public enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
  }

  public Result play(Move movePlayer1, Move movePlayer2) {

    if (isSameMoves(movePlayer1, movePlayer2))
      return Result.DRAW;

    return executeRules(movePlayer1, movePlayer2);
  }

  private Result executeRules(Move movePlayer1, Move movePlayer2) {

    if (isScissors(movePlayer1) && isMoveThatScissorsWins(movePlayer2))
      return Result.WIN;

    else if (isPaper(movePlayer1) && isMoveThatPaperWins(movePlayer2))
      return Result.WIN;

    else if (isRock(movePlayer1) && isMoveThatRockWins(movePlayer2))
      return Result.WIN;

    else if (isLizard(movePlayer1) && isMoveThatLizardWins(movePlayer2))
      return Result.WIN;

    else if (isSpock(movePlayer1) && isMoveThatSpockWins(movePlayer2))
      return Result.WIN;

    return Result.LOSE;
  }

  private boolean isSpock(Move movePlayer1) {

    return movePlayer1.equals(Move.SPOCK);
  }

  private boolean isLizard(Move movePlayer1) {

    return movePlayer1.equals(Move.LIZARD);
  }

  private boolean isRock(Move movePlayer1) {

    return movePlayer1.equals(Move.ROCK);
  }

  private boolean isPaper(Move movePlayer1) {

    return movePlayer1.equals(Move.PAPER);
  }

  private boolean isScissors(Move movePlayer1) {

    return movePlayer1.equals(Move.SCISSORS);
  }

  private boolean isMoveThatSpockWins(Move movePlayer2) {

    return isScissors(movePlayer2) || isRock(movePlayer2);
  }

  private boolean isMoveThatLizardWins(Move movePlayer2) {

    return isSpock(movePlayer2) || isPaper(movePlayer2);
  }

  private boolean isMoveThatRockWins(Move movePlayer2) {

    return isLizard(movePlayer2) || isScissors(movePlayer2);
  }

  private boolean isMoveThatPaperWins(Move movePlayer2) {

    return isRock(movePlayer2) || isSpock(movePlayer2);
  }

  private boolean isMoveThatScissorsWins(Move movePlayer2) {

    return isPaper(movePlayer2) || isLizard(movePlayer2);
  }

  private boolean isSameMoves(Move movePlayer1, Move movePlayer2) {

    return movePlayer1.equals(movePlayer2);
  }

}
