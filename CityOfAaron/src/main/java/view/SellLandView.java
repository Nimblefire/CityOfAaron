/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import app.CityOfAaron;

/**
 *
 * @author dapon
 */
public class SellLandView extends ViewBase {
    public static int acresToSell;
    
    public SellLandView() {
    }
    
    @Override
    protected String getMessage(){
        return "\nSell Land\n"
                + "--------------------\n"
                + "Land is selling for " + CityOfAaron.getCurrentGame().getLandPrice() + " bushels an acre.\n"
                + "You own " + CityOfAaron.getCurrentGame().getAcresOwned() + " acres of land.";
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
        
        inputs[0] = getUserInput("How many acres of land do you want to sell?");
        
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
        
        try {
            acresToSell = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException exception) {
            System.out.println("Acres must be a whole number. Try again");
            return true;//keep going
        }
        
        boolean check = inputCheck(acresToSell);
        pause (2500);
        
        return check;
    
    }
    
    private boolean inputCheck(int acresToSell){
        //if acresToBuy is less than -1 ask player to enter in number 0 or larger. 
        if (acresToSell < 0) {
            System.out.println("Please enter a number equal to 0 or larger");
            return true;
        }
        //if total wheat price (wheatPrice * acresToBuy) is greater than the wheat in storage, ask user to try again.
        else if ( acresToSell > CityOfAaron.getCurrentGame().getAcresOwned()){
            System.out.println("You don't have enough acres of land, please try again");
            return true;
        }
        else {
           reportAcresOwned(acresToSell);
           reportWheatInStorage(acresToSell);
           return false;
        }
    }
    
    private void reportAcresOwned(int acresToSell) {
        CityOfAaron.getCurrentGame().setAcresOwned(CityOfAaron.getCurrentGame().getAcresOwned() - acresToSell);
        System.out.println("You now have " + CityOfAaron.getCurrentGame().getAcresOwned() + " acres of land.");
    }
    
    private void reportWheatInStorage(int acresToSell) {
        CityOfAaron.getCurrentGame().setWheatInStorage(CityOfAaron.getCurrentGame().getWheatInStorage() + acresToSell * CityOfAaron.getCurrentGame().getLandPrice());
        System.out.println("You now have " + CityOfAaron.getCurrentGame().getWheatInStorage()  + " bushels of wheat in storage.\n");
    }
}
