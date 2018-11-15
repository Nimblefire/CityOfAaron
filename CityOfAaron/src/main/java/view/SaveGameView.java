/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
        return "Do you want to save your progress on your local Disk?\n"
                + "Y - Save your progress\n"
                + "N - back to Report Menu\n";
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
            case "Y":
                saveGame();
                break;
            case "N":
                System.out.println("\nBack to Game Menu...\n");
                break;
            default:
                System.out.println("\nInvalid selection, try again.\n");
                return true;
        }
                      
       return false; 
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.

    private void saveGame(){
        System.out.println("\n'Saving progress on disk' implementation coming soon...\n");
    }
    
}
