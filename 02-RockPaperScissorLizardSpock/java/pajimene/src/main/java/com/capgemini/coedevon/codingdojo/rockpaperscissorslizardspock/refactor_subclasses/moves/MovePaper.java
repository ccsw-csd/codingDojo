package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves;

import com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;

public class MovePaper implements Move {

  @Override
  public Result calculateResult(Move opponentMove) {

    if (opponentMove instanceof MoveRock || opponentMove instanceof MoveSpock)
      return Result.WIN;

    return Result.LOSE;
  }

}
