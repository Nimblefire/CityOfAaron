/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.*;

/**
 *
 * @author dapon
 */
public class MapControl {
    
    public static Map createMap(){
        
        String[] gameTips = {"Every person needs 20 bushels of wheat per year in order to survive.", 
                             "Pay your tithes and offerings for a higher wheat yeild per acre.", 
                             "Attend the temple regularly.", 
                             "Buy land when land prices are low.", 
                             "Pay tithing and your will suffer fewer losses of crops to rats.", 
                             "Feed your people well and they will work hard for you.", 
                             "One person can mantain 10 acres of land.", 
                             "You can plant 2 acres with 1 bushel of wheat."};
        
        // String randomGameTip = gameTips[GameControl.getRandomValue(0, 7)];
        
        Location temple = new Location("Temple","You will find peace when you visit the temple.","T",gameTips);
        Location watchtower = new Location("Watchtower","You can see far and wide from this location.","W",gameTips);
        Location undevelopedLand = new Location("Undeveloped Land","You can plant more crops on this land.","U",gameTips);
        Location wheatField = new Location("Wheat Field","This will provide your food for the year","F",gameTips);
        Location river = new Location("River","The river provides water and recreation for the City of Aaron.","R",gameTips);
        Location granary = new Location("Granary","Your animals, tools and provisions are stored here. The authors of this game can be viewed here as well.","G",gameTips);
        Location rulerCourt = new Location("Ruler's Court","This is where you live and work.","C",gameTips);
        Location village = new Location("Village","This is where people gather to buy and sell goods.","V",gameTips);

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
