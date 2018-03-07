package com.capgemini.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public class TurnLeft implements Command {

  @Override
  public void execute(Rover rover) {

    rover.turnLeft();
  }

  @Override
  public void undo(Rover rover) {

    rover.turnRight();
  }

}
