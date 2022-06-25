package com.iestyn.carjam.puzzle.elements;

/**
 * Car is a {@link Vehicle} that's has the size of 2x1.
 */
public class Car extends Vehicle {

  /**
   * Constructor.
   */
  public Car(Integer[] headLocation, Axis axis, String vehicleId) {
    super(vehicleId);
    this.size = 2;
    this.headLocation = new Location(headLocation);
    this.axis = axis;
  }

  /**
   * Constructor.
   */
  public Car(Location headLocation, Axis axis, String vehicleId) {
    super(vehicleId);
    this.size = 2;
    this.headLocation = headLocation;
    this.axis = axis;
  }
}