
package view;
import app.CityOfAaron;
import control.GameControl;
import java.util.Scanner;


/**
 *
 * @author cristinairwin
 */
public class LoadGameView extends ViewBase {
    
/**
     * The message that will be displayed by this view.
     */
   
    /**
     * Constructor
     */
    public LoadGameView(){
    }
    
    @Override
    protected String getMessage() {    
        return "Load a Saved Game\n"
                + "-----------------\n";
                
    }
    
    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("Enter the name of your saved file.",true);
        
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
        
        if ( inputs[0] == null || inputs[0].equals("") ) {
            System.out.println("Error. Returning to the Main menu...");
            return false; 
        } 
        //false breaks out of loop and returns to who called it, which is the Main Menu
        // If true, moves to next statement
        
        
        
        String filename = inputs[0];
        CityOfAaron.setCurrentGame(GameControl.loadSavedgame(filename));
        System.out.println("\nWelcome to your saved game " + CityOfAaron.getCurrentGame().getPlayer().getName() + ". Everything is ready to continue your reign.\n");
        
        GameMenuView view = new GameMenuView();
        view.displayView();
        
        //loadSavedgame();
        
        // to interrupt the loop of displayView method
        return false;
    }
    
   
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
   // private void loadSavedgame(){
       // System.out.println("**** loadSavedgame() called. Implementation coming soon.");
    //}
}

