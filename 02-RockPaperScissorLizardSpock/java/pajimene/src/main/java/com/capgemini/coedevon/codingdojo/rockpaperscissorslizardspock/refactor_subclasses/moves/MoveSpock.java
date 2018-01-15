package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves;

import com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;

public class MoveSpock implements Move {

  @Override
  public Result calculateResult(Move opponentMove) {

    if (opponentMove instanceof MoveScissors || opponentMove instanceof MoveRock)
      return Result.WIN;

    return Result.LOSE;
  }

}
