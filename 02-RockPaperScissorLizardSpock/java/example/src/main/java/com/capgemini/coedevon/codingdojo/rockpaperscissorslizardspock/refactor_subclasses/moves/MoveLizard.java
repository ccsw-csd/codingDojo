package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves;

import com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;

public class MoveLizard implements Move {

  @Override
  public Result calculateResult(Move opponentMove) {

    if (opponentMove instanceof MoveSpock || opponentMove instanceof MovePaper)
      return Result.WIN;

    return Result.LOSE;
  }

}
