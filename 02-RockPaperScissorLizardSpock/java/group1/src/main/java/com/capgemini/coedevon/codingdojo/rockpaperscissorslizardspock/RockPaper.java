package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock;

/**
 * @author pajimene
 *
 */
public class RockPaper {

  public static final int DRAW = 0;

  public static final int WINPLAYERONE = 1;

  public static final int WINPLAYERTWO = 2;

  public static final String SPOCK = "spock";

  public static final String LIZZARD = "lizzard";

  public static final String ROCK = "rock";

  public static final String PAPER = "paper";

  public static final String SCISSORS = "scissors";

  public final int play(final String playerOne, final String playerTwo) {

    int response = DRAW;

    if (isDraw(playerOne, playerTwo)) {
      response = DRAW;
    } else if (PAPER.equals(playerOne)) {
      return checkPaperRulesPlayerOne(playerTwo);
    } else if (ROCK.equals(playerOne) && PAPER.equals(playerTwo)) {
      /*
       * TODO
       * return checkRockRulesPlayerOne(playerTwo);
       */
      response = WINPLAYERTWO;
    } else if (SCISSORS.equals(playerOne) && PAPER.equals(playerTwo)) {
      response = WINPLAYERONE;
    } else if (ROCK.equals(playerOne) && LIZZARD.equals(playerTwo)) {
      response = WINPLAYERONE;
    } else if (LIZZARD.equals(playerOne) && ROCK.equals(playerTwo)) {
      response = WINPLAYERTWO;
    } else if (SPOCK.equals(playerOne) && PAPER.equals(playerTwo)) {
      response = WINPLAYERTWO;
    }

    return response;

  }

  /**
   * @param playerTwo
   * @return
   */
  private int checkPaperRulesPlayerOne(final String playerTwo) {

    if (ROCK.equals(playerTwo) || SPOCK.equals(playerTwo)) {
      return WINPLAYERONE;
    } else {
      return WINPLAYERTWO;
    }
  }

  /**
   * @param playerOne
   * @param playerTwo
   * @return
   */
  private boolean isDraw(final String playerOne, final String playerTwo) {

    return playerOne.equals(playerTwo);
  }

}
