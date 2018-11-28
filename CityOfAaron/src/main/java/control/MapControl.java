/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.*;
import java.util.HashSet;

/**
 *
 * @author dapon
 */
public class MapControl {
    
    public static Map createMap(){
        
        /*String[] gameTips = {"Every person needs 20 bushels of wheat per year in order to survive.", 
                             "Pay your tithes and offerings for a higher wheat yeild per acre.", 
                             "Attend the temple regularly.", 
                             "Buy land when land prices are low.", 
                             "Pay tithing and your will suffer fewer losses of crops to rats.", 
                             "Feed your people well and they will work hard for you.", 
                             "One person can mantain 10 acres of land.", 
                             "You can plant 2 acres with 1 bushel of wheat."};
        
        Location temple = new Location("Temple","You will find peace when you visit the temple.","T",gameTips);
        Location watchtower = new Location("Watchtower","You can see far and wide from this location.","W",gameTips);
        Location undevelopedLand = new Location("Undeveloped Land","You can plant more crops on this land.","U",gameTips);
        Location wheatField = new Location("Wheat Field","This will provide your food for the year","F",gameTips);
        Location river = new Location("River","The river provides water and recreation for the City of Aaron.","R",gameTips);
        Location granary = new Location("Granary","Your animals, tools and provisions are stored here. The authors of this game can be viewed here as well.","G",gameTips);
        Location rulerCourt = new Location("Ruler's Court","This is where you live and work.","C",gameTips);
        Location village = new Location("Village","This is where people gather to buy and sell goods.","V",gameTips);*/
        
        Location[] locations = createLocationList();
        /*
            Temple 0
            Watchtower 1
            Undeveloped Land 2
            Wheat Field 3
            River 4
            Granary 5
            Ruler's Court 6
            Village 7
        */
        Location[][] mapLocations = {{locations[1],     locations[3],   locations[4],   locations[3],     locations[1]}, 
                                     {locations[2],     locations[0],   locations[5],   locations[4],     locations[2]},
                                     {locations[3],     locations[6],   locations[7],   locations[7],     locations[4]},
                                     {locations[2],     locations[7],   locations[7],   locations[3],     locations[4]},
                                     {locations[1],     locations[2],   locations[3],   locations[3],     locations[1]}};
        
        Point currentLocation = new Point(2,1);
        Map gameMap = new Map(mapLocations, currentLocation);
        
        return gameMap;
    }
            
    //TODO create a functioning test of the method, check if it really works
    public static Location setCurrentLocation(Game game, Point newLocation){
        if (game==null || newLocation == null){
            return null;
        } else if (newLocation.getRow() > game.getMap().getLocations().length || newLocation.getColumn() > game.getMap().getLocations()[0].length){
            System.out.println("Error -1");
            return null;
        }
        
        // call the current map associated to the current game
        Map map = game.getMap();
        // set the new coordinates where the player is moving
        map.setCurrentLocation(newLocation);
       
        return game.getMap().getLocations()[newLocation.getRow()][newLocation.getColumn()];
    }
    
    
    public static Location[] createLocationList(){
        String[] gameTips = {"Every person needs 20 bushels of wheat per year in order to survive.", 
                             "Pay your tithes and offerings for a higher wheat yeild per acre.", 
                             "Attend the temple regularly.", 
                             "Buy land when land prices are low.", 
                             "Pay tithing and your will suffer fewer losses of crops to rats.", 
                             "Feed your people well and they will work hard for you.", 
                             "One person can mantain 10 acres of land.", 
                             "You can plant 2 acres with 1 bushel of wheat."};
        
        Location[] locationsList = {
            new Location("Temple","You will find peace when you visit the temple.","T",gameTips),//0
            new Location("Watchtower","You can see far and wide from this location.","W",gameTips),//1
            new Location("Undeveloped Land","You can plant more crops on this land.","U",gameTips),//2
            new Location("Wheat Field","This will provide your food for the year","F",gameTips),//3
            new Location("River","The river provides water and recreation for the City of Aaron.","R",gameTips),//4
            new Location("Granary","Your animals, tools and provisions are stored here. The authors of this game can be viewed here as well.","G",gameTips),//5
            new Location("Ruler's Court","This is where you live and work.","C",gameTips),//6
            new Location("Village","This is where people gather to buy and sell goods.","V",gameTips)//7
        };
        
        return locationsList;
    }
    
    
    public static HashSet<Location> getLocationsList(Map map){
        HashSet<Location> locations = new HashSet<>();
        for (Location[] locationArray : map.getLocations()){
            for (Location location : locationArray){
                locations.add(location);
            } 
        }
        return locations;
    }
}