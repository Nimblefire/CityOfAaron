/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import app.*;

/**
 *
 * @author Andrea
 */
public class EndGameView extends ViewBase {
    
    // Constructor 
    public EndGameView(){
    }
    
    @Override
    protected String getMessage(){
        return "\nSorry " + CityOfAaron.getCurrentGame().getPlayer().getName()
                + ", it seems you didn't meet the expectations of your mandate.\n"
                + "What do you want to do next?\n"
                + "R - Restart the game\n"
                + "L - Restart from a checkpoint\n"
                + "N - Exit the game and leave the country\n";
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get from the user.
        String[] inputs = new String[1];
        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        inputs[0] = getUserInput("Select an action to proceed:");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
         
        return inputs;
    }
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){

        switch ( inputs[0].trim().toUpperCase() ){
            case "R":
                restartGame();
                break;
            case "L":
                loadGame();
                break;
            case "N":
                System.out.println("\nExiting Game...\n");
                // code to terminate the program
                break;
            default:
                System.out.println("\nInvalid selection, try again.\n");
                return true;
        }
                      
       return false; 
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void restartGame(){
    }

    private void loadGame(){
        LoadGameView loadGame = new LoadGameView();
        loadGame.displayView();
    }  
    
}
