/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.Arrays;


/**
 *
 * @author cristinairwin
 */
public class Map implements Serializable {
    // attributes
    private Location[][] locations;
    private Point currentLocation;
    
    // constructor
    public Map(){
    }

    // getter and setter
    public Location[][] getLocations() {
        return locations;
}
    public Point getCurrentLocation(){
        return currentLocation;
}
    public void setCurrentLocation(Point point) {
        this.currentLocation = point;
    }
    
    @Override
    public String toString() {
        return "Map{"
                + " locations =" + Arrays.toString(locations)
                + " current location =" + currentLocation
                + '}';
                
    }
}