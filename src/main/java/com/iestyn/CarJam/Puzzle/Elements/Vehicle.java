package com.iestyn.CarJam.Puzzle.Elements;

import java.util.ArrayList;
import java.util.Objects;

public class Vehicle extends Tile {
    Location headLocation;
    Axis axis;
    String vehicleID;
    Integer size;

    /**
     * Creates a new vehicle object with vehicleID. All other variables are null.
     *
     * @param vehicleID
     */
    public Vehicle(String vehicleID){
        this.vehicleID = vehicleID;
    }

    /**
     * Creates a copy of another vehicle
     *
     * @param original the vehicle to copy
     */
    public Vehicle(Vehicle original){
        this.headLocation = new Location(original.getHeadLocation());
        this.axis = original.getAxis();
        this.vehicleID = original.vehicleID;
        size = original.size;
    }

    /**
     * Moves the vehicle depending on the axis.
     *
     * @param amount the amount the vehicle location moved by
     */
    public void move(Integer amount){
        if(axis==Axis.Horizontal){
            headLocation.add(Axis.Horizontal,amount);
        } else if(axis==Axis.Vertical){
            headLocation.add(Axis.Vertical,amount);
        } else {
            System.err.println("Vehicle "+ vehicleID + " does not have axis Set");
            //TODO: Create an custom error?
        }
    }

    /**
     * Gets the location of where the head node is.
     *
     * @return Location object of where the head node is.
     */
    public Location getHeadLocation() {
        return headLocation;
    }

    /**
     * Gets arraylist of the whole body.
     *
     * @return ArrayList<Location> of the whole body.
     */
    public ArrayList<Location> getWholeBodyLocation(){
        ArrayList<Location> location = new ArrayList<>();
        location.add(headLocation);
        for(int i=1;i<size;i++){
            Location bodyLocationToAdd = new Location(headLocation.toArray());
            bodyLocationToAdd.add(axis,i);
            location.add(bodyLocationToAdd);
        }
        return location;
    }

    /**
     * Gets the vehicleID
     *
     * @return vehicleId
     */
    public String getVehicleID(){
        return vehicleID;
    }

    /**
     * checks if the vehicle is at a location
     *
     * @param theLocation Location to check if the vehicle is on
     * @return true if is on location else it's false if it's not on location
     */
    public Boolean isOnLocation(Location theLocation){
        ArrayList<Location> allLocation = this.getWholeBodyLocation();
        for (Location locationToCheck : allLocation) {
            if(locationToCheck.equals(theLocation)){
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the path from where vehcile is to the location
     *
     * @param amount needed to be moved to get to the location
     * @return ArrayList<Location> of the locations need to be visited to get to the destination
     */
    public ArrayList<Location> getPathToLocation(Integer amount){
        if(amount==0){
            return new ArrayList<>();
        }
        ArrayList<Location> path = new ArrayList<>();
        for(Integer i=1;i<=amount;i++){
            Location newPathLocation = new Location(headLocation.toArray());
            newPathLocation.add(axis,i);
            path.add(newPathLocation);
        }
        return path;
    }

    /**
     * Sets the head location
     *
     * @param headLocation
     */
    public void setHeadLocation(Location headLocation) {
        this.headLocation = headLocation;
    }

    /**
     * Gets the object's axis
     *
     * @return axis the vehicle on
     */
    public Axis getAxis() {
        return axis;
    }

    /**
     * Sets the axis of the vehicle
     *
     * @param axis
     */
    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    /**
     * Gets the X axis of head location
     * @return the x axis of the location
     */
    public Integer getHorizontal(){
        return headLocation.getXAxis();
    }

    /**
     * Gets y axis of head location
     * @return
     */
    public Integer getVertical(){
        return headLocation.getYAxis();
    }

    /**
     * Gets the vehicle size
     *
     * @return integer of the vehicle size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Calculates the distance to location with the size of body
     *
     * @param amount
     * @return Location of the head location after it's moved.
     */
    public Location getMovedMaxPosition(Integer amount){
        if(axis == Axis.Vertical){
            if(amount>0){
                return new Location(headLocation.getXAxis(), headLocation.getYAxis()+ amount + size-1);
            } else {
                return new Location(headLocation.getXAxis(), headLocation.getYAxis()+ amount + size);
            }
        } else if (axis == Axis.Horizontal){
            if(amount>0){
                return new Location(headLocation.getXAxis()+ amount + size-1, headLocation.getYAxis());
            } else {
                return new Location(headLocation.getXAxis()+ amount, headLocation.getYAxis());
            }
        } else {
            System.err.println("No Axis set");
            //TODO: Create an custom error?
            return null;
        }
    }

    /**
     * Checks if o is equal to this object
     *
     * @param o object to be checked
     * @return true if both objects are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleID.equals(vehicle.vehicleID);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(vehicleID);
        result = 31 * result;
        return result;
    }

    /**
     * Returns the vehicle ID
     *
     * @return vehicleID
     */
    public String toString(){
        return vehicleID;
    }
}