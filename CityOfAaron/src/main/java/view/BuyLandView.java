package view;
import java.util.Scanner;
import app.CityOfAaron;
import control.*;

/**
 *
 * @author cristinairwin
 */
public class BuyLandView extends ViewBase {
    //some place to hold the getRandom land price for the whole class
    int wheatPrice = GameControl.getRandomValue(17, 27);
/**
     
    /**
     * Constructor
     */
    public BuyLandView(){
    }
    
    @Override    
    protected String getMessage() {    
        
        return "\nBuy Land\n"
                + "--------------------\n"
                + "Land is selling for " + wheatPrice + " an acre.\n";
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
        
        inputs[0] = getUserInput("How many acres of new land do you want to buy?");
        
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
        
        //if acresToBuy is less than -1 ask player to enter in number 0 or larger. 
        if (acresToBuy < 0) {
            System.out.println("Please enter a number 0 or larger.");
            return true;
        }
        //if total wheat price (wheatPrice * acresToBuy) is greater than the wheat in storage, ask user to try again.
        else if (totalWheatCost > CityOfAaron.getCurrentGame().getWheatInStorage()){
            System.out.println("You don't have enough wheat, please try again");
            return true;
        }
        //if acresToBuy is more than people to tend it (1 person can maintain 10 acres), ask user to try again.
        else if ((CityOfAaron.getCurrentGame().getCurrentPopulation() * 10) < (acresToBuy + CityOfAaron.getCurrentGame().getAcresOwned())) {
            System.out.println(" You don't have enought people to work that amount of land, please enter in another number. ");
            return true;//Have to ask input again
        } 
        else {
           reportAcresOwned(acresToBuy);
           reportWheatInStorage(wheatPrice, totalWheatCost);
        }
     
        return false;
    
    }
    
     // Define your action handlers here. These are the methods that your doAction()
     // method will call based on the user's input.
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
            
   
            System.out.println("You now have " + CityOfAaron.getCurrentGame().getWheatInStorage()  + " bushels of wheat in storage.\n");
        }
    
    //private void reportLand() {
        
        //Game game = new Game();
        //game.setWheatInStorage(1000);
        //game.setCurrentPopulation(100);
        //}
        
    
}

