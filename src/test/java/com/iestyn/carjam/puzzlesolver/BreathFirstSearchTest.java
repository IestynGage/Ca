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
    Bus bus1 = new Bus(new Integer[]{3, 0}, Axis.Vertical, "B1");
    Bus bus2 = new Bus(new Integer[]{1  , 5}, Axis.Horizontal, "B2");
    puzzle.addVehicle(car1);
    puzzle.addVehicle(car2);
    puzzle.addVehicle(bus1);
    puzzle.addVehicle(bus2);

    puzzle.addTargetVehicle(target);

    System.out.println(puzzle);
    BreathFirstSearch ai = new BreathFirstSearch(puzzle);
    var solution = ai.getSolution();
    System.out.println(solution);
  }

  @Test
  public void solveDifficultLevelTest() {
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

    System.out.println(puzzle.toString());
    BreathFirstSearch ai = new BreathFirstSearch(puzzle);
    System.out.println(ai.getSolution());
  }

  @Test
  public void bfs51Moves() {
    ListPuzzle puzzle = new ListPuzzle();
    Car car1 = new Car(new Integer[]{1, 0}, Axis.Horizontal, "C1");
    Car car2 = new Car(new Integer[]{4, 0}, Axis.Vertical, "C2");
    Car car3 = new Car(new Integer[]{1, 1}, Axis.Vertical, "C3");
    Car car4 = new Car(new Integer[]{2, 1}, Axis.Vertical, "C4");
    Car car5 = new Car(new Integer[]{3, 3}, Axis.Vertical, "C5");
    Car car6 = new Car(new Integer[]{2, 4}, Axis.Vertical, "C6");
    Car car7 = new Car(new Integer[]{0, 5}, Axis.Horizontal, "C7");
    Car car8 = new Car(new Integer[]{4, 4}, Axis.Horizontal, "C8");
    Car car9 = new Car(new Integer[]{3, 5}, Axis.Horizontal, "C9");
    puzzle.addVehicle(car1);
    puzzle.addVehicle(car2);
    puzzle.addVehicle(car3);
    puzzle.addVehicle(car4);
    puzzle.addVehicle(car5);
    puzzle.addVehicle(car6);
    puzzle.addVehicle(car7);
    puzzle.addVehicle(car8);
    puzzle.addVehicle(car9);

    Bus bus1 = new Bus(new Integer[]{0, 0}, Axis.Vertical, "B1");
    Bus bus2 = new Bus(new Integer[]{0 , 3}, Axis.Horizontal, "B2");
    Bus bus3 = new Bus(new Integer[]{5  , 1}, Axis.Vertical, "B3");
    puzzle.addVehicle(bus1);
    puzzle.addVehicle(bus2);
    puzzle.addVehicle(bus3);

    Car target = new Car(new Integer[]{3, 2}, Axis.Horizontal, "TT");
    puzzle.addTargetVehicle(target);

    System.out.println(puzzle.toString());
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