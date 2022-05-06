package com.ccsw.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public class Forward implements Command {

  @Override
  public void execute(Rover rover) {

    rover.moveForward();
  }

  @Override
  public void undo(Rover rover) {

    rover.moveBackward();
  }

}
