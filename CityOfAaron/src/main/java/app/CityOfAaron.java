/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

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
        
        System.out.println(player1);

    }

}