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
        
        // gameOne.setPlayer(new Player()); // new Player object
        
        // gameOne.setStorehouse(new Storehouse()); // new Storehouse object
        
        gameOne.setMap(new Map()); // new Map object
        gameOne.setCurrentPopulation(110);
        gameOne.setAcresOwned(2001);
        gameOne.setWheatInStorage(20000);
        
        System.out.println(gameOne.toString());
        
    
        // Test Player class
        Player playerOne = new Player();  // new player
        playerOne.setName("Alma"); // setting a name for the player
        //String playerOneName = playerOne.getName();
        //Player player1 = gameOne.getPlayer();
        System.out.println(playerOne.toString());
        
        // Test Author class
        Author Cristina = new Author();
        Cristina.setName("Andrea Rochira");
        Cristina.setTitle("Mr");
        System.out.println(Cristina.toString());
        
        Author Andrea = new Author();
        Andrea.setName("Cristina Irwin");
        Andrea.setTitle("Mr");
        System.out.println(Andrea.toString());
        
        Author Stefano = new Author();
        Stefano.setName("Stefano DaPonte Becher");
        Stefano.setTitle("Mr");
        System.out.println(Stefano.toString());
        
        // Test Storehouse
        // Storehouse theStorehouse = new Storehouse();
        // theStorehouse.setAuthors(ArrayList<Author>[Stefano, Andrea, Cristina});
        // ArrayList<Author> authors = theStorehouse.getAuthors();
        
        
        // Test InventoryItem, Animal, and Provision class + enum classes
        InventoryItem hammer = new InventoryItem();
        Animal horse = new Animal();
        Provision apple = new Provision();
            
        hammer.setName("Hammer");
        hammer.setCondition(Condition.GOOD);
        hammer.setItemType(ItemType.TOOL);
        hammer.setQuantity(1);
        
        horse.setName("Arabian Horse");
        horse.setAge(7);
        horse.setCondition(Condition.GOOD);
        horse.setItemType(ItemType.ANIMAL);
        horse.setQuantity(1);
        
        apple.setName("Apple");
        apple.setCondition(Condition.GOOD);
        apple.setPerishable(true);
        apple.setItemType(ItemType.PROVISIONS);
        apple.setQuantity(10);
        
        System.out.println(hammer.toString()+ "\n" + horse.toString() + "\n" + apple.toString());
        
        // Alternative test for enum classes
        /*
        for(ItemType it: ItemType.values()){
            System.out.println(it); 
        }
        
        for(Condition c: Condition.values()){
           System.out.println(c); 
        }
        */
        
        
    }

}
