/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import control.*;
import app.CityOfAaron;
import java.util.Scanner;
import model.*;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class NewLocationView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public NewLocationView(){
        
        message = "Each location has a column and row interger.\n"
                + "View the map and notice the point(row, column) coordinates of where you want to move."
                + "Please enter an column and row interger to indicate where you want to move.\n"
                + "Your new location will also give you game tips. \n\n";
                
    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);

            // let's ask what the user wants to do and collect his choice
            String[] inputs = getInputs();

            // calling doAction method passing the user input collected by getInputs
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
         String[] inputs = new String[2];
        //int[][] inputs = new int[5][5];

        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        // included in the getUserInput method
        
        
        inputs[0] = getUserInput("Please enter the row coordinate", true);
        inputs[1] = getUserInput("Please enter the column coordinate", true);

        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
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
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        
        if ( inputs[0] == null || inputs[1] == null || inputs[0].equals("") || inputs[1].equals("")) {
            System.out.println("Missing point coordinates. Returning to the Game menu...");
            return false; 
        }
        //False breaks out of loop and returns to who called it, which is Game menu in this case.
        //If true it moves on to the next statement.
       
        
        //Get input from user-my attempt
        //String rowInput = inputs[0];
        //int row = Integer.parseInt(rowInput);
        //String columnInput = inputs[1];
        //int column = Integer.parseInt(columnInput);
        //String row = inputs[0];
        //String column = inputs[1];
        
       
        //declare int row and int column and assign the values from string row and string column that were entered in by the player.
        int row, column;
        try {
            row = Integer.parseInt(inputs[0]);
            column = Integer.parseInt(inputs[1]);
        } catch (NumberFormatException exception) {
            System.out.println("Row and Column values must be whole numbers.");
            return true;//keep going
        }
        
        
        //if row == 0,1,2,3,4,5 and column == 0,1,2,3,4,5 call moveToLocation
       if ((row >= 0 && row <=5 ) && (column >=0 && column <=5))  {
           moveToNewLocation(row, column);
       }
       
        
        
        //moveToNewLocation(row, column);
        //String playerName = inputs[0];
        //createAndStartGame(playerName);
        
        // to interrupt the loop of displayView method
        //return false;
        return true;
    }
     
    // Define your action handlers here. These are the methods that your doAction() method will call based on the user's input
    
    private void moveToNewLocation(int row, int column){
        
        
        Point coordinates = new Point();
        coordinates.setRow(row);
        coordinates.setColumn(column);
        
        Map map = new Map();
        map.setCurrentLocation(coordinates);
        
        CityOfAaron.getCurrentGame().getMap().setCurrentLocation(point);
        
      //Point rulersCourt = new Point();
      //rulersCourt.setRow(0);
      //rulersCourt.setColumn(0);
      //System.out.println("Rulers Court");
      
      //Point storehouse = new Point();
      //storehouse.setRow(0);
      //storehouse.setColumn(1);
      
      //Point wheatField = new Point();
      //wheatField.setRow(0);
      //wheatField.setColumn(2);
      
      //Point undevelopedLand = new Point();
      //undevelopedLand.setRow(0);
      //undevelopedLand.setColumn(3);
      
      //Point village = new Point();
      //village.setRow(1);
      //village.setColumn(5);
      
      //Point river = new Point();
      //river.setRow(1);
      //river.setColumn(0);
                
      //Point lamanitesLand = new Point();
      //lamanitesLand.setRow(1);
      //lamanitesLand.setColumn(2);
       
      //Point temple = new Point();
      //temple.setRow(1);
      //temple.setColumn(2);
      
      
        //Point thisLocation = new Point();
        //thisLocation.setRow(1);
        //thisLocation.setColumn(3);
        
        //System.out.println(thisLocation.toString())
        
        //Player player = new Player();
        //player.setName(playerName);

        //Game game = new Game();
        //game.setPlayer(player);
        
        //GameMenuView view = new GameMenuView();
        //view.displayView();

        //CityOfAaron.setCurrentGame(game);

        //System.out.println(thisLocation.toString());
       
    }

}
