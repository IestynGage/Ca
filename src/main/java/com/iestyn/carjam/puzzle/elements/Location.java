package com.iestyn.carjam.puzzle.elements;

import java.util.Objects;

/**
 * Location.
 */
public class Location {
  private Integer axisX;
  private Integer axisY;

  /**
   * Constructor sets each axis manually.
   */
  public Location(Integer axisX, Integer axisY) {
    this.axisX = axisX;
    this.axisY = axisY;
  }

  /**
   * Constructor sets the location with integer array.
   */
  public Location(Integer[] location) {
    if (location.length == 2) {
      axisX = location[0];
      axisY = location[1];
    }
  }

  /**
   * Clones the Location object. Creates a deep copy of the object.
   */
  public Location(Location originalLocation) {
    this.axisX = Integer.valueOf(originalLocation.getAxisX());
    this.axisY = Integer.valueOf(originalLocation.getAxisY());
  }

  /**
   * Creates an integer array with data of location
   * Array position 0 is xAxis.
   * Array Position 1 is yAxis
   *
   * @return Integer array of location
   */
  public Integer[] toArray() {
    return new Integer[]{axisX, axisY};
  }

  /**
   * Adds an integer amount depending on the axis set in parameter.
   */
  public void add(Axis axis, Integer amount) {
    if (axis == Axis.Horizontal) {
      axisX += amount;
    } else {
      axisY += amount;
    }
  }

  public int getAxisX() {
    return axisX;
  }

  public int getAxisY() {
    return axisY;
  }

  /**
   * Returns integer value of difference between one object and another on the bases of one axis.
   */
  public Integer minus(Location other) {
    if (this.getAxisY() - other.getAxisY() != 0) {
      return this.getAxisY() - other.getAxisY();
    } else if ((this.getAxisX() - other.getAxisX()) != 0) {
      return  this.getAxisX() - other.getAxisX();
    } else {
      return 0;
    }
  }

  /**
   * Returns object in string format.
   *
   * @return String of location's axis
   */
  public String toString() {
    return "Location:" + axisX + "," + axisY;
  }

  /**
   * Checks if two locations are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(axisX, location.axisX)
        && Objects.equals(axisY, location.axisY);
  }

  @Override
  public int hashCode() {
    return Objects.hash(axisX, axisY);
  }
}