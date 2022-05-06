package com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves;

import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;

public class MoveScissors implements Move {

  @Override
  public Result calculateResult(Move opponentMove) {

    if (opponentMove instanceof MovePaper || opponentMove instanceof MoveLizard)
      return Result.WIN;

    return Result.LOSE;
  }

}
