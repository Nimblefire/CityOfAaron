/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import app.CityOfAaron;
import control.MapControl;
import java.util.Scanner;
import model.*;
import control.*;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class NewGameView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public NewGameView(){
        
        message = "Starting a new game...\n\n";
                
    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);

            // let's ask what the user wants to do and collect his choice
            String[] inputs = getInputs();

            // calling doAction method passing the user input collected by getInputs
            keepGoing = doAction(inputs);
        }
    }

    /**
     * Get the set of inputs from the user.
     * @return 
     */
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        // included in the getUserInput method (line 82)
        inputs[0] = getUserInput("Please enter your name, or press 'Enter' to return to the main menu:", true);
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }

    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return 
     */
    // keep the following method untouched 
    protected String getUserInput(String prompt, boolean allowEmpty){
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;
        
        while(inputReceived == false){
            
            System.out.println(prompt);
            input = keyboard.nextLine();
            
            // Make sure we avoid a null-pointer error.
            if (input == null){
                input = "";
            }
            
            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();
            
            if (input.equals("") == false || allowEmpty == true){
                inputReceived = true;
            }
        }
        
        // keyboard.close();
        return input;
        
    }
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have 
     * to type it ourselves.
     * @param prompt
     * @return 
     */
    // keep the following method untouched
    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
    }
      
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        
        if ( inputs[0] == null || inputs[0].equals("") ) {
            System.out.println("No player name entered. Returning to the Main menu...");
            return false; 
        }

        String playerName = inputs[0];
        CityOfAaron.setCurrentGame(GameControl.createNewGame(playerName));
        System.out.println("Welcome to the game " + CityOfAaron.getCurrentGame().getPlayer().getName() + ".\nEverything is ready to start your reign.");
        
        GameMenuView view = new GameMenuView();
        view.displayView();
        
        // to interrupt the loop of displayView method
        return false;
    }
     
    // Define your action handlers here. These are the methods that your doAction() method will call based on the user's input
    
    private void createAndStartGame(String playerName){
                
        Player player = new Player();
        player.setName(playerName);

        Game game = new Game();
        
        game.setPlayer(player);
        
        game.setWheatInStorage(2000);
        game.setCurrentPopulation(100);
        
        CityOfAaron.setCurrentGame(game);
        MapControl.createMap();
        
        System.out.println("Welcome to the game " + CityOfAaron.getCurrentGame().getPlayer().getName() + ".\nEverything is ready to start your reign.");
        
        GameMenuView view = new GameMenuView();
        view.displayView();
        
        
    }

}
