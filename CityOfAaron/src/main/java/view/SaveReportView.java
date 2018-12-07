package view;

/*
import app.CityOfAaron;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Author;
import static view.ViewBase.pause;
*/

/**
 *
 * @author Andrea
 */


public class SaveReportView extends ViewBase {

    /**
     * Constructor
     */
    public SaveReportView(){          
    }

    @Override
    protected String getMessage(){
        return "\nDo you want to save this report on your local disk?\n"
                + "Y - Save the report\n"
                + "N - Back to Report Menu\n";
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
            case "Y":
                saveReport();
                break;
            case "N":
                console.println("Back to Report Menu...\n");
                break;
            default:
                ErrorView.display(this.getClass().getName(),"Invalid selection, try again.\n");
                return true;
        }
                      
       return false; 
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.

    private boolean saveReport(){
        
        if ( ReportsMenuView.getCurrentFlag().equals("A") ) {
            SaveAuthorsReport view = new SaveAuthorsReport();
            view.displayView();
        }
        
        if ( ReportsMenuView.getCurrentFlag().equals("L") ) {
            console.println("Saving Livestock report test...");
        }
        
        if ( ReportsMenuView.getCurrentFlag().equals("P") ) {
            console.println("Saving Provision report test...");
        }
        
        if ( ReportsMenuView.getCurrentFlag().equals("T") ) {
            console.println("Saving Tools report test...");
        }
        
        
           
        /*
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        String filename;
        String test = "Please, enter a file name or file path:";
        console.println(test);
        
        try {
            filename = keyboard.readLine();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
            return true;
        }
        
        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
                report.println("\n\tAUTHORS OF THE GAME");
                report.println();

                String formatString = "%-5s %-20s";
                report.println(String.format(formatString, "TITLE", "NAME"));
                report.println("----- --------------------");
                for ( Author aut : authors ){
                        report.println(String.format(formatString,aut.getTitle(),aut.getName()));
                }
                report.println();
                report.println("End");

                console.println("\nReport successfully saved in " + filename);

        } catch (IOException e) {
            ErrorView.display(this.getClass().getName(),"Unreachable or unsupported file path");
            pause(2000);
            return true;
        }
        */
        return true;       
    }
}
