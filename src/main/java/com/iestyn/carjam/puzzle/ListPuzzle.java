package com.iestyn.carjam.puzzle;

import com.iestyn.carjam.puzzle.elements.Axis;
import com.iestyn.carjam.puzzle.elements.EmptyTile;
import com.iestyn.carjam.puzzle.elements.Location;
import com.iestyn.carjam.puzzle.elements.Tile;
import com.iestyn.carjam.puzzle.elements.Vehicle;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ListPuzzle implements {@link PuzzleInterface} representing vehicles as a list.
 * <p>
 * TODO Add a restriction so that ExitTile is always at the edge of the map.
 *      Must update constructor comments if this is done.
 * </p>
 */
public class ListPuzzle implements PuzzleInterface {

  private ArrayList<Vehicle> vehicles;
  private final String targetVehicle = "TT";
  private Integer mapSize;
  private Location exitTile;

  private String moveHistory;

  /**
   * Default Constructor for ListKR.
   * Sets the mapSize to 6, with exit tile at 5,2.
   * For the puzzle to be legal puzzle a target car needs to be added.
   */
  public ListPuzzle() {
    mapSize = 6;
    vehicles = new ArrayList<>();
    exitTile = new Location(new Integer[]{5, 2});
    moveHistory = "";
  }

  /**
   * Custom Constructor for ListKR
   * Can set the mapSize as well as the location for the exitTile,
   * The Exit Tile should be added to the corner of the map.
   * No restrictions have been added to force this.

   * For the puzzle to legal puzzle a target car needs to be added

   * @param mapSize the map size
   * @param exitTile the location for where the exit tile should be. In Integer Array format.

   */
  public ListPuzzle(Integer mapSize, Integer[] exitTile) {
    this.mapSize = mapSize;
    vehicles = new ArrayList<>();
    this.exitTile = new Location(exitTile);
    moveHistory = "";
  }

  /**
   * Custom Constructor for ListKR
   * Can set the mapSize as well as the location for the exitTile,
   * The Exit Tile should be added to the corner of the map.
   * No restrictions have been added to force this.

   * For the puzzle to legal puzzle a target car needs to be added

   * @param mapSize the map size
   * @param exitTile the location for where the exit tile should be. In Location object format.
   */
  public ListPuzzle(Integer mapSize, Location exitTile) {
    this.mapSize = mapSize;
    vehicles = new ArrayList<>();
    this.exitTile = exitTile;
    moveHistory = "";
  }

  /**
   * Constructor for ListKR
   * Creates a deep copy of the original ListKR.
   *
   * @param original the ListKR to copy
   */
  public ListPuzzle(ListPuzzle original) {
    if (original.getVehicles() != null) {
      vehicles = new ArrayList<>();

      for (Vehicle vehicle : original.getVehicles()) {
        vehicles.add(new Vehicle(vehicle));
      }
    }

    if (original.mapSize != null) {
      this.mapSize = Integer.valueOf(original.mapSize);
    }

    if (original.exitTile != null) {
      this.exitTile = new Location(original.exitTile);
    }

    moveHistory = String.valueOf(original.getMoveHistory());
  }

  /**
   * Adds a vehicle to the vehicles ArrayList. Checks if arrayList is null before adding.
   *
   * @param newVehicle new vehicle to add to the arrayList
   */
  @Override
  public void addVehicle(Vehicle newVehicle) {
    if (vehicles != null
        || vehicles.stream()
        .anyMatch(v -> v.collision(newVehicle))) {
      vehicles.add(newVehicle);
    } else {
      System.err.println("ListKR addVehicle: vehicles ArrayList is null");
    }
  }

  /**
   * Adds the target car to the puzzle.
   * The TargetCar needs to move to the exit tile for the puzzle to be completed.
   *
   * @param targetVehicle the vehicle added thats needs to move onto the exit tile.
   */
  public void addTargetVehicle(Vehicle targetVehicle) {
    vehicles.add(targetVehicle);
  }

  /**
   * Replaces all vehicles in the class with new input.
   */
  @Override
  public void replaceAllVehicles(ArrayList<Vehicle> newVehicleArrayList) {
    this.vehicles = newVehicleArrayList;
  }


  /**
   * Moves a vehicle by a certain amount.
   *
   * @param vehicle the vehicle needed to be moved.
   * @param amount the amount it needs to be moved by
   * @return True if the move was possible, false if it couldn't
   */
  @Override
  public Boolean moveVehicle(Vehicle vehicle, Integer amount) {
    ArrayList<Location> locationOfEachMove = vehicle.getPathToLocation(amount);
    vehicles.remove(vehicle);
    for (Vehicle vehicleToCheck : vehicles) {
      Location location = vehicle.getMovedMaxPosition(amount);
      if (vehicleToCheck.isOnLocation(location)) {
        vehicles.add(vehicle);
        return false;
      }
      for (Location pathLocation : locationOfEachMove) {
        if (vehicleToCheck.isOnLocation(pathLocation)) {
          vehicles.add(vehicle);
          return false;
        }
      }
    }
    vehicle.move(amount);
    vehicles.add(vehicle);
    moveHistory = moveHistory + " | " + vehicle.getVehicleId() + amount;
    return true;
  }

