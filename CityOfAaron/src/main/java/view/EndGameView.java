/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import app.*;

/**
 *
 * @author Andrea
 */
public class EndGameView extends ViewBase {
    
    // Constructor 
    public EndGameView(){
    }
    
    @Override
    protected String getMessage(){
        
        String message = "";
        
        if ((CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved() >= CityOfAaron.getCurrentGame().getCurrentPopulation())) {
            message = "\nToo bad, " + CityOfAaron.getCurrentGame().getPlayer().getName()
                    + ", it seems you didn't meet the expectations of your mandate.\n"
                    + "\nWhat do you want to do next?...\n"
                    + "B - Back to the Main Menu to start over or restart from a checkpoint\n"
                    + "E - Just exit the game and leave the country\n";
        }
        else if ((10 <= CityOfAaron.getCurrentGame().getAnnualReport().getYear())){
            message = "Congratulations!! You magnified your calling and your name will be immortalized througout all ages to come!"
                    + "\nWhat do you want to do next?...\n"
                    + "B - Back to the Main Menu to start over or restart from a checkpoint\n"
                    + "E - Just exit the game\n";
            
        }      
        return message;
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
            case "B":
                mainMenu();
                break;
            case "E":
                System.out.println("\nExiting Game...\n");
                endGame();
                break;
            default:
                System.out.println("\nInvalid selection, try again.\n");
                return true;
        }
                      
       return false; 
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void mainMenu(){
        View mainMenu = new MainMenuView();
        mainMenu.displayView();
    }
    
    private void endGame(){
        System.exit(0);
    }
    
}
