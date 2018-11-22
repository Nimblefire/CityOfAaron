package view;

/**
 *
 * @author Andrea
 */

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
    @Override
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
    @Override
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
        System.out.println("\nLet's get to know the authors:\n");
        
        // Display the Authors
        do {
            System.out.println(authors[i].getTitle().toUpperCase() + " " + authors[i].getName());
            i++; 
        } while (i < authors.length);
        
        System.out.println("\nFollow the list of male authors:");
        control.StorehouseControl.pickAuthorsByTitle("Mr");
        
        System.out.println("\nFollow the list of female authors:");
        control.StorehouseControl.pickAuthorsByTitle("Mrs");
        
        System.out.println("\nFollow the longest author's name");
       
        
        SaveReportView view = new SaveReportView();
        view.displayView();
              
    }

    private void reportLivestocks(){
        for (int i=0; i < CityOfAaron.getCurrentGame().getStorehouse().getAnimals().size(); i++){
            System.out.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getName()
                                + "\nAge: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getAge()
                                + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getCondition()
                                + "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getQuantity());
            pause(2000);
        }
        
        SaveReportView view = new SaveReportView();
        view.displayView();
    }

    private void reportProvisions(){
        for (int i=0; i < CityOfAaron.getCurrentGame().getStorehouse().getProvisions().size(); i++){
            System.out.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getName()
                                + "\nPerishable: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getPerishable()
                                + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getCondition()
                                + "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getProvisions().get(i).getQuantity());
            pause(2000);
        }
        
        SaveReportView view = new SaveReportView();
        view.displayView();
    }

    private void reportTools(){
        for (int i=0; i < CityOfAaron.getCurrentGame().getStorehouse().getTools().size(); i++){
            System.out.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getName()
                                + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getCondition()
                                + "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getQuantity());
            pause(2000);
        }
        
        SaveReportView view = new SaveReportView();
        view.displayView();
    }
}