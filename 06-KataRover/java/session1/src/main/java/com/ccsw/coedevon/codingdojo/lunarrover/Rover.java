package com.ccsw.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public class Rover {

  private static final int MOVEMENT_UNIT = 1;

  private Point position;

  private char orientation;

  public Rover() {
    this.position = new Point();
    this.orientation = 'N';
  }

  public void sendCommand(char command) {

    switch (command) {
      case 'F':
        moveForward();
        break;
      case 'B':
        moveBackward();
        break;
      case 'R':
        turnRight();
        break;
      case 'L':
        turnLeft();
        break;
      default:
        break;
    }

  }

  private void moveBackward() {

    switch (this.orientation) {
      case 'N':
        this.position.moveY(-MOVEMENT_UNIT);
        break;
      case 'E':
        this.position.moveX(-MOVEMENT_UNIT);
        break;
      case 'S':
        this.position.moveY(MOVEMENT_UNIT);
        break;
      case 'W':
        this.position.moveX(MOVEMENT_UNIT);
        break;
    }
  }

  private void moveForward() {

    switch (this.orientation) {
      case 'N':
        this.position.moveY(MOVEMENT_UNIT);
        break;
      case 'E':
        this.position.moveX(MOVEMENT_UNIT);
        break;
      case 'S':
        this.position.moveY(-MOVEMENT_UNIT);
        break;
      case 'W':
        this.position.moveX(-MOVEMENT_UNIT);
        break;
    }
  }

  private void turnRight() {

    switch (this.orientation) {
      case 'N':
        this.orientation = 'E';
        break;
      case 'E':
        this.orientation = 'S';
        break;
      case 'S':
        this.orientation = 'W';
        break;
      case 'W':
        this.orientation = 'N';
        break;
    }
  }

  private void turnLeft() {

    switch (this.orientation) {
      case 'N':
        this.orientation = 'W';
        break;
      case 'W':
        this.orientation = 'S';
        break;
      case 'S':
        this.orientation = 'E';
        break;
      case 'E':
        this.orientation = 'N';
        break;
    }
  }

  /**
   * @return position
   */
  public Point getPosition() {

    return this.position;
  }

  /**
   * @param position new value of {@link #getPosition}.
   */
  public void setPosition(Point position) {

    this.position = position;
  }

  /**
   * @return orientation
   */
  public char getOrientation() {

    return this.orientation;
  }

  /**
   * @param orientation new value of {@link #getOrientation}.
   */
  public void setOrientation(char orientation) {

    this.orientation = orientation;
  }

}
