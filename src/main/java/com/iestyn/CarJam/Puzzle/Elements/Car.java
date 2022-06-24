package com.iestyn.CarJam.Puzzle.Elements;

public class Car extends Vehicle {

    public Car(Integer[] headLocation,Axis axis, String vehicleID){
        super(vehicleID);
        this.size = 2;
        this.headLocation = new Location(headLocation);
        this.axis = axis;

    }

    public Car(Location headLocation,Axis axis, String vehicleID){
        super(vehicleID);
        this.size = 2;
        this.headLocation = headLocation;
        this.axis = axis;
    }

}