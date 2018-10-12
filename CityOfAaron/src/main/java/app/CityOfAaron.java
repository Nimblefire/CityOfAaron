/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

import java.util.HashSet;
import java.util.Set;
import model.*;
import java.util.ArrayList;

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {
        
        Game gameOne = new Game();  // new Game object
        gameOne.setPlayer(new Player()); // new Player object
        gameOne.setStorehouse(new Storehouse()); // new Storehouse object
        gameOne.setMap(new Map()); // new Map object
        gameOne.setCurrentPopulation(110);
        gameOne.setAcresOwned(2001);
        gameOne.setWheatInStorage(20000);
        
        System.out.println(gameOne.toString());
        
    
        
        /*
        Player playerOne = new Player();  // new player
        playerOne.setName("Alma"); // setting a name for the player
        String playerOneName = playerOne.getName();
        System.out.println(playerOne.toString());
        
         Player player1 = gameOne.getPlayer(); // retrieving the name of the player
        
        //System.out.println(player1);
        */
        
        // Test enum classes
        for(ItemType it: ItemType.values()){
            System.out.println(it); 
        }
        
        for(Condition c: Condition.values()){
           System.out.println(c); 
        }
        
        
        /*
        
        InventoryItem hammer = new InventoryItem();
        Animal horse = new Animal();
        Provision apple = new Provision();
        
        
        hammer.setName("Hammer");
        hammer.setCondition(Good);
        hammer.setItemType(Tool);
        hammer.setQuantity(1);
        
        horse.setName("Arabian Horse");
        horse.setAge(7);
        horse.setCondition(Good);
        horse.setItemType(Animal);
        horse.setQuantity(1);
        
        apple.setName("Apple");
        apple.setCondition(Good);
        apple.setPerishable(true);
        apple.setItemType(Provisions);
        apple.setQuantity(10);
        */
            
    }

}