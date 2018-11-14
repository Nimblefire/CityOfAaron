package view;

/**
 *
 * @author Andrea
 */

import java.util.Scanner;

public class ManageCropsView {
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public ManageCropsView(){
        
        message = "\nManage Crops Menu\n"
                + "-----------------\n"
                + "B - Buy Land\n"
                + "S - Sell Land\n"
                + "F - Feed the People\n"
                + "P - Plant Crops\n"
                + "T - Pay Tithes and Offerings\n"
                + "Q - Back to Game Menu\n";            
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

        if (inputs[0].trim().toUpperCase().equals("B")) {
            buyLand();
            }
        else if (inputs[0].trim().toUpperCase().equals("S")) {
            sellLand();
            }
        else if (inputs[0].trim().toUpperCase().equals("F")) {
            feedThePeople();
            }
        else if (inputs[0].trim().toUpperCase().equals("P")) {
            plantCrops();
            }
        else if (inputs[0].trim().toUpperCase().equals("T")) {
            payTithesOfferings();
            } 
        else if (inputs[0].trim().toUpperCase().equals("Q")) {
            System.out.println("Exiting Manage Crops Menu...\n");
            return false;
            }
        else 
            {System.out.println("Invalid selection, try again.\n");}
        
       return true;     
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    // To fulfill the requirements of the rubric (do-while logic + two String methods)
    private void buyLand(){
        BuyLandView buyLand = new BuyLandView();
        buyLand.displayView();
        //System.out.println("Implementation coming soon...");
    }

    private void sellLand(){
        System.out.println("Implementation coming soon...");
    }

    private void feedThePeople(){
        FeedPeopleView feedPeople = new FeedPeopleView();
        feedPeople.displayView();
    }

    private void plantCrops(){
        System.out.println("Implementation coming soon...");
    }

    private void payTithesOfferings(){
        PayTithingView payTithing = new PayTithingView();
        payTithing.displayView();
        //System.out.println("Implementation coming soon...");
    }
    
}
