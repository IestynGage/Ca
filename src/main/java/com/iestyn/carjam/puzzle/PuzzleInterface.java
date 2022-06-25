package com.iestyn.carjam.puzzle;

import com.iestyn.carjam.puzzle.elements.Vehicle;
import java.util.ArrayList;

/**
 * Interface for puzzle so that any puzzle representation can be solved using any solver.
 */
public interface PuzzleInterface {

  void addVehicle(Vehicle newVehicle);

  void replaceAllVehicles(ArrayList<Vehicle> vehicles);

  Boolean moveVehicle(Vehicle car, Integer amount);

  ArrayList<? extends PuzzleInterface> getAllMovesForAllVehicles();

  Boolean checkBoardLegal();

  String getMoveHistory();

  Boolean isPuzzleComplete();

}
