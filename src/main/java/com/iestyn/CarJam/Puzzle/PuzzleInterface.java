package com.iestyn.CarJam.Puzzle;

import com.iestyn.CarJam.Puzzle.Elements.Vehicle;

import java.util.ArrayList;

public interface PuzzleInterface {

    void addVehicle(Vehicle newVehicle);

    void replaceAllVehicles(ArrayList<Vehicle> vehicles);

    Boolean moveVehicle(Vehicle car, Integer amount);

    ArrayList<? extends PuzzleInterface> getAllMovesForAllVehicles();

    Boolean checkBoardLegal();

    String getMoveHistory();

    Boolean isPuzzleComplete();

}
