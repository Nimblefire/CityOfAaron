/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

import java.util.HashSet;
import java.util.Set;
import model.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        
    
        // Test Player class
        Player playerOne = new Player();  // new player
        playerOne.setName("Alma"); // setting a name for the player
        //String playerOneName = playerOne.getName();
        //Player player1 = gameOne.getPlayer();
        System.out.println(playerOne.toString());
        
        // Test Author class
        Author Cristina = new Author();
        Cristina.setName("Cristina Irwin");
        Cristina.setTitle("Mrs");
        System.out.println(Cristina.toString());
        
        Author Andrea = new Author();
        Andrea.setName("Andrea Rochira");
        Andrea.setTitle("Mr");
        System.out.println(Andrea.toString());
        
        Author Stefano = new Author();
        Stefano.setName("Stefano DaPonte Becher");
        Stefano.setTitle("Mr");
        System.out.println(Stefano.toString());
        
        // Test Storehouse
        ArrayList<Author> authors = new ArrayList();
        authors.add(Stefano);
        authors.add(Andrea);
        authors.add(Cristina);
        Storehouse theStorehouse = new Storehouse();
        theStorehouse.setAuthors(authors);
        
        System.out.println(theStorehouse.toString());
        
        // Test enum classes
        for(ItemType it: ItemType.values()){
            System.out.println(it); 
        }
        
        for(Condition c: Condition.values()){
           System.out.println(c); 
        }
        
        // Test InventoryItem, Animal, and Provision class + enum classes
        InventoryItem hammer = new InventoryItem();
        Animal horse = new Animal();
        Provision apple = new Provision();
            
        hammer.setName("Hammer");
        hammer.setCondition(Condition.GOOD);
        hammer.setItemType(ItemType.TOOL);
        hammer.setQuantity(1);
        
        // Map Class
        Map map = new Map();
        
        
        Location[][]locations = new Location[5][5];
        //locations.setName();
        //String locations = locations.getName();
        
        Point templePosition = new Point();
        templePosition.setRow(0);
        templePosition.setColumn(0);
        
        //String[]myTips = new String[] {"Pray", "Feed your people", "Pay tithing"};
        //Location tipOne = new Location();
        //tipOne.setGameTips(myTips);
        //System.out.println(tipOne.toString());
        
        
        //String[] strArray = new String[2];
        //myTips[0] = "Pray";
        //myTips[1] = "Eat";
        
        
        
        
        
       // Location tipOne = new Location();
       // tipOne.setGameTips("Pray");
        // System.out.println(tipOne.toString());
        
        // Location tipTwo = new Location();
        // tipTwo.setGameTips("Pay tithing");
        // System.out.println(tipTwo.toString());
        
        // Location tipThree = new Location();
        // tipThree.setGameTips("Feed your people.");
        // System.out.println(tipThree.toString());
        
        
        // ArrayList<Location> tips = new ArrayList();
        // tips.add(tipOne);
        // tips.add(tipTwo);
        // tips.add(tipThree);
        
        //Location GameTips = new Location();
        //GameTips.setLocation(tips);
        
        // System.out.println(theStorehouse.toString());
        
        
        Location tips = new Location();
        tips.setGameTips(new String[] {
            "Pray", "Pay tithing", "Feed People"
        });
        
       System.out.println(tips.toString());
       //Location {tips = [Pray, Pay tithing, Feed People]}
        
        
        
        
        
        
        Location temple = new Location();
        temple.setName("temple");
        temple.setDescription("This is where the game begins");
        temple.setMapSymbol("*");
        temple.setGameTips(new String[] {
            "Pray", "Pay tithing", "Feed People"
        });
        //temple.setGameTips("Visit here often.");
        
        locations[templePosition.getRow()][templePosition.getColumn()] = temple;

        System.out.println(locations[0][0].toString());
        //Point Class
        Point thisLocation = new Point();
       
        thisLocation.setRow(1);
        thisLocation.setColumn(3);
                
        System.out.println(hammer.toString()+ "\n" + horse.toString() + "\n" + apple.toString());
        
       

    }

}
