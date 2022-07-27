package com.iestyn.carjam.puzzle;

import com.iestyn.carjam.puzzle.elements.Axis;
import com.iestyn.carjam.puzzle.elements.Bus;
import com.iestyn.carjam.puzzle.elements.Car;
import com.iestyn.carjam.puzzle.elements.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListPuzzleTest {

  @Test
  public void checkVehicleMoveTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    var validMove = puzzle.checkVehicleMove(target, 1);

    assertTrue(validMove);
  }

  @Test void getAllMovesForSingleVehicleTargetVehicle() {
    ListPuzzle puzzle = new ListPuzzle();

    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    puzzle.addTargetVehicle(target);
    System.out.println(puzzle);
    var moves = puzzle.getSingleVehiclePossibleMoves(target);
    assertEquals(4, moves.size());
    assertArrayEquals(
        new Location[]{
            new Location(0, 2),
            new Location(2, 2),
            new Location(3, 2),
            new Location(4, 2)
        },
        moves.toArray()
    );
  }

  @Test void getAllMovesForSingleVehicleBusVertical() {
    ListPuzzle puzzle = new ListPuzzle();

    Bus target = new Bus(new Integer[]{3, 0}, Axis.Vertical, "TT");
    puzzle.addTargetVehicle(target);
    System.out.println(puzzle);
    var moves = puzzle.getSingleVehiclePossibleMoves(target);
    assertEquals(3, moves.size());
    assertArrayEquals(
        new Location[]{
            new Location(3, 1),
            new Location(3, 2),
            new Location(3, 3)
        },
        moves.toArray()
    );
  }

  @Test void getAllMovesForVerticalBusBlocked() {
    ListPuzzle puzzle = new ListPuzzle();
    Car car = new Car(new Integer[]{4, 3}, Axis.Horizontal, "C2");
    puzzle.addVehicle(car);

    Bus bus = new Bus(new Integer[]{3  , 3}, Axis.Vertical, "B3");
    puzzle.addVehicle(bus);

    Car target = new Car(new Integer[]{3, 2}, Axis.Horizontal, "TT");
    puzzle.addTargetVehicle(target);

    System.out.println(puzzle);
    var moves = puzzle.getAllMovesForSingleVehicle(car);
    assertEquals(0, moves.size());
  }

  @Test void getAllMovesForSingleVehicleBus() {
    ListPuzzle puzzle = new ListPuzzle();

    Bus target = new Bus(new Integer[]{1, 2}, Axis.Horizontal, "BB");
    puzzle.addTargetVehicle(target);
    System.out.println(puzzle);
    var moves = puzzle.getSingleVehiclePossibleMoves(target);
    assertEquals(3, moves.size());
    assertArrayEquals(
        new Location[]{
            new Location(0, 2),
            new Location(2, 2),
            new Location(3, 2)
        },
        moves.toArray()
    );
  }

  @Test
  public void checkInvalidVehicleMoveBlockedTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    Car blockerVehicle = new Car(new Integer[]{3, 1}, Axis.Vertical, "C1");
    puzzle.addVehicle(target);
    puzzle.addVehicle(blockerVehicle);
    System.out.println(puzzle);
    var actualValue = puzzle.checkVehicleMove(target, 1);

    assertFalse(actualValue);
  }

  @Test
  public void checkInvalidVehicleMoveBusBlockedTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Bus target = new Bus(new Integer[]{0, 2}, Axis.Horizontal, "TT");
    Car blockerVehicle = new Car(new Integer[]{3, 1}, Axis.Vertical, "C1");
    puzzle.addVehicle(target);
    puzzle.addVehicle(blockerVehicle);
    System.out.println(puzzle);
    var actualValue = puzzle.checkVehicleMove(target, 1);

    assertFalse(actualValue);
  }

  @Test void checkInvalidVerticalBusBlocked() {
    ListPuzzle puzzle = new ListPuzzle();
    Car car = new Car(new Integer[]{4, 3}, Axis.Horizontal, "C2");
    Bus bus = new Bus(new Integer[]{3  , 3}, Axis.Vertical, "B3");
    puzzle.addVehicle(car);
    puzzle.addVehicle(bus);

    System.out.println(puzzle);
    var isPossible = puzzle.checkVehicleMove(car, -1);;
    assertFalse(isPossible);
  }

  @Test
  public void test() {
    ListPuzzle puzzle = new ListPuzzle();
    Car car1 = new Car(new Integer[]{1, 1}, Axis.Vertical, "C1");
    Car car2 = new Car(new Integer[]{2, 1}, Axis.Horizontal, "C2");
    Car car3 = new Car(new Integer[]{4, 0}, Axis.Horizontal, "C3");
    Car car4 = new Car(new Integer[]{3, 3}, Axis.Vertical, "C4");
    Car car5 = new Car(new Integer[]{2, 4}, Axis.Vertical, "C5");
    Car car6 = new Car(new Integer[]{4, 4}, Axis.Horizontal, "C6");
    Car car7 = new Car(new Integer[]{0, 5}, Axis.Horizontal, "C7");
    puzzle.addVehicle(car1);
    puzzle.addVehicle(car2);
    puzzle.addVehicle(car3);
    puzzle.addVehicle(car4);
    puzzle.addVehicle(car5);
    puzzle.addVehicle(car6);
    puzzle.addVehicle(car7);

    Bus bus1 = new Bus(new Integer[]{0, 0}, Axis.Vertical, "B1");
    Bus bus2 = new Bus(new Integer[]{1 , 0}, Axis.Horizontal, "B2");
    Bus bus3 = new Bus(new Integer[]{0  , 3}, Axis.Horizontal, "B3");
    Bus bus4 = new Bus(new Integer[]{5  , 1}, Axis.Vertical, "B4");
    puzzle.addVehicle(bus1);
    puzzle.addVehicle(bus2);
    puzzle.addVehicle(bus3);
    puzzle.addVehicle(bus4);

    Car target = new Car(new Integer[]{2, 2}, Axis.Horizontal, "TT");
    puzzle.addTargetVehicle(target);
    System.out.println(puzzle);
    var a = puzzle.getAllMovesForSingleVehicle(car2);
    assertEquals(1, a.size());
  }
  @Test
  public void checkVehicleMoveReverseTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    Car blockerVehicle = new Car(new Integer[]{3, 1}, Axis.Vertical, "C1");
    puzzle.addVehicle(target);
    puzzle.addVehicle(blockerVehicle);
    var actualValue = puzzle.checkVehicleMove(target, -1);

    assertTrue(actualValue);
  }

  @Test
  public void getSingleVehiclePossibleMovesTest() {
   ListPuzzle puzzle = new ListPuzzle();
   Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
   puzzle.addVehicle(target);
   var moves = puzzle.getSingleVehiclePossibleMoves(target);
   assertEquals(4, moves.size());
  }

  @Test
  public void getAllMovesForSingleVehicleTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    puzzle.addVehicle(target);
    System.out.println(puzzle);
    var moves = puzzle.getAllMovesForSingleVehicle(target);
    assertEquals(4, moves.size());
  }

  @Test
  public void getAllMovesForSingleVehicleBlockedVehicleTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    Car blockerVehicle = new Car(new Integer[]{3, 1}, Axis.Vertical, "C1");
    puzzle.addTargetVehicle(target);
    puzzle.addVehicle(blockerVehicle);
    System.out.println(puzzle.toString());
    var moves = puzzle.getAllMovesForSingleVehicle(target);
    assertEquals(1, moves.size());
  }
}