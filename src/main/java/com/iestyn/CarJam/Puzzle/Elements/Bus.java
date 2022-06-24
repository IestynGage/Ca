package com.iestyn.CarJam.Puzzle.Elements;

public class Bus extends Vehicle {
    public Bus(Integer[] headLocation,Axis axis, String vehicleID){
        super(vehicleID);
        this.size = 3;
        this.headLocation = new Location(headLocation);
        this.axis = axis;

    }

    public Bus(Location headLocation,Axis axis, String vehicleID){
        super(vehicleID);
        this.size = 3;
        this.headLocation = headLocation;
        this.axis = axis;
    }
}