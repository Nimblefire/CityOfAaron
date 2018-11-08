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
public class GameMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public GameMenuView(){
        
        message = 
                //call annual report before Game Menu
                //"Current annual Report is " + currentAnnualReport() "\n"
                 "Game Menu\n"
                + "---------\n"
                + "M - View the Map\n"
                + "L - Move to a new location\n"
                + "C - Manage the Crops\n"
                + "Y - Live the Year\n"
                + "R - Reports Menu\n"
                + "S - Save Game\n"
                + "B - Back to Main menu\n";
                
    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses an action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
          System.out.println("Annual Report called. Implementation coming soon");
            
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
        
        
        //if more that 50% pf people starve call
        //gameOver();
        
        // calls final rating at the end of 10 years
        //finalRating();
        

        switch ( inputs[0].trim().toUpperCase() ){
            case "M":
                viewMap();
                break;
            case "L":
                newLocation();
                break;
            case "C":
                manageCrops();
                break;
            case "Y":
                liveTheYear();
                break;
            case "R":
                reportsMenu();
                break;
            case "S":
                saveGame();
                break;
            case "B":
                System.out.println("Exiting Game Menu...");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            default: 
                System.out.println("Invalid selection, try again.");
        }
        
        
        return true;
    }
    
   
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void viewMap(){
        MapView mapView = new MapView();
        mapView.displayView();
    }

    private void newLocation(){
        // System.out.println("*** newLocation() called. Implementation coming soon... ");
         NewLocationView view = new NewLocationView();
         view.displayView();
    }

    private void manageCrops(){
        ManageCropsView view = new ManageCropsView();
        view.displayView();
    }
    
    private void liveTheYear(){
        System.out.println("*** liveTheYear() called. Implementation coming soon... ");
    }

    private void reportsMenu(){
        ReportsMenuView view = new ReportsMenuView();
        view.displayView();    
    }
     
    private void saveGame(){
        System.out.println("*** saveGame() called. Implementation coming soon... ");
    }
     
     private void currentAnnualReport() {
         System.out.println("*** currentAnnualReport() called. Implementation coming soon... ");
     }
     
    private void finalRating() {
         System.out.println("*** finalRating() called. Implementation coming soon... ");
    }
    
    private void gameOver() {
         System.out.println("*** gameOver() called. Implementation coming soon... ");
    }
}
