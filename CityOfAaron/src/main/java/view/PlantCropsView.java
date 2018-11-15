/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class PlantCropsView extends ViewBase {
    
    /**
     * Constructor
     */
    public PlantCropsView(){
    }
    
    @Override
    protected String getMessage(){
        return null;
    }
    
    
    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get from the user.
        String[] inputs = new String[1];
        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        inputs[0] = getUserInput("\nHow many acres of land do you want to plant?");
        
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
         
        // declare a variable to hold later the user input
        int acresToPlant;
        
        // test if the user input is an integer value
        try {
            acresToPlant = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException exception) {
            System.out.println("\nThe amount of land must be a whole number. Try again.");
            return true;
        }
        
        // declare a variable to hold the number of bushels required to plant the crops
        int bushelsRequired;
        
        // test if the user input is 0 or a positive value
        if ( acresToPlant < 0 ) {
            System.out.println("\nPlease enter an amount equal or greater than 0");
            return true;
        }
        // also test if the user is requiring more land than available
        else if ( acresToPlant > CityOfAaron.getCurrentGame().getAcresOwned() ){
            System.out.println("\nYou don't have all that land to till, please enter a smaller amount");
            return true;
        }
        else {
            // use explicit type casting & Math.ceil method to round up
            // in case of odd user inputs and to count 1 bushel also for half acre
            bushelsRequired = (int) Math.ceil(acresToPlant/2);
            if ( bushelsRequired > CityOfAaron.getCurrentGame().getWheatInStorage() ){
                System.out.println("\nYou don't have all that wheat available, please enter a smaller amount");
                return true;
            }
            else {
                int wheatLeftInStorage = CityOfAaron.getCurrentGame().getWheatInStorage() - bushelsRequired;
                System.out.println("\nThis is the new amount of wheat available in the Storehouse: " + wheatLeftInStorage + "\n\n");
                CityOfAaron.getCurrentGame().setWheatInStorage(wheatLeftInStorage);
            }
        }
          
        return false;
    }
    
}
