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
        
        Game gameOne = new Game();
        
        Player playerOne = new Player();
        
        gameOne.setPlayer(playerOne);
        
        playerOne.setName("Alma");
        
        Player player1 = gameOne.getPlayer();
        
        //System.out.println(player1);
        
        gameOne.setMap(new Map());
        gameOne.setStorehouse(new Storehouse());
        gameOne.setCurrentPopulation(110);
        gameOne.setAcresOwned(2001);
        gameOne.setWheatInStorage(20000);
        
        System.out.println(gameOne.toString());
        
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