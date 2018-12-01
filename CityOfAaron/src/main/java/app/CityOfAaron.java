/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

/** 
 * @author team Irwin - DaPonte - Rochira
 */

import model.*;
import view.*;

public class CityOfAaron {
        
    // keep a copy of the current Game object in the main class
    public static Game currentGame = null;
    
    public static Game getCurrentGame(){
        return currentGame;
    } 
    
    public static void setCurrentGame(Game game){
        currentGame = game;
    }
    
    // call the StartProgramView view
    public static void main(String[] args){
        
        try {
            View startProgramView = new StartProgramView();
            startProgramView.displayView();
        } catch (Throwable te) {
            System.out.println("Exception caught from the main method");
            System.out.println(te.getMessage());
            te.printStackTrace();
        }
    } 
}
