package com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves;

import com.ccsw.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;

public interface Move {

  Result calculateResult(Move opponentMove);

}
