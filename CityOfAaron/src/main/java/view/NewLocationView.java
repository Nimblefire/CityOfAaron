
package view;

import java.util.Arrays;
import model.*;
import app.CityOfAaron;
import control.GameControl;

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

        if (inputs[0] == null || inputs[1] == null || inputs[0].equals("") || inputs[1].equals("")) {
            System.out.println("Missing coordinates. Returning to the Game menu...");
            return false;
        }
        //False breaks out of loop and returns to who called it, which is Game menu in this case.
        //If true it moves on to the next statement.

        //declare int row and int column and assign the values from string row and string column that were entered in by the player.
        int row, column;
        try {
            row = Integer.parseInt(inputs[0]);
            column = Integer.parseInt(inputs[1]);
        } catch (NumberFormatException exception) {
            System.out.println("Row and Column values must be whole numbers.");
            return true;//keep going
        }

        //if row = 0,1,2,3,4 and column =  0,1,2,3,4 call moveToLocation
        if ((row > -1 && row < 5) && (column > -1 && column < 5)) {
            moveToNewLocation(row, column);
        } else {
            System.out.println("Choose coordinate between 0 and 4, try again.\n");
        }

        return false;
        //return true;
    }

    // Define your action handlers here. These are the methods that your doAction() method will call based on the user's input
    private void moveToNewLocation(int row, int column) {

        Point coordinates = new Point();
        coordinates.setRow(row);
        coordinates.setColumn(column);
        
        // call the current map associated to the current game
        Map map = CityOfAaron.getCurrentGame().getMap();
        map.setCurrentLocation(coordinates);
        
        /**
        //Location[][] array = map.getLocations();
        //CityOfAaron.getCurrentGame().getMap().setCurrentLocation(point);
        Location temple = new Location();
        Location watchtower = new Location();
        Location undevelopedLand = new Location();
        Location wheatField = new Location();
        Location river = new Location();
        Location granary = new Location();
        Location rulerCourt = new Location();
        Location village = new Location();

        //Tips
        String[] tip1 = {"Every person needs 20 bushels of wheat per year in order to survive."};
        String[] tip2 = {"Pay your tithes and offerings for a higher wheat yeild per acre."};
        String[] tip3 = {"Attend the temple regularly."};
        String[] tip4 = {"Buy land when land prices are low."};
        String[] tip5 = {"Pay tithing and your will suffer fewer losses of crops to rats."};
        String[] tip6 = {"Feed your people well and they will work hard for you."};
        String[] tip7 = {"One person can mantain 10 acres of land."};
        String[] tip8 = {"You can plant 2 acres with 1 bushel of wheat."};

        //watchtower
        watchtower.setName("A Watchtower");
        watchtower.setDescription("You can see far and wide from this location.");
        watchtower.setGameTips(tip1);
        watchtower.setMapSymbol("W");

        //wheat Field
        wheatField.setName("A Wheat Field");
        wheatField.setDescription("This will provide your food for the year");
        wheatField.setGameTips(tip2);
        wheatField.setMapSymbol("F");

        //river
        river.setName("The River");
        river.setDescription("The river provides water and recreation for the City of Aaron.");
        river.setGameTips(tip3);
        river.setMapSymbol("R");

        //undeveloped Land
        undevelopedLand.setName("Undeveloped Land");
        undevelopedLand.setDescription("You can plant more crops on this land.");
        undevelopedLand.setGameTips(tip4);
        undevelopedLand.setMapSymbol("U");

        //temple
        temple.setName("Temple");
        temple.setDescription("You will find peace when you visit the temple.");
        temple.setGameTips(tip5);
        temple.setMapSymbol("T");

        //granary
        granary.setName("Granary and Storehouse");
        granary.setDescription("Your animals, tools and provisions are stored here. The authors of this game can be viewed here as well.");
        granary.setGameTips(tip6);
        granary.setMapSymbol("G");

        //The Ruler's Court
        rulerCourt.setName("The Ruler's Court");
        rulerCourt.setDescription("This is where you live and work.");
        rulerCourt.setGameTips(tip7);
        rulerCourt.setMapSymbol("C");

        //Village
        village.setName("The Village");
        village.setDescription("This is where people gather to buy and sell goods.");
        village.setGameTips(tip8);
        village.setMapSymbol("V");
        */
        
        Location[][] mapLocations = map.getLocations(); 

        System.out.println("You are contemplating the " + mapLocations[row][column].getName() + "\n The symbol of this place is "+ mapLocations[row][column].getMapSymbol() + "\n" + mapLocations[row][column].getDescription() + "\n" + "Game Tip: " + mapLocations[row][column].getGameTips(GameControl.getRandomValue(0, 7)) + "\n");

        //CityOfAaron.getCurrentGame().getMap().setCurrentLocation(coordinates);
    }

}
