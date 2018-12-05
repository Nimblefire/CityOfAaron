/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import app.CityOfAaron;
import control.GameControl;
import model.Game;
import exceptions.GameControlException;
import java.io.IOException;

/**
 *
 * @author Andrea
 */
public class SaveGameView extends ViewBase {
    
    // Constructor 
    public SaveGameView(){
    }
    
    @Override
    protected String getMessage(){
        return "\nHere you can save your progress and create a checkpoint." + 
                "\nYou can specify just a file name or its absolute path.\n";
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
        inputs[0] = getUserInput("Please, enter a file name or a file path: ");
        
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
    public boolean doAction(String[] inputs) {
        
        String filePath = inputs[0];
        Game game = CityOfAaron.getCurrentGame();
        
        try {
            GameControl.saveGame(game,filePath);
        } catch (IOException | GameControlException e) {
            ErrorView.display(this.getClass().getName(),e.getMessage());
            return true;
        }
        
        console.println("Checkpoint successfully saved in " + filePath);
                      
        return false; 
    } 
}
