package com.iestyn.carjam.puzzle.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

  @Test
  public void getPathToLocationNoMoveTest() {
    Car target = new Car(new Integer[]{4, 4}, Axis.Horizontal, "TT");
    var path = target.getPathToLocation(0);
    assertEquals(path.size(), 0);
  }

  @Test
  public void getPathToLocationReverseTest() {
    Car target = new Car(new Integer[]{4, 4}, Axis.Horizontal, "TT");
    var path = target.getPathToLocation(-3);
    assertEquals(path.size(), 3);
  }

  @Test
  public void getPathToLocationForwardTest() {
    Car target = new Car(new Integer[]{4, 4}, Axis.Horizontal, "TT");
    var path = target.getPathToLocation(3);
    assertEquals(path.size(), 4);
    assertEquals(new Location(5, 4), path.get(0));
    assertEquals(new Location(6, 4), path.get(1));
    assertEquals(new Location(7, 4), path.get(2));
  }

  @Test
  public void getPathToLocationBusForwardTest() {
    Bus target = new Bus(new Integer[]{4, 4}, Axis.Horizontal, "TT");
    var path = target.getPathToLocation(1);
    assertEquals(3, path.size());
    assertEquals(new Location(5, 4), path.get(0));
  }

  @Test
  public void getWholeBodyLocationBus() {
    Bus target = new Bus(new Integer[]{4, 4}, Axis.Horizontal, "TT");
    var bodyLocation = target.getWholeBodyLocation();
    assertEquals(3, bodyLocation.size());
  }
}