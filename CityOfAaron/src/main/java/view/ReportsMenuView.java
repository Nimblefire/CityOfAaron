package view;

/**
 *
 * @author Andrea
 */

import java.util.Scanner;
import java.util.ArrayList;
import model.*;


public class ReportsMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public ReportsMenuView(){
        
        message = "\nReports Menu\n"
                + "------------\n"
                + "A - View the authors of this game\n"
                + "L - View the livestock in the storehouse\n"
                + "P - View the provisions in the storehouse\n"
                + "T - View the tools in the storehouse\n"
                + "B - Back to Game Menu\n";            
    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses an action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
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
                
        // Create Author objects
        Author Cristina = new Author();
        Cristina.setName("Cristina Irwin");
        Cristina.setTitle("Mrs");
        
        Author Andrea = new Author();
        Andrea.setName("Andrea Rochira");
        Andrea.setTitle("Mr");
        
        Author Stefano = new Author();
        Stefano.setName("Stefano DaPonte Becher");
        Stefano.setTitle("Mr");
        
        // Add Author objects to an ArrayList
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(Cristina);
        authors.add(Stefano);
        authors.add(Andrea);
        
        int size = authors.size();
        int i = 0;
        System.out.println("\nLet's get to know the authors:\n");
        
        do {
            System.out.println(authors.get(i).getTitle().toUpperCase() + " " + authors.get(i).getName().concat("\n"));
            i++; 
        } while (i < size);
            
        SaveReportView view = new SaveReportView();
        view.displayView();
              
    }

    private void reportLivestocks(){
        System.out.println("List of animals in storehouse coming soon");
    }

    private void reportProvisions(){
        System.out.println("List of provisions in storehouse coming soon");
    }

    private void reportTools(){
        System.out.println("List of tools in storehouse coming soon");
    }
}