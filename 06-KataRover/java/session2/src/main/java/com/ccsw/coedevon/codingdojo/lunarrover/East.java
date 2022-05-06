package com.ccsw.coedevon.codingdojo.lunarrover;

import java.util.Objects;

/**
 * @author pajimene
 *
 */
public class East implements Orientation {
  private static Orientation instance;

  private East() {

  }

  public static Orientation getInstance() {

    if (Objects.isNull(instance)) {
      instance = new East();
    }
    return instance;
  }

  @Override
  public void turnLeft(Rover rover) {

    rover.setOrientation(North.getInstance());

  }

  @Override
  public void turnRight(Rover rover) {

    rover.setOrientation(South.getInstance());

  }

  @Override
  public char getOrientation() {

    return 'E';
  }

  @Override
  public void moveForward(Rover rover) {

    rover.getPosition().moveX(MOVEMENT_UNIT);
  }

  @Override
  public void moveBackward(Rover rover) {

    rover.getPosition().moveX(-MOVEMENT_UNIT);
  }

}
