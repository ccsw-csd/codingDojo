package com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses_enum;

import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses_enum.RuleEngineRefactorSubclassesEnum.Result;

public enum Move {

  ROCK {
    @Override
    public Result calculateResult(Move opponentMove) {

      if (opponentMove == LIZARD || opponentMove == SCISSORS)
        return Result.WIN;

      return Result.LOSE;
    }
  },

  PAPER {
    @Override
    public Result calculateResult(Move opponentMove) {

      if (opponentMove == ROCK || opponentMove == SPOCK)
        return Result.WIN;

      return Result.LOSE;
    }
  },

  SCISSORS {
    @Override
    public Result calculateResult(Move opponentMove) {

      if (opponentMove == PAPER || opponentMove == LIZARD)
        return Result.WIN;

      return Result.LOSE;
    }
  },

  LIZARD {
    @Override
    public Result calculateResult(Move opponentMove) {

      if (opponentMove == SPOCK || opponentMove == PAPER)
        return Result.WIN;

      return Result.LOSE;
    }
  },

  SPOCK {
    @Override
    public Result calculateResult(Move opponentMove) {

      if (opponentMove == SCISSORS || opponentMove == ROCK)
        return Result.WIN;

      return Result.LOSE;
    }
  };

  abstract Result calculateResult(Move opponentMove);
}