  /**
   * This checks if possible vehicle move is possible. Checks if there are any vehicles in the way
   */
  public Boolean checkVehicleMove(Vehicle vehicle, Integer amount) {
    var path = vehicle.getPathToLocation(amount);

    return vehicles
        .stream()
        .filter(v -> !v.getVehicleId().equals(vehicle.getVehicleId()))
        .noneMatch(v -> {
          var p = v.getWholeBodyLocation();
          var o = path
              .stream()
              .anyMatch(v::isOnLocation);
          return o;
        });


    //TODO Refactor moveVehicle checks into this function.
    //TODO implement this method for getAllPosibleMoves
  }

  public ArrayList<Vehicle> getVehicles() {
    return vehicles;
  }

  public Vehicle getTargetVehicle() {
    return null;
    //TODO: remove targetCar
  }

  public Location getExitTile() {
    return exitTile;
  }

  /**
   * This returns all possible legal states that this state cna change into.
   *
   * @return ArrayList of all possible States this current state can transform into.
   */
  @Override
  public ArrayList<ListPuzzle> getAllMovesForAllVehicles() {
    ArrayList<ListPuzzle> allMoves = new ArrayList<>();

    for (Vehicle theVehicle : vehicles) {
      allMoves.addAll(this.getAllMovesForSingleVehicle(theVehicle));
    }
    return allMoves;
  }

  /**
   * This gets all legals moves a single vehicle can make.
   * TODO Refactor to do a straight line both ways instead of getting all
   * @param vehicleToMove the vehicle you want all moves to.
   * @return ArrayList of PuzzleKR with each one with unique move the vehicle could make.
   */
  public ArrayList<ListPuzzle> getAllMovesForSingleVehicle(Vehicle vehicleToMove) {
    //possible moves
    ArrayList<Location> possibleMoves = this.getSingleVehiclePossibleMoves(vehicleToMove);
    ArrayList<ListPuzzle> allMoves = new ArrayList<>();

    for (Location possibleMove : possibleMoves) {
      Integer theAmount = possibleMove.minus(vehicleToMove.getHeadLocation());

      if (this.checkVehicleMove(vehicleToMove, theAmount)) {
        ListPuzzle newPuzzle = new ListPuzzle(this);
        Vehicle cleanCopy = newPuzzle.getVehicle(vehicleToMove.toString());
        //If this vehicle isn't used then each vehicle moved would link to each other
        // thus all puzzles produced will have the 'vehicleToMove' object at the same location
        newPuzzle.moveVehicle(cleanCopy, theAmount);

        allMoves.add(newPuzzle);
      }
    }

    //
    return allMoves;
  }

  public ArrayList<Location> getSingleVehiclePossibleMoves(Vehicle theVehicle) {
    ArrayList<Location> possibleMoves = new ArrayList<>();
    Location startLocation = theVehicle.getAxis() == Axis.Horizontal ?
      new Location(0, theVehicle.getHeadLocation().getAxisY()) :
      new Location(theVehicle.getHeadLocation().getAxisX(), 0);

    possibleMoves.add(startLocation);
    //add Possible Moves
    for (int i = 1; i < (mapSize - (theVehicle.getSize() - 1)); i++) {
      Location newLocation = new Location(startLocation);
      newLocation.add(theVehicle.getAxis(), i);
      possibleMoves.add(newLocation);
    }

    possibleMoves.remove(theVehicle.getHeadLocation());

    return  possibleMoves;
  }

  /**
   * TODO Implement.
   */
  @Override
  public String getMoveHistory() {
    return moveHistory;
  }

  /**
   * Checks if the target vehicle is on the exit tile.

   * @return Boolean True if target car is on the exit tile, else False
   */
  @Override
  public Boolean isPuzzleComplete() {
    Vehicle target = this.getVehicle("TT");
    if (target != null) {
      ArrayList<Location> redCarBodyLocation = target.getWholeBodyLocation();
      for (Location bodyLocation : redCarBodyLocation) {
        if (bodyLocation.equals(exitTile)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Gets the puzzle map in a 2 dimensonal format.
   *
   * @return The board in a 2 Dimensonal format.
   */
  private Tile[][] getPuzzleMap() {
    Tile[][] puzzleMap = new Tile[mapSize][mapSize];
    for (int y = 0; y < puzzleMap.length; y++) {
      Arrays.fill(puzzleMap[y], new EmptyTile());
    }

    for (Vehicle vehicleToAdd : vehicles) {
      ArrayList<Location> locationOfVehicle = vehicleToAdd.getWholeBodyLocation();
      for (Location locationToAdd : locationOfVehicle) {
        puzzleMap[locationToAdd.getAxisX()][locationToAdd.getAxisY()] = vehicleToAdd;

      }
    }
    return puzzleMap;
  }

  /**
   * Gets the vehicle from the arrayList with the index.
   */
  public Vehicle getVehicle(Integer index) {
    return vehicles.get(index);
  }

  /**
   * Get the vehicle with the specified ID.
   */
  public Vehicle getVehicle(String id) {
    Vehicle tempVehicle = new Vehicle(id);

    for (Vehicle theVehicle : vehicles) {
      if (tempVehicle.equals(theVehicle)) {
        return theVehicle;
      }
    }

    return null;
  }

  /**
   * Returns the puzzleMap as 2D Map in string format.
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    Tile[][] puzzleMap = this.getPuzzleMap();

    for (int y = 0; y < puzzleMap.length; y++) {
      for (int x = 0; x < puzzleMap.length; x++) {
        stringBuilder.append(puzzleMap[x][y].toString() + "||");
      }
      stringBuilder.append("\n");

      for (int x = 0; x < puzzleMap.length; x++) {
        stringBuilder.append("==||");

      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
}