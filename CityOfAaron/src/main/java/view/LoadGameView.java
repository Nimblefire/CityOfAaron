
package view;
import app.CityOfAaron;
import control.GameControl;
import java.util.Scanner;
import model.*;
import control.*;

/**
 *
 * @author cristinairwin
 */
public class LoadGameView {
    
/**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public LoadGameView(){
        
        message = "Load a Saved Game\n";
                
    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }
    
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("Enter the name of your saved file.");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return 
     */
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
        
        return input;
    }
    
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have 
     * to type it ourselves.
     * @param prompt
     * @return 
     */
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
            System.out.println("Error. Returning to the Main menu...");
            return false; 
        }
        //false breaks out of loop and returns to who called it, which is the Main Menu
        // If true, moves to next statement
        
        
        
        String filename = inputs[0];
        CityOfAaron.setCurrentGame(GameControl.loadGameFromFile(filename));
        System.out.println("\nWelcome to your saved game " + CityOfAaron.getCurrentGame().getPlayer().getName() + ". Everything is ready to continue your reign.\n");
        
        GameMenuView view = new GameMenuView();
        view.displayView();
        
        loadSavedgame();
        
        // to interrupt the loop of displayView method
        return false;
    }
    
   
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void loadSavedgame(){
        System.out.println("**** loadSavedgame() called. Implementation coming soon.");
        
       
    }
}

