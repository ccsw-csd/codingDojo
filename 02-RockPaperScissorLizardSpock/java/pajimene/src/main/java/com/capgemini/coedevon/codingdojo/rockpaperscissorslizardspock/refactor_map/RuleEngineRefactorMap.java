package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_map;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

/**
 * Tip #3. Substitute Algorithm
 */
/**
 * @author pajimene
 *
 */
public class RuleEngineRefactorMap {

  private EnumMap<Move, List<Move>> rulesMap;

  public enum Result {
    DRAW, WIN, LOSE
  }

  public enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
  }

  public RuleEngineRefactorMap() {
    createRulesMap();
  }

  public Result play(Move movePlayer1, Move movePlayer2) {

    if (isSameMoves(movePlayer1, movePlayer2))
      return Result.DRAW;

    if (movePlayer1WinMovePlayer2(movePlayer1, movePlayer2))
      return Result.WIN;

    return Result.LOSE;
  }

  private void createRulesMap() {

    this.rulesMap = new EnumMap<>(Move.class);

    this.rulesMap.put(Move.SCISSORS, Arrays.asList(Move.PAPER, Move.LIZARD));
    this.rulesMap.put(Move.PAPER, Arrays.asList(Move.ROCK, Move.SPOCK));
    this.rulesMap.put(Move.ROCK, Arrays.asList(Move.LIZARD, Move.SCISSORS));
    this.rulesMap.put(Move.LIZARD, Arrays.asList(Move.SPOCK, Move.PAPER));
    this.rulesMap.put(Move.SPOCK, Arrays.asList(Move.SCISSORS, Move.ROCK));
  }

  private boolean movePlayer1WinMovePlayer2(Move movePlayer1, Move movePlayer2) {

    List<Move> movesForWin = this.rulesMap.get(movePlayer1);
    return movesForWin.contains(movePlayer2);
  }

  private boolean isSameMoves(Move movePlayer1, Move movePlayer2) {

    return movePlayer1.equals(movePlayer2);
  };

}
