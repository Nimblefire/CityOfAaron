
package view;
import app.CityOfAaron;
import control.GameControl;
import exceptions.GameControlException;
import java.io.IOException;

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
        
        String fileName = inputs[0];
        
        try {
            GameControl.getGame(fileName);
            console.println("\nWelcome to your saved game " + CityOfAaron.getCurrentGame().getPlayer().getName() + ". Everything is ready to continue your reign.\n");
        } catch (IOException | GameControlException e) {
            ErrorView.display(this.getClass().getName(),e.getMessage());
            return false;
        }
        
        GameMenuView view = new GameMenuView();
        view.displayView();
        
        return false;
    }
}

