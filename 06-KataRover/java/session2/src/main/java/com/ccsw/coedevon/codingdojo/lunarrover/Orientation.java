package com.ccsw.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public interface Orientation {

  static final int MOVEMENT_UNIT = 1;

  void turnLeft(Rover rover);

  void turnRight(Rover rover);

  char getOrientation();

  void moveForward(Rover rover);

  void moveBackward(Rover rover);

}
