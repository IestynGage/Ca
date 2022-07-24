package com.iestyn.carjam.puzzlegenerator;

import com.iestyn.carjam.puzzle.PuzzleInterface;
import com.iestyn.carjam.puzzle.elements.Axis;
import com.iestyn.carjam.puzzle.elements.Car;
import com.iestyn.carjam.puzzle.elements.Location;

import java.util.Random;

public class RandomPlacement {

  static public PuzzleInterface generatePuzzle() {
    var puzzle = PuzzleInterface.createEmtpy();
    Random random = new Random();
    var carsAmount = random.nextInt(4) + 5;

    while(carsAmount > 0) {
      var location = new Location(random.nextInt(5), random.nextInt(5));
      puzzle.addVehicle(new Car(location, Axis.Horizontal, "CC"+carsAmount));
      carsAmount--;
    }

    return puzzle;
  }

}
