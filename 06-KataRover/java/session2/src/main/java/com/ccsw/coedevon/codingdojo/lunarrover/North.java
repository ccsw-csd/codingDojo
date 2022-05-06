package com.ccsw.coedevon.codingdojo.lunarrover;

import java.util.Objects;

/**
 * @author pajimene
 *
 */
public class North implements Orientation {

  private static Orientation instance;

  private North() {

  }

  public static Orientation getInstance() {

    if (Objects.isNull(instance)) {
      instance = new North();
    }
    return instance;
  }

  @Override
  public void turnLeft(Rover rover) {

    rover.setOrientation(West.getInstance());
  }

  @Override
  public void turnRight(Rover rover) {

    rover.setOrientation(East.getInstance());

  }

  @Override
  public char getOrientation() {

    return 'N';
  }

  @Override
  public void moveForward(Rover rover) {

    rover.getPosition().moveY(MOVEMENT_UNIT);
  }

  @Override
  public void moveBackward(Rover rover) {

    rover.getPosition().moveY(-MOVEMENT_UNIT);
  }

}
