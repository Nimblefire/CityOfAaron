/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import control.*;
import model.*;
import app.CityOfAaron;

/**
 *
 * @author dapon
 */
public class FeedPeopleView {
    protected String message;
    Game currentGame = CityOfAaron.getCurrentGame();
    public static int bushelsForFood;
    
    /**
     * Constructor
     */
    public FeedPeopleView(){
        
        message = "\nFeed the People\n"
                + "--------------------------\n"
                + "You currently have " + currentGame.getCurrentPopulation() + " people in your city.\n"
                + "You have " + currentGame.getWheatInStorage() + " bushels of grain in store.";
        
        
                
    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses an action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    /**
     * Get the set of inputs from the user.
     * @return 
     */
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get from the user.
        String[] inputs = new String[1];
        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        // included in the getUserInput method (line 92)
        inputs[0] = getUserInput("How many bushels of grain do you want to give to the people?");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
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
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        try {
            bushelsForFood = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException exception) {
            System.out.println("The value must be positive whole number.");
            return true;//keep going
        }
        if (bushelsForFood < 0){
            System.out.println("The value must be positive whole number.");
            return true;
        }
        
        if (bushelsForFood > currentGame.getWheatInStorage()) {
            System.out.println("The value is greater than the wheat you have. Please insert a valid value.");
            return true;
        }
        System.out.println("You have " + (currentGame.getWheatInStorage()-bushelsForFood) + " bushels of wheat left.");
        return false;
    }
}
