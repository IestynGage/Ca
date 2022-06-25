package com.iestyn.carjam.puzzle.elements;

/**
 * Bus is a {@link Vehicle} that's has the size of 3x1.
 */
public class Bus extends Vehicle {

  /**
   * Constructor.
   */
  public Bus(Integer[] headLocation, Axis axis, String vehicleId) {
    super(vehicleId);
    this.size = 3;
    this.headLocation = new Location(headLocation);
    this.axis = axis;
  }

  /**
   * Constructor.
   */
  public Bus(Location headLocation, Axis axis, String vehicleId) {
    super(vehicleId);
    this.size = 3;
    this.headLocation = headLocation;
    this.axis = axis;
  }
}