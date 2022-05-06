package com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.original;

/**
 * Original
 */
public class RuleEngine {

  public enum Result {
    DRAW, WIN, LOSE
  }

  public enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
  }

  public Result play(Move movePlayer1, Move movePlayer2) {

    if (movePlayer1.equals(movePlayer2))
      return Result.DRAW;

    else if (movePlayer1.equals(Move.SCISSORS) && (movePlayer2.equals(Move.PAPER) || movePlayer2.equals(Move.LIZARD)))
      return Result.WIN;

    else if (movePlayer1.equals(Move.PAPER) && (movePlayer2.equals(Move.ROCK) || movePlayer2.equals(Move.SPOCK)))
      return Result.WIN;

    else if (movePlayer1.equals(Move.ROCK) && (movePlayer2.equals(Move.LIZARD) || movePlayer2.equals(Move.SCISSORS)))
      return Result.WIN;

    else if (movePlayer1.equals(Move.LIZARD) && (movePlayer2.equals(Move.SPOCK) || movePlayer2.equals(Move.PAPER)))
      return Result.WIN;

    else if (movePlayer1.equals(Move.SPOCK) && (movePlayer2.equals(Move.SCISSORS) || movePlayer2.equals(Move.ROCK)))
      return Result.WIN;

    return Result.LOSE;
  }

}
