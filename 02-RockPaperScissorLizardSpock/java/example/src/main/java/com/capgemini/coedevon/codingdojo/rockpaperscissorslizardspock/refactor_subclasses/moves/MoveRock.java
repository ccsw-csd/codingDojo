package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves;

import com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;

public class MoveRock implements Move {

  @Override
  public Result calculateResult(Move opponentMove) {

    if (opponentMove instanceof MoveLizard || opponentMove instanceof MoveScissors)
      return Result.WIN;

    return Result.LOSE;
  }

}
