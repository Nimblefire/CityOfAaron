/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import app.CityOfAaron;
import control.MapControl;
import model.*;
import exceptions.*;

/**
 *
 * @author dapon
 */
public class MapView extends ViewBase{
    
    /**
     * Constructor
     */
    public MapView(){
    }
    
    @Override
    public String getMessage(){
        return "City Map\n"
                + "------------------------------\n"
                + "This is the map of your city\n";
    }

    /**
     * In this case the view does not collect any user input,
     * it only displays the welcome message and then the MAIN menu.
     * @return 
     */
    
   @Override
    public String[] getInputs() {
        
        return null;
    }

    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        try{
        printMap(CityOfAaron.getCurrentGame().getMap());
        System.out.println("\nYou are in the " + CityOfAaron.getCurrentGame().getMap().getLocations()   //Get the array
                [CityOfAaron.getCurrentGame().getMap().getCurrentLocation().getRow()]                   //Get the row
                [CityOfAaron.getCurrentGame().getMap().getCurrentLocation().getColumn()]                //Get the column
                .getName());                                                                            //Get the name
        pause(5000);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
        
        // return false so that whoever call us doesn't call us again 
        return false;
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void printMap(Map map) throws MapControlException{
	// creating and initializing two dimensional array with shortcut syntax
	for (int i = 0; i < map.getLocations().length; i++) {
            for (int j = 0; j < map.getLocations()[i].length; j++) {
		System.out.print("[" + map.getLocations()[i][j].getMapSymbol() + "]" + " ");
            }
            System.out.println("");
	}
        System.out.println("\nLegend: ");
        
        for (Location location : MapControl.getLocationsList(map)) {
            System.out.println(location.getMapSymbol() + " - " + location.getName());
        }
    }
}