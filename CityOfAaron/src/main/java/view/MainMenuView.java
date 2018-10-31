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
public class MainMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public MainMenuView(){
        
        message = "Main Menu\n"
                + "---------\n"
                + "N - Start a New Game\n"
                + "L - Load a Saved Game\n"
                + "H - Help Menu\n"
                + "Q - Quit\n";
                
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
                System.out.println("Hope to see you soon. Good-bye.");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            default: 
                System.out.println("Invalid selection, try again.");
        }
        
        /** IF-ELSE version
        
            if (inputs[0].trim().toUpperCase() == "N") {
            startNewGame();
            }
            else if (inputs[0].trim().toUpperCase() == "L") {
            loadSavedGame();
            }
            else if (inputs[0].trim().toUpperCase() == "H") {  
                helpMenu();
            }
            else if (inputs[0].trim().toUpperCase() == "Q"){
                System.out.println("Hope to see you soon. Good-bye.");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            }
            else {
                System.out.println("Invalid selection, try again.");
        }    
        */
        
        return true;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void startNewGame(){
        NewGameView view = new NewGameView();
        view.displayView();
    }

    private void helpMenu(){
        HelpMenuView view = new HelpMenuView();
        view.displayView();
    }

    private void loadSavedGame(){
        System.out.println("*** loadSavedGame() called. Implementation coming soon... ");
    }

    
}