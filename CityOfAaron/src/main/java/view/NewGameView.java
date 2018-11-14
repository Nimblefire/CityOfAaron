
package view;
import app.CityOfAaron;
import control.*;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class NewGameView extends ViewBase {
   
    
    /**
     * Constructor
     */
    public NewGameView(){
        
    }
   @Override 
   protected String getMessage() {
      return "Starting a new game...\n\n";
   }

    /**
     * Get the set of inputs from the user.
     * @return 
     */
   @Override
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
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        
        if ( inputs[0] == null || inputs[0].equals("") ) {
            System.out.println("No player name entered. Returning to the Main menu...");
            return false; 
        }

        String playerName = inputs[0];
        CityOfAaron.setCurrentGame(GameControl.createNewGame(playerName));
        System.out.println("\nWelcome to the game " + CityOfAaron.getCurrentGame().getPlayer().getName() + ". Everything is ready to start your reign.\n");
        
        GameMenuView view = new GameMenuView();
        view.displayView();
        
        
        
        // to interrupt the loop of displayView method
        return false;
    }
     
    // Define your action handlers here. These are the methods that your doAction() method will call based on the user's input
    
}
