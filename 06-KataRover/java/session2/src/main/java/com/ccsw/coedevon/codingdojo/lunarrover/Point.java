package com.ccsw.coedevon.codingdojo.lunarrover;

/**
 * @author pajimene
 *
 */
public class Point {
  private int x;

  private int y;

  public void moveX(int delta) {

    this.x += delta;
  }

  public void moveY(int delta) {

    this.y += delta;
  }

  /**
   * @return x
   */
  public int getX() {

    return this.x;
  }

  /**
   * @param x new value of {@link #getX}.
   */
  public void setX(int x) {

    this.x = x;
  }

  /**
   * @return y
   */
  public int getY() {

    return this.y;
  }

  /**
   * @param y new value of {@link #getY}.
   */
  public void setY(int y) {

    this.y = y;
  }

}
