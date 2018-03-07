package com.capgemini.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public class TurnRight implements Command {

  @Override
  public void execute(Rover rover) {

    rover.turnRight();
  }

  @Override
  public void undo(Rover rover) {

    rover.turnLeft();
  }

}
