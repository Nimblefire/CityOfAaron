/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

import java.util.HashSet;
import java.util.Set;
import model.*;

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {
        
        //Game Class
        Game gameOne = new Game();
        //Player playerOne = new Player();
       // gameOne.setPlayer(playerOne);
       // playerOne.setName("Alma");
        //Player player1 = gameOne.getPlayer();
        
        //System.out.println(player1);
        
        gameOne.setMap(new Map());
        gameOne.setStorehouse(new Storehouse());
        gameOne.setCurrentPopulation(110);
        gameOne.setAcresOwned(2001);
        gameOne.setWheatInStorage(20000);
        
        System.out.println(gameOne.toString());
        
  //      InventoryItem hammer = new InventoryItem();
  //      Animal horse = new Animal();
  //      Provision apple = new Provision();
        
//        hammer.setName("Hammer");
//        hammer.setCondition(Good);
//        hammer.setItemType(Tool);
//        hammer.setQuantity(1);
//        
//        horse.setName("Arabian Horse");
//        horse.setAge(7);
//        horse.setCondition(Good);
//        horse.setItemType(Animal);
//        horse.setQuantity(1);
//        
//        apple.setName("Apple");
//        apple.setCondition(Good);
//        apple.setPerishable(true);
//        apple.setItemType(Provisions);
//        apple.setQuantity(10);
        
        // Map Class
        Map map = new Map();
        
        
        Location[][]locations = new Location[5][5];
        //locations.setName();
        //String locations = locations.getName();
        
        Point templePosition = new Point();
        templePosition.setRow(0);
        templePosition.setColumn(0);
        
        Location temple = new Location();
        temple.setName("temple");
        temple.setDescription("This is where the game begins");
        temple.setMapSymbol("*");
        temple.setGametips("test");
        
        
        locations[templePosition.getRow()][templePosition.getColumn()] = temple;

        System.out.println(locations[0][0].toString());
        //Point Class
        
        Point thisLocation = new Point();
       
        thisLocation.setRow(1);
        thisLocation.setColumn(3);
        
        
        
        // Map Class
       
        //locations[currentLocation.getRow()][currentLocation.getColumn()].getMapSymbol();
        
        
       
        // Location Class
       // ourTown.setName("Aaron");
       // ourTown.setDescription("This is where the game begins");
       // ourTown.setMapSymbol("*");
        //ourTown.setGametips(gameTips);
        
        
        // Point Class
        
       

    }

}