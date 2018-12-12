package view;
import app.CityOfAaron;

/**
 *
 * @author cristinairwin
 */
public class PayTithingView extends ViewBase {
   
    
    /**
     * Constructor
     */
    public PayTithingView(){
    }
    @Override
    protected String getMessage() {
       return "\n Pay Tithes and Offerings\n"
                + "---------------------------------\n"
                + "Choose the tithing percentage to consacrate based on future harvested amount\n"
                + "\n";
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("What percentage of tithing and offerings would you like to pay on your bushels of wheat? \nPlease enter a number between 0 and 100:");
        
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
        //Check to see if input is empty or null
        if ( inputs[0] == null ||  inputs[0].equals("")) {
            ErrorView.display(this.getClass().getName(),"Missing donation. Returning to the Manage Crops menu...");
            return false; 
        }
        // declare int bushel and assign value from string
        int bushels;
        try {
            bushels = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException exception) {
            ErrorView.display(this.getClass().getName(),"Value must be a whole number. Try again.");
            return true;//keep going
        }
        
        //If bushels is greater than -1 or less than 101, call tithingPaid
       if (bushels > -1 && bushels < 101) {
            tithesPercent(bushels);
        }
       
       else {
           ErrorView.display(this.getClass().getName(),"Please enter a value between 0 and 100, try again.");
       }

        return false; // back to view that called doAction
    }
    
    private void tithesPercent(int bushels){
        CityOfAaron.getCurrentGame().setTithesPercent(bushels);
        console.println(bushels + " percent of wheat bushels paid in tithes and offerings.");
    }
}
