/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class HelpMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public HelpMenuView(){
        
        message = "Help Menu\n"
                + "---------\n"
                + "G - What are the goals of the game?\n"
                + "W - Where is the city of Aaron?\n"
                + "M - How do I view the map?\n"
                + "L - How do I move to another location?\n"
                + "S - How do I display a list of animals, provisions and tools in the city storehouse?\n"
                + "B - Back to Main menu\n";
                
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
        inputs[0] = getUserInput("Select an action from the menu above:");
        
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

        switch ( inputs[0].trim().toUpperCase() ){
            case "G":
                whatAreTheGoals();
                break;
            case "W":
                whereIsTheCity();
                break;
            case "M":
                viewTheMap();
                break;
            case "L":
                moveToLocation();
                break;
            case "S":
                checkStorehouse();
                break;
            case "B":
                System.out.println("Exiting Help Menu...");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            default: 
                System.out.println("Invalid selection, try again.");
                
        }
        return true;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void whatAreTheGoals(){
        System.out.println("Rules of the game"
                         + "-----------------"
                         + "1. "
                         + "2. "
                         + "3. "
                         + "... " );
    }

    private void whereIsTheCity(){
        System.out.println("*** whereIsTheCity() called. Implementation coming soon... ");
    }

    private void viewTheMap(){
        System.out.println("*** viewTheMap() called. Implementation coming soon... ");
    }

    private void moveToLocation(){
        System.out.println("*** moveToLocation() called. Implementation coming soon... ");
    }

    private void checkStorehouse(){
        System.out.println("*** checkStorehouse() called. Implementation coming soon... ");
    }
    
}
