package com.iestyn.carjam.puzzle;

import com.iestyn.carjam.puzzle.elements.Vehicle;
import java.util.ArrayList;

/**
 * Interface for puzzle so that any puzzle representation can be solved using any solver.
 */
public interface PuzzleInterface {

  static PuzzleInterface createEmtpy() {
    return new ListPuzzle();
  }

  void addVehicle(Vehicle newVehicle);

  void replaceAllVehicles(ArrayList<Vehicle> vehicles);

  Boolean moveVehicle(Vehicle car, Integer amount);

  ArrayList<? extends PuzzleInterface> getAllMovesForAllVehicles();

  static Boolean validPuzzle(PuzzleInterface puzzle) {
    var vehicles = puzzle.getVehicles();

    return vehicles
        .stream()
        .anyMatch((v1 ->
            vehicles.stream()
                .anyMatch(v2 -> v1.getVehicleId().equals(v2.getVehicleId()) || v1.collision(v2))
        ));
  }

  String getMoveHistory();

  Boolean isPuzzleComplete();

  ArrayList<Vehicle>  getVehicles();

}
