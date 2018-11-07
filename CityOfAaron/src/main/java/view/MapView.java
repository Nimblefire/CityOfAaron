/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.*;
import control.*;

/**
 *
 * @author dapon
 */
public class MapView {
    /**
     * The message that will be displayed by this view.
     */
    Location temple = new Location();
    Location watchtower = new Location();
    Location undevelopedLand = new Location();
    Location wheatField = new Location();
    Location river = new Location();
    Location granary = new Location();
    Location rulerCourt = new Location();
    Location village = new Location();
    
    Map gameMap = new Map();
    
    Location[][] mapLocations = {{watchtower, wheatField, river, wheatField, watchtower}, 
                                 {undevelopedLand, temple, granary, river, undevelopedLand},
                                 {wheatField, rulerCourt, village, village, river},
                                 {undevelopedLand, village, village, wheatField, wheatField},
                                 {watchtower, undevelopedLand, wheatField, wheatField, watchtower}};
 
    protected String message;
    
    /**
     * Constructor
     */
    public MapView(){
        message = "This is the map of your city\n"
                + "Legend:\n"
                + /*temple.getMapSymbol()*/"T" + "- Temple\n"
                + /*watchtower.getMapSymbol()*/"W" + "- Watchtower\n"
                + /*undevelopedLand.getMapSymbol()*/"U" + "- Undeveloped Land\n"
                + /*wheatField.getMapSymbol()*/"F" + "- Wheat Field\n"
                + /*river.getMapSymbol()*/"R" + "- River\n"
                + /*granary.getMapSymbol()*/"G" + "- Granary\n"
                + /*rulerCourt.getMapSymbol()*/"C" + "- Ruler's Court\n"
                + /*village.getMapSymbol()*/"V" + "- Village";
    }
    

     /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    /**
     * In this case the view does not collect any user input,
     * it only displays the welcome message and then the MAIN menu.
     * @return 
     */
    public String[] getInputs() {
        
        return null;
    }

    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        
        createMap(gameMap);
        printMap(gameMap);
        
        // return false so that whoever call us doesn't call us again 
        return false;
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    public void createMap(Map map){
        temple.setMapSymbol("T");
        watchtower.setMapSymbol("W");
        undevelopedLand.setMapSymbol("U");
        wheatField.setMapSymbol("F");
        river.setMapSymbol("R");
        granary.setMapSymbol("G");
        rulerCourt.setMapSymbol("C");
        village.setMapSymbol("V");
        
        map.setLocations(mapLocations);
    }
    
    public void printMap(Map map) {
	// creating and initializing two dimensional array with shortcut syntax
	for (int i = 0; i < map.getLocations().length; i++) {
		for (int j = 0; j < map.getLocations()[i].length; j++) {
			System.out.print("[" + map.getLocations()[i][j].getMapSymbol() + "]" + " ");
		}
		System.out.println("");
	}
    }

    
}