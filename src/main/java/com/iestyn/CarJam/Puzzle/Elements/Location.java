package com.iestyn.CarJam.Puzzle.Elements;

import java.util.Objects;

public class Location {
    private Integer xAxis;
    private Integer yAxis;

    /**
     * Constructer sets each axis manually.
     *
     * @param xAxis
     * @param yAxis
     */
    public Location(Integer xAxis, Integer yAxis){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    /**
     * Sets the location with integer array.
     * Array position 0 is xAxis
     * Array position 1 is yAxis
     *
     * @param location
     */
    public Location(Integer[] location){
        if(location.length==2){
            xAxis = location[0];
            yAxis = location[1];
        }
    }

    /**
     * Clones the Location object. Creates a deep copy of the object.
     *
     * @param originalLocation
     */
    public Location(Location originalLocation){
        this.xAxis = Integer.valueOf(originalLocation.getXAxis());
        this.yAxis = Integer.valueOf(originalLocation.getYAxis());
    }

    /**
     * Creates an integer array with data of location
     * Array position 0 is xAxis.
     * Array Position 1 is yAxis
     *
     * @return Integer array of location
     */
    public Integer[] toArray(){
        return new Integer[]{xAxis, yAxis};
    }

    /**
     * Adds an integer amount depending on the axis set in parameter
     *
     * @param axis the axis to add the amount to.
     * @param amount the amount added onto the yAxis or xAcis
     */
    public void add(Axis axis, Integer amount){
        if(axis == Axis.Horizontal){
            xAxis +=amount;
        } else{
            yAxis +=amount;
        }
    }

    /**
     * Gets the x Axis
     *
     * @return Integer value of xAxis
     */
    public int getXAxis(){
        return xAxis;
    }

    /**
     * Gets the y Axis variable
     *
     * @return Integer value of yAxis
     */
    public int getYAxis(){
        return yAxis;
    }

    /**
     * Returns integer value of difference between one object and another on the bases of one axis.
     *
     * @param other another Location to compare aganst
     *
     * @return integer value of difference between single axis
     */
    public Integer minus(Location other){
        if(this.getYAxis()-other.getYAxis() != 0){
            return this.getYAxis()-other.getYAxis();
        } else if ((this.getXAxis() - other.getXAxis()) != 0){
            return  this.getXAxis() - other.getXAxis();
        } else {
            return 0;
        }
    }

    /**
     * Returns object in string format.
     *
     * @return String of location's axis
     */
    public String toString(){
        return "Location:" + xAxis + "," + yAxis;
    }

    /**
     * checks if two locations are equal.
     *
     * @param o
     * @return True if both location are equal else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(xAxis, location.xAxis) &&
                Objects.equals(yAxis, location.yAxis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis);
    }
}