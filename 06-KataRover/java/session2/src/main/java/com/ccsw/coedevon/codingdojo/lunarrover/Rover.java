package com.ccsw.coedevon.codingdojo.lunarrover;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pajimene
 *
 */
public class Rover {

  private Point position;

  private Orientation orientation;

  private List<Command> commandHistory;

  public Rover() {
    this.commandHistory = new ArrayList<>();
    this.position = new Point();
    this.orientation = North.getInstance();
  }

  public void sendCommand(char commandChar) {

    if (commandChar == 'U') {
      undoCommand();
    } else {
      executeCommand(commandChar);
    }
  }

  /**
   * @param commandChar
   */
  private void executeCommand(char commandChar) {

    Command command = null;
    switch (commandChar) {
      case 'F':
        command = new Forward();
        break;
      case 'B':
        command = new Backward();
        break;
      case 'R':
        command = new TurnRight();
        break;
      case 'L':
        command = new TurnLeft();
        break;
      default:
        break;
    }
    if (command != null) {
      command.execute(this);
      this.commandHistory.add(command);
    }
  }

  /**
   *
   */
  private void undoCommand() {

    if (this.commandHistory.isEmpty())
      return;

    Command commandUndo = this.commandHistory.get(this.commandHistory.size() - 1);
    commandUndo.undo(this);
    this.commandHistory.remove(this.commandHistory.size() - 1);
  }

  public void moveBackward() {

    this.orientation.moveBackward(this);
  }

  public void moveForward() {

    this.orientation.moveForward(this);
  }

  public void turnRight() {

    this.orientation.turnRight(this);
  }

  public void turnLeft() {

    this.orientation.turnLeft(this);
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

    return this.orientation.getOrientation();
  }

  /**
   * @param orientation new value of {@link #getOrientation}.
   */
  public void setOrientation(Orientation orientation) {

    this.orientation = orientation;
  }

}
