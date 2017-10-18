package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.moves;

import com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock.refactor_subclasses.RuleEngineRefactorSubclasses.Result;

public interface Move {

  Result calculateResult(Move opponentMove);

}
