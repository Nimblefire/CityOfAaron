
package view;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class MainMenuView extends ViewBase {
    
    /**
     * Constructor
     */
    public MainMenuView(){    
    }
    
    @Override
    protected String getMessage(){
        return "Main Menu\n"
                + "---------\n"
                + "N - Start a New Game\n"
                + "L - Load a Saved Game\n"
                + "H - Help Menu\n"
                + "Q - Quit the Game\n";
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
        // included in the getUserInput method (line 92)
        inputs[0] = getUserInput("Select an action from the menu above:");
        
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
            case "N":
                startNewGame();
                break;
            case "L":
                loadSavedGame();
                break;
            case "H":
                helpMenu();
                break;
            case "Q":
                System.out.println("\nHope to see you soon. Good-bye.");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            default: 
                System.out.println("Invalid selection, try again.");
        }
        
        return true;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void startNewGame(){
        NewGameView view = new NewGameView();
        view.displayView();
    }

    private void helpMenu(){
        View helpMenu = new HelpMenuView();
        helpMenu.displayView();
    }

    private void loadSavedGame(){
        LoadGameView view = new LoadGameView();
        view.displayView();
        //System.out.println("*** loadSavedGame() called. Implementation coming soon... ");
    }

    
}
