package view;

/**
 *
 * @author Andrea
 */

import java.util.Arrays;
import model.*;
import app.*;


public class ReportsMenuView extends ViewBase {
  
    /**
     * Constructor
     */
    public ReportsMenuView(){          
    }

    @Override
    protected String getMessage(){
        return "\nReports Menu\n"
                + "------------\n"
                + "A - View the authors of this game\n"
                + "L - View the livestock in the storehouse\n"
                + "P - View the provisions in the storehouse\n"
                + "T - View the tools in the storehouse\n"
                + "B - Back to Game Menu\n";
    }

    /**
     * Get the set of inputs from the user.
     * @return 
     */
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get from the user.
        String[] inputs = new String[1];
        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        inputs[0] = getUserInput("Select an action from the menu above:");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){

        switch ( inputs[0].trim().toUpperCase() ){
            case "A":
                reportAuthors();
                break;
            case "L":
                reportLivestocks();
                break;
            case "P":
                reportProvisions();
                break;
            case "T":
                reportTools();
                break;
            case "B":
                System.out.println("Exiting Report Menu...\n");
                return false;
            default:
                System.out.println("Invalid selection, try again.\n");
        }
                
       return true; 
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    // To fulfill the requirements of the rubric (do-while logic + two String methods)
    private void reportAuthors(){
          
        // Get authors from the Storehouse 
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        int i = 0;
        int j = 2;
        System.out.println("\nLet's get to know the authors:\n");
        
        // Display the Authors
        do {
            System.out.println(authors[i].getTitle().toUpperCase() + " " + authors[i].getName().concat("\n"));
            i++; 
        } while (i < 3);
            
        SaveReportView view = new SaveReportView();
        view.displayView();
              
    }

    private void reportLivestocks(){
        System.out.println("List of animals in storehouse coming soon\n");
    }

    private void reportProvisions(){
        System.out.println("List of provisions in storehouse coming soon\n");
    }

    private void reportTools(){
        System.out.println("List of tools in storehouse coming soon\n");
    }
}