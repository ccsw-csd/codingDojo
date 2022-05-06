package com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_map;

import org.junit.Assert;
import org.junit.Test;

import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_map.RuleEngineRefactorMap.Move;
import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_map.RuleEngineRefactorMap.Result;

/**
 * jUnit Test RockPaperScissorsLizardSpock
 */
public class TestEngineRefactorMap {

  @Test
  public void sameMovesReturnDraw() {

    assertMovesReturn(Move.ROCK, Move.ROCK, Result.DRAW);
    assertMovesReturn(Move.PAPER, Move.PAPER, Result.DRAW);
    assertMovesReturn(Move.SCISSORS, Move.SCISSORS, Result.DRAW);
    assertMovesReturn(Move.LIZARD, Move.LIZARD, Result.DRAW);
    assertMovesReturn(Move.SPOCK, Move.SPOCK, Result.DRAW);
  }

  @Test
  public void scissorsCutPaper() {

    assertMovesReturn(Move.SCISSORS, Move.PAPER, Result.WIN);

  }

  @Test
  public void paperCoversRock() {

    assertMovesReturn(Move.PAPER, Move.ROCK, Result.WIN);

  }

  @Test
  public void rockCrushersLizard() {

    assertMovesReturn(Move.ROCK, Move.LIZARD, Result.WIN);

  }

  @Test
  public void lizzardPoisonsSpock() {

    assertMovesReturn(Move.LIZARD, Move.SPOCK, Result.WIN);

  }

  @Test
  public void spockSmashesScissors() {

    assertMovesReturn(Move.SPOCK, Move.SCISSORS, Result.WIN);

  }

  @Test
  public void scissorsDecapitatesLizard() {

    assertMovesReturn(Move.SCISSORS, Move.LIZARD, Result.WIN);

  }

  @Test
  public void lizardEatsPaper() {

    assertMovesReturn(Move.LIZARD, Move.PAPER, Result.WIN);

  }

  @Test
  public void paperDisprovesSpock() {

    assertMovesReturn(Move.PAPER, Move.SPOCK, Result.WIN);

  }

  @Test
  public void spockVapirizesRock() {

    assertMovesReturn(Move.SPOCK, Move.ROCK, Result.WIN);

  }

  @Test
  public void rockCrushesScissors() {

    assertMovesReturn(Move.ROCK, Move.SCISSORS, Result.WIN);

  }

  @Test
  public void anyMovesReturnLose() {

    assertMovesReturn(Move.PAPER, Move.SCISSORS, Result.LOSE);
    assertMovesReturn(Move.ROCK, Move.PAPER, Result.LOSE);
    assertMovesReturn(Move.LIZARD, Move.ROCK, Result.LOSE);
    assertMovesReturn(Move.SPOCK, Move.LIZARD, Result.LOSE);
    assertMovesReturn(Move.SCISSORS, Move.SPOCK, Result.LOSE);
    assertMovesReturn(Move.LIZARD, Move.SCISSORS, Result.LOSE);
    assertMovesReturn(Move.PAPER, Move.LIZARD, Result.LOSE);
    assertMovesReturn(Move.SPOCK, Move.PAPER, Result.LOSE);
    assertMovesReturn(Move.ROCK, Move.SPOCK, Result.LOSE);
    assertMovesReturn(Move.SCISSORS, Move.ROCK, Result.LOSE);

  }

  private void assertMovesReturn(Move movePlayer1, Move movePlayer2, Result result) {

    RuleEngineRefactorMap ruleEngine = new RuleEngineRefactorMap();

    Assert.assertEquals(ruleEngine.play(movePlayer1, movePlayer2), result);
  }

}
