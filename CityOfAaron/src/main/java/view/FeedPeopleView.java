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
public class FeedPeopleView extends ViewBase{
    
    /**
     * Constructor
     */
    public FeedPeopleView(){
    }
    
    @Override
    public String getMessage(){
        return "\nFeed the People\n"
                + "--------------------------\n"
                + "You currently have " + CityOfAaron.getCurrentGame().getCurrentPopulation() + " people in your city.\n"
                + "You have " + CityOfAaron.getCurrentGame().getWheatInStorage() + " bushels of grain in store.";
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
        inputs[0] = getUserInput("How many bushels of grain do you want to give to the people?");
        
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
        int bushelsForFood;
        try {
            bushelsForFood = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException exception) {
            System.out.println("The value must be positive whole number.");
            return true;//keep going
        }
        boolean check = checkInput(bushelsForFood);
        pause(2000);
        
        return check;
    }
    
    private boolean checkInput(int bushelsForFood){
        if (bushelsForFood < 0){
            System.out.println("The value must be positive whole number.");
            return true;
        } else if (bushelsForFood > CityOfAaron.getCurrentGame().getWheatInStorage()) {
            System.out.println("The value is greater than the wheat you have. Please insert a valid value.");
            return true;
        } else {
            CityOfAaron.getCurrentGame().setBushelsForFood(bushelsForFood);
            System.out.println("You have " + (CityOfAaron.getCurrentGame().getWheatInStorage()-bushelsForFood) + " bushels of wheat left.");
            return false;
        }
    }
}
