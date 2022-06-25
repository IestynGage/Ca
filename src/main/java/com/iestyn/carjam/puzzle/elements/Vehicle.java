package com.iestyn.carjam.puzzle.elements;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Vehicle.
 * TODO Make abstract class.
 */
public class Vehicle extends Tile {
  Location headLocation;
  Axis axis;
  String vehicleId;
  Integer size;

  /**
   * Creates a new vehicle object with vehicleID. All other variables are null.
   */
  public Vehicle(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  /**
   * Creates a copy of another vehicle.
   */
  public Vehicle(Vehicle original) {
    this.headLocation = new Location(original.getHeadLocation());
    this.axis = original.getAxis();
    this.vehicleId = original.vehicleId;
    size = original.size;
  }

  /**
   * Moves the vehicle depending on the axis.
   */
  public void move(Integer amount) {
    if (axis == Axis.Horizontal) {
      headLocation.add(Axis.Horizontal, amount);
    } else if (axis == Axis.Vertical) {
      headLocation.add(Axis.Vertical, amount);
    } else {
      System.err.println("Vehicle " + vehicleId + " does not have axis Set");
      //TODO: Create an custom error?
    }
  }

  /**
   * Gets the location of where the head node is.
   */
  public Location getHeadLocation() {
    return headLocation;
  }

  /**
   * Gets arraylist of the whole body.
   */
  public ArrayList<Location> getWholeBodyLocation() {
    ArrayList<Location> location = new ArrayList<>();
    location.add(headLocation);
    for (int i = 1; i < size; i++) {
      Location bodyLocationToAdd = new Location(headLocation.toArray());
      bodyLocationToAdd.add(axis, i);
      location.add(bodyLocationToAdd);
    }
    return location;
  }

  /**
   * Gets the vehicleID.
   */
  public String getVehicleId() {
    return vehicleId;
  }

  /**
   * checks if the vehicle is at a location.
   *
   * @param theLocation Location to check if the vehicle is on
   * @return true if is on location else it's false if it's not on location
   */
  public Boolean isOnLocation(Location theLocation) {
    ArrayList<Location> allLocation = this.getWholeBodyLocation();
    for (Location locationToCheck : allLocation) {
      if (locationToCheck.equals(theLocation)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Gets the path from where vehicle is to the location.
   *
   * @param amount needed to be moved to get to the location.
   * @return ArrayList of the locations need to be visited to get to the destination.
   */
  public ArrayList<Location> getPathToLocation(Integer amount) {
    if (amount == 0) {
      return new ArrayList<>();
    }
    ArrayList<Location> path = new ArrayList<>();
    for (Integer i = 1; i <= amount; i++) {
      Location newPathLocation = new Location(headLocation.toArray());
      newPathLocation.add(axis, i);
      path.add(newPathLocation);
    }
    return path;
  }

  /**
   * Sets the head location.
   */
  public void setHeadLocation(Location headLocation) {
    this.headLocation = headLocation;
  }

  /**
   * Gets the object's axis.
   */
  public Axis getAxis() {
    return axis;
  }

  /**
   * Sets the axis of the vehicle.
   */
  public void setAxis(Axis axis) {
    this.axis = axis;
  }

  /**
   * Gets the X axis of head location.
   */
  public Integer getHorizontal() {
    return headLocation.getAxisX();
  }

  /**
   * Gets the Y axis of head location.
   */
  public Integer getVertical() {
    return headLocation.getAxisY();
  }

  /**
   * Gets the vehicle size.
   */
  public Integer getSize() {
    return size;
  }

  /**
   * Calculates the distance to location with the size of body.

   * @return Location of the head location after it's moved.
   */
  public Location getMovedMaxPosition(Integer amount) {
    if (axis == Axis.Vertical) {
      if (amount > 0) {
        return new Location(headLocation.getAxisX(), headLocation.getAxisY() + amount + size - 1);
      } else {
        return new Location(headLocation.getAxisX(), headLocation.getAxisY() + amount + size);
      }
    } else if (axis == Axis.Horizontal) {
      if (amount > 0) {
        return new Location(headLocation.getAxisX() + amount + size - 1, headLocation.getAxisY());
      } else {
        return new Location(headLocation.getAxisX() + amount, headLocation.getAxisY());
      }
    } else {
      System.err.println("No Axis set");
      //TODO: Create an custom error?
      return null;
    }
  }

  /**
   * Checks if o is equal to this object.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null) {
      return false;
    }

    Vehicle vehicle = (Vehicle) o;
    return vehicleId.equals(vehicle.vehicleId);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(vehicleId);
    result = 31 * result;
    return result;
  }

  /**
   * Returns the vehicle ID.
   */
  public String toString() {
    return vehicleId;
  }
}