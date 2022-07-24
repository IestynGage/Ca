package com.iestyn.carjam.puzzlesolver;

import com.iestyn.carjam.puzzle.ListPuzzle;
import com.iestyn.carjam.puzzle.elements.Axis;
import com.iestyn.carjam.puzzle.elements.Bus;
import com.iestyn.carjam.puzzle.elements.Car;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link BreathFirstSearch}.
 */
public class BreathFirstSearchTest {

  @Test
  public void noObstacleTest() {
    ListPuzzle puzzle = new ListPuzzle();

    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    puzzle.addTargetVehicle(target);

    System.out.println(puzzle);
    BreathFirstSearch ai = new BreathFirstSearch(puzzle);
    System.out.println(ai.getSolution());
  }
  @Test
  public void simplePuzzleTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Car car1 = new Car(new Integer[]{2, 3}, Axis.Horizontal, "C1");
    Car car2 = new Car(new Integer[]{2, 4}, Axis.Horizontal, "C2");
    Car target = new Car(new Integer[]{1, 2}, Axis.Horizontal, "TT");
    Bus bus1 = new Bus(new Integer[]{3, 0}, Axis.Vertical, "C3");
    Bus bus2 = new Bus(new Integer[]{1  , 5}, Axis.Horizontal, "C3");
    puzzle.addVehicle(car1);
    puzzle.addVehicle(car2);
    puzzle.addVehicle(bus1);
    puzzle.addVehicle(bus2);

    puzzle.addTargetVehicle(target);

    System.out.println(puzzle);
    BreathFirstSearch ai = new BreathFirstSearch(puzzle);
    System.out.println(ai.getSolution());
  }

  @Test
  public void solveDifficultPuzzle93MovesTest() {
    ListPuzzle puzzle = new ListPuzzle();
    Car car1 = new Car(new Integer[]{3, 0}, Axis.Horizontal, "C1");
    Car car2 = new Car(new Integer[]{4, 3}, Axis.Horizontal, "C2");
    Car car3 = new Car(new Integer[]{4, 5}, Axis.Horizontal, "C3");
    Car car4 = new Car(new Integer[]{1, 4}, Axis.Horizontal, "C4");
    Car car5 = new Car(new Integer[]{0, 4}, Axis.Vertical, "C5");
    puzzle.addVehicle(car1);
    puzzle.addVehicle(car2);
    puzzle.addVehicle(car3);
    puzzle.addVehicle(car4);
    puzzle.addVehicle(car5);

    Bus bus1 = new Bus(new Integer[]{2, 0}, Axis.Vertical, "B1");
    Bus bus2 = new Bus(new Integer[]{5  , 0}, Axis.Vertical, "B2");
    Bus bus3 = new Bus(new Integer[]{3  , 3}, Axis.Vertical, "B3");
    puzzle.addVehicle(bus1);
    puzzle.addVehicle(bus2);
    puzzle.addVehicle(bus3);

    Car target = new Car(new Integer[]{3, 2}, Axis.Horizontal, "TT");
    puzzle.addTargetVehicle(target);

    System.out.println(puzzle.toString());
    BreathFirstSearch ai = new BreathFirstSearch(puzzle);
    System.out.println(ai.getSolution());
  }
}