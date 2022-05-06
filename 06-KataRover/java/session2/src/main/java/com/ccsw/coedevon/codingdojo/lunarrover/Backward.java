package com.ccsw.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public class Backward implements Command {

  @Override
  public void execute(Rover rover) {

    rover.moveBackward();
  }

  @Override
  public void undo(Rover rover) {

    rover.moveForward();
  }

}
