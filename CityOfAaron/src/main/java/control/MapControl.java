/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import app.CityOfAaron;
import model.*;

/**
 *
 * @author dapon
 */
public class MapControl {
    
    public static Map createMap(){
        
        String[] gameTips = {"Coming"};
        
        Location temple = new Location("Temple","Coming","T",gameTips);
        Location watchtower = new Location("Watchtower","Coming","W",gameTips);
        Location undevelopedLand = new Location("Undeveloped Land","Coming","U",gameTips);
        Location wheatField = new Location("Wheat Field","Coming","F",gameTips);
        Location river = new Location("River","Coming","R",gameTips);
        Location granary = new Location("Granary","Coming","G",gameTips);
        Location rulerCourt = new Location("Ruler's Court","Coming","C",gameTips);
        Location village = new Location("Village","Coming","V",gameTips);

        Map gameMap = new Map();
    
        Location[][] mapLocations = {{watchtower, wheatField, river, wheatField, watchtower}, 
                                    {undevelopedLand, temple, granary, river, undevelopedLand},
                                    {wheatField, rulerCourt, village, village, river},
                                    {undevelopedLand, village, village, wheatField, wheatField},
                                    {watchtower, undevelopedLand, wheatField, wheatField, watchtower}};
        
        
        gameMap.setLocations(mapLocations);
        
        return gameMap;
    }
    
    //TODO create a functioning test of the method, check if it really works
    public static Location setCurrentLocation(Game game, Point newLocation){
        if (game==null || newLocation == null){
            return null;
        } else if (newLocation.getRow() > game.getMap().getLocations()[0].length || newLocation.getColumn() > game.getMap().getLocations()[1].length){
            System.out.println("Error -1");
            return null;
        }
        
        game.getMap().setCurrentLocation(newLocation);
        return game.getMap().getLocations()[newLocation.getRow()][newLocation.getColumn()];
    }
}
