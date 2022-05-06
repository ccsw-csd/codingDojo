package com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses;

import org.junit.Assert;
import org.junit.Test;

import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;
import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves.Move;
import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves.MoveLizard;
import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves.MovePaper;
import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves.MoveRock;
import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves.MoveScissors;
import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves.MoveSpock;

/**
 * jUnit Test RockPaperScissorsLizardSpock
 */
public class TestEngineRefactorSubclasses {

  @Test
  public void sameMovesReturnDraw() {

    assertMovesReturn(new MoveRock(), new MoveRock(), Result.DRAW);
    assertMovesReturn(new MovePaper(), new MovePaper(), Result.DRAW);
    assertMovesReturn(new MoveScissors(), new MoveScissors(), Result.DRAW);
    assertMovesReturn(new MoveLizard(), new MoveLizard(), Result.DRAW);
    assertMovesReturn(new MoveSpock(), new MoveSpock(), Result.DRAW);
  }

  @Test
  public void scissorsCutPaper() {

    assertMovesReturn(new MoveScissors(), new MovePaper(), Result.WIN);

  }

  @Test
  public void paperCoversRock() {

    assertMovesReturn(new MovePaper(), new MoveRock(), Result.WIN);

  }

  @Test
  public void rockCrushersLizard() {

    assertMovesReturn(new MoveRock(), new MoveLizard(), Result.WIN);

  }

  @Test
  public void lizzardPoisonsSpock() {

    assertMovesReturn(new MoveLizard(), new MoveSpock(), Result.WIN);

  }

  @Test
  public void spockSmashesScissors() {

    assertMovesReturn(new MoveSpock(), new MoveScissors(), Result.WIN);

  }

  @Test
  public void scissorsDecapitatesLizard() {

    assertMovesReturn(new MoveScissors(), new MoveLizard(), Result.WIN);

  }

  @Test
  public void lizardEatsPaper() {

    assertMovesReturn(new MoveLizard(), new MovePaper(), Result.WIN);

  }

  @Test
  public void paperDisprovesSpock() {

    assertMovesReturn(new MovePaper(), new MoveSpock(), Result.WIN);

  }

  @Test
  public void spockVapirizesRock() {

    assertMovesReturn(new MoveSpock(), new MoveRock(), Result.WIN);

  }

  @Test
  public void rockCrushesScissors() {

    assertMovesReturn(new MoveRock(), new MoveScissors(), Result.WIN);

  }

  @Test
  public void anyMovesReturnLose() {

    assertMovesReturn(new MovePaper(), new MoveScissors(), Result.LOSE);
    assertMovesReturn(new MoveRock(), new MovePaper(), Result.LOSE);
    assertMovesReturn(new MoveLizard(), new MoveRock(), Result.LOSE);
    assertMovesReturn(new MoveSpock(), new MoveLizard(), Result.LOSE);
    assertMovesReturn(new MoveScissors(), new MoveSpock(), Result.LOSE);
    assertMovesReturn(new MoveLizard(), new MoveScissors(), Result.LOSE);
    assertMovesReturn(new MovePaper(), new MoveLizard(), Result.LOSE);
    assertMovesReturn(new MoveSpock(), new MovePaper(), Result.LOSE);
    assertMovesReturn(new MoveRock(), new MoveSpock(), Result.LOSE);
    assertMovesReturn(new MoveScissors(), new MoveRock(), Result.LOSE);

  }

  private void assertMovesReturn(Move movePlayer1, Move movePlayer2, Result result) {

    RuleEngineRefactorSubclasses ruleEngine = new RuleEngineRefactorSubclasses();

    Assert.assertEquals(ruleEngine.play(movePlayer1, movePlayer2), result);
  }

}
