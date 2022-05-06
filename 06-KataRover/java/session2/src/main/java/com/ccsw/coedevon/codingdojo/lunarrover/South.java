package com.ccsw.coedevon.codingdojo.lunarrover;

import java.util.Objects;

/**
 * @author pajimene
 *
 */
public class South implements Orientation {

  private static Orientation instance;

  private South() {

  }

  public static Orientation getInstance() {

    if (Objects.isNull(instance)) {
      instance = new South();
    }
    return instance;
  }

  @Override
  public void turnLeft(Rover rover) {

    rover.setOrientation(East.getInstance());

  }

  @Override
  public void turnRight(Rover rover) {

    rover.setOrientation(West.getInstance());

  }

  @Override
  public char getOrientation() {

    return 'S';
  }

  @Override
  public void moveForward(Rover rover) {

    rover.getPosition().moveY(-MOVEMENT_UNIT);
  }

  @Override
  public void moveBackward(Rover rover) {

    rover.getPosition().moveY(MOVEMENT_UNIT);
  }

}
