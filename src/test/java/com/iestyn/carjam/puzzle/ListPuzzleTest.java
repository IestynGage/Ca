package com.iestyn.carjam.puzzle;

import com.iestyn.carjam.puzzle.elements.Axis;
import com.iestyn.carjam.puzzle.elements.Car;
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