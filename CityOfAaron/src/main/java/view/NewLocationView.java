
package view;

import model.*;
import app.CityOfAaron;
import control.GameControl;
import control.MapControl;
import exceptions.*;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class NewLocationView extends ViewBase {

    /**
     * Constructor
     */
    public NewLocationView() {
    }
    
    @Override
    protected String getMessage(){
        return "Each location has a column and row coordinate.\n"
                + "1. View the map and notice the point(row, column) coordinates of where you want to move.\n"
                + "2. Please enter column and row interger to indicate where you want to move.\n"
                + "3. You will see the location name, location description, symbol and a game tip. \n\n";

    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
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
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        
        //declare int row and int column and assign the values from string row and string column that were entered in by the player.
        int row, column;
        try {
            row = Integer.parseInt(inputs[0]);
            column = Integer.parseInt(inputs[1]);
        } catch (NumberFormatException exception) {
            System.out.println("Row and Column values must be whole numbers.\n");
            return true;//keep going
        }
        
        try {
            moveToNewLocation(row, column);
        } catch (GameControlException | ArrayIndexOutOfBoundsException | MapControlException ce){
            System.out.println(ce.getMessage());
            System.out.println("Choose coordinates between 0 and " + (CityOfAaron.getCurrentGame().getMap().getLocations().length-1) + ", try again.\n");
            pause(2000);
            return true;
        }
        
        return false;
    }

    // Define your action handlers here. These are the methods that your doAction() method will call based on the user's input
    private void moveToNewLocation(int row, int column) throws GameControlException, MapControlException {
        
        Point coordinates = new Point(row, column);
        
        Location mapLocation = MapControl.setCurrentLocation(CityOfAaron.getCurrentGame(), coordinates);
        
        String GameTip = mapLocation.getGameTips(GameControl.getRandomValue(0, mapLocation.getGameTips().length-1));

        System.out.println("You are contemplating the " + mapLocation.getName() 
                            + " also known as \""+ mapLocation.getMapSymbol() 
                            + "\"\n" + mapLocation.getDescription() 
                            + "\n" + "Game Tip: " + GameTip
                            + "\n");

    }
}
