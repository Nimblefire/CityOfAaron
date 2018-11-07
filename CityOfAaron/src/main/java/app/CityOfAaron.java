/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

/**
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
*/
import model.*;
import view.*;
import control.*;
import java.util.HashSet;
import java.util.Set;

public class CityOfAaron {
        
    // keep a copy of the current Game object in the main class
    public static Game currentGame = null;
    
    public static Game getCurrentGame(){
        return currentGame;
    } 
    
    public static void setCurrentGame(Game game){
        currentGame = game;
    }
    
    public static void main(String[] args){
        /*StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayView();*/
        MapView mapView = new MapView();
        mapView.displayView();
        
    }   
        
        /**
        
        
        * The starting point for our application. 
        * 
        * @param args Any parameters passed on the command line will be 
        * contained in this array.**/
}
