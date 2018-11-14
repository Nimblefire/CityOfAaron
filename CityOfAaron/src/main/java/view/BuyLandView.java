package view;
import java.util.Scanner;
import app.CityOfAaron;
import model.*;
import control.*;

/**
 *
 * @author cristinairwin
 */
public class BuyLandView {
    //some place to hold the getRandom land price for the whole class
    int wheatPrice = GameControl.getRandomValue(17, 27);
/**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public BuyLandView(){
        
        
        
        message = "\nBuy Land\n"
                + "--------------------\n"
                + "Land is selling for" + wheatPrice + "an acre.\n";
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
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("How many acres of new land do you want to buy?");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
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
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        if (inputs[0] == null || inputs[0].equals("")) {
            System.out.println("Missing amount. Returning to the Manage Crops Menu");
            return false; //if false return to Manage Crops, true keeps going
        }
        
        int acresToBuy;
        try {
            acresToBuy = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException exception) {
            System.out.println("Acres must be a whole number. Try again.");
            return true;//keep going
        }
        
        //int wheatCost = GameControl.getRandomValue(17, 27);
        
     
        int totalWheatCost= wheatPrice * acresToBuy;
        
        //if acresToBuy is greater than -1 ask player to enter in number 0 or larger. 
        if (acresToBuy < 0) {
            System.out.println("Please enter a number 0 or larger.");
            return true;
        }
        //if total wheat price (wheatPrice * acresToBuy) is greater than the wheat in storage, ask user to try again.
        else if (totalWheatCost > CityOfAaron.getCurrentGame().getWheatInStorage()){
            System.out.println("You don't have enough wheat, please try again");
            return true;
        }
        //if acresToBuy is more than people to tend it, ask user to try again.
        else if (( CityOfAaron.getCurrentGame().getCurrentPopulation() * 10) < acresToBuy ) {
            System.out.println(" You don't have enought people to work that amount of land, please enter in another number. ");
            return true;//Have to ask input again
        } 
        else {
           reportAcresOwned(acresToBuy);
           reportWheatInStorage(wheatPrice, totalWheatCost);
       }
        return false;
    
    }
        private void reportAcresOwned(int acresToBuy) {
            //add the number of acres purchased to the acres owned
            //acresToBuy + acresOwned = acresOwned;
            CityOfAaron.getCurrentGame().setAcresOwned(acresToBuy + CityOfAaron.getCurrentGame().getAcresOwned());
            System.out.println("You now have " + CityOfAaron.getCurrentGame().getAcresOwned() + " acres of land.\n");
        }
        
        private void reportWheatInStorage(int wheatPrice, int totalWheatCost) {
            //subtract the wheat used to purchase the land from the wheat in storage
            //CityOfAaron.getCurrentGame().getWheatInStorage() - wheatCost = wheatInStorage;
            
            CityOfAaron.getCurrentGame().setWheatInStorage(CityOfAaron.getCurrentGame().getWheatInStorage() - totalWheatCost);
            
   
            System.out.println("You now have " + CityOfAaron.getCurrentGame().getWheatInStorage()  + " bushels in storage.\n");
        }
    
    //private void reportLand() {
        
        //Game game = new Game();
        //game.setWheatInStorage(1000);
        //game.setCurrentPopulation(100);
        //}
        
    
}

