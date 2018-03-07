package com.capgemini.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public interface Command {
  void execute(Rover rover);

  void undo(Rover rover);
}
