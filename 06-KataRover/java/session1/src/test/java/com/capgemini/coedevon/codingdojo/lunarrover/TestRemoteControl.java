package com.capgemini.coedevon.codingdojo.lunarrover;

import org.junit.Assert;
import org.junit.Test;

/**
 * jUnit Test Lunar Rover
 */
@SuppressWarnings("javadoc")
public class TestRemoteControl {

  private Rover rover = new Rover();

  @Test
  public void none_movements_results_initial_position() {

    check(this.rover, 'N', 0, 0);
  }

  @Test
  public void forward_result_zero_one() {

    this.rover.sendCommand('F');
    check(this.rover, 'N', 0, 1);
  }

  @Test
  public void turn_right_return_e_orientation() {

    this.rover.sendCommand('R');
    check(this.rover, 'E', 0, 0);
  }

  @Test
  public void two_times_forward_result_zero_two() {

    this.rover.sendCommand('F');
    this.rover.sendCommand('F');
    check(this.rover, 'N', 0, 2);
  }

  @Test
  public void turn_left_return_w_orientation() {

    this.rover.sendCommand('L');
    check(this.rover, 'W', 0, 0);
  }

  @Test
  public void turn_left_right_return_initial_position() {

    this.rover.sendCommand('L');
    this.rover.sendCommand('R');
    check(this.rover, 'N', 0, 0);
  }

  @Test
  public void forward_and_backward_return_inital_position() {

    this.rover.sendCommand('F');
    this.rover.sendCommand('B');
    check(this.rover, 'N', 0, 0);
  }

  @Test
  public void turn_right_and_forward_return_1_0() {

    this.rover.sendCommand('R');
    this.rover.sendCommand('F');
    check(this.rover, 'E', 1, 0);
  }

  @Test
  public void turn_left_and_backward_return_1_0() {

    this.rover.sendCommand('L');
    this.rover.sendCommand('B');
    check(this.rover, 'W', 1, 0);
  }

  private void check(Rover rover, char orientation, int x, int y) {

    Assert.assertEquals(orientation, rover.getOrientation());
    Assert.assertEquals(x, rover.getPosition().getX());
    Assert.assertEquals(y, rover.getPosition().getY());
  }

}
