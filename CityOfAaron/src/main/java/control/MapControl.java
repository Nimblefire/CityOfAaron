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
        Location temple = new Location();
        Location watchtower = new Location();
        Location undevelopedLand = new Location();
        Location wheatField = new Location();
        Location river = new Location();
        Location granary = new Location();
        Location rulerCourt = new Location();
        Location village = new Location();
        
        temple.setName("Temple");
        watchtower.setName("Watchtower");
        undevelopedLand.setName("Undeveloped Land");
        wheatField.setName("Wheat Field");
        river.setName("River");
        granary.setName("Granary");
        rulerCourt.setName("Ruler's Court");
        village.setName("Village");
        
        temple.setDescription("Coming");
        watchtower.setDescription("Coming");
        undevelopedLand.setDescription("Coming");
        wheatField.setDescription("Coming");
        river.setDescription("Coming");
        granary.setDescription("Coming");
        rulerCourt.setDescription("Coming");
        village.setDescription("Coming");
        
        String[] gameTips = {"Coming"};
        
        temple.setGameTips(gameTips);
        watchtower.setGameTips(gameTips);
        undevelopedLand.setGameTips(gameTips);
        wheatField.setGameTips(gameTips);
        river.setGameTips(gameTips);
        granary.setGameTips(gameTips);
        rulerCourt.setGameTips(gameTips);
        village.setGameTips(gameTips);
        
        temple.setMapSymbol("T");
        watchtower.setMapSymbol("W");
        undevelopedLand.setMapSymbol("U");
        wheatField.setMapSymbol("F");
        river.setMapSymbol("R");
        granary.setMapSymbol("G");
        rulerCourt.setMapSymbol("C");
        village.setMapSymbol("V"); 
        
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
