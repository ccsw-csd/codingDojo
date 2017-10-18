package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock;

import org.junit.Assert;
import org.junit.Test;

/**
 * jUnit Test RockPaperScissorsLizardSpock
 */
public class RockPaperTest {

  // rockCrushersLizard
  // lizzardPoisonsSpock
  // spockSmashesScissors
  // scissorsDecapitatesLizard
  // lizardEatsPaper
  //
  // spockVapirizesRock
  // rockCrushesScissors
  // anyMovesReturnLose

  private final RockPaper GAME = new RockPaper();

  @Test
  public final void sameMovesReturnDraw() {

    Assert.assertEquals(RockPaper.DRAW, this.GAME.play(RockPaper.SCISSORS, RockPaper.SCISSORS));
    Assert.assertEquals(RockPaper.DRAW, this.GAME.play(RockPaper.PAPER, RockPaper.PAPER));
    Assert.assertEquals(RockPaper.DRAW, this.GAME.play(RockPaper.ROCK, RockPaper.ROCK));
    Assert.assertEquals(RockPaper.DRAW, this.GAME.play(RockPaper.LIZZARD, RockPaper.LIZZARD));
    Assert.assertEquals(RockPaper.DRAW, this.GAME.play(RockPaper.SPOCK, RockPaper.SPOCK));
  }

  @Test
  public final void scissorsCutPaper() {

    Assert.assertEquals(RockPaper.WINPLAYERONE, this.GAME.play(RockPaper.SCISSORS, RockPaper.PAPER));

    Assert.assertEquals(RockPaper.WINPLAYERTWO, this.GAME.play(RockPaper.PAPER, RockPaper.SCISSORS));
  }

  @Test
  public final void paperCoversRock() {

    Assert.assertEquals(RockPaper.WINPLAYERONE, this.GAME.play(RockPaper.PAPER, RockPaper.ROCK));

    Assert.assertEquals(RockPaper.WINPLAYERTWO, this.GAME.play(RockPaper.ROCK, RockPaper.PAPER));
  }

  @Test
  public final void rockCrushersLizard() {

    Assert.assertEquals(RockPaper.WINPLAYERONE, this.GAME.play(RockPaper.ROCK, RockPaper.LIZZARD));

    Assert.assertEquals(RockPaper.WINPLAYERTWO, this.GAME.play(RockPaper.LIZZARD, RockPaper.ROCK));
  }

  @Test
  public final void paperDisprovesSpock() {

    Assert.assertEquals(RockPaper.WINPLAYERONE, this.GAME.play(RockPaper.PAPER, RockPaper.SPOCK));

    Assert.assertEquals(RockPaper.WINPLAYERTWO, this.GAME.play(RockPaper.SPOCK, RockPaper.PAPER));
  }
}
