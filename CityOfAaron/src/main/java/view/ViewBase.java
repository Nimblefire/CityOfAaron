/**
 * This is going to be the super class of all the View classes
 */

package view;

import app.CityOfAaron;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public abstract class ViewBase implements View {
    
    // Empty constructor
    public ViewBase(){
    }
    
    // references to the character stream objects created in the main class (CityOfAaron)
    protected final BufferedReader keyboard = CityOfAaron.getInFile();
    protected final PrintWriter console = CityOfAaron.getOutFile();
    
    // Get the view's content (allows to display dynamic content)
    protected abstract String getMessage();
    
    /**
     * Get all the inputs from the user
     * 
     * @return
     */
    protected abstract String[] getInputs();
       
    /**
     * Perform the action selected by the user
     * 
     * @param inputs
     * @return true when the view has to repeat itself or false when
     *         the view has to exit and return to the previous view.
     */
    protected abstract boolean doAction(String[] inputs);
    
    
    /**
     * Control the behavior of this view until the user closes it
     */
    @Override
    public void displayView(){
        
        boolean keepGoing = true;
        
        while (keepGoing == true) {
            
            String message = getMessage();
            if (message != null) {
                console.println(getMessage());
            }
            
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);      
        }    
    }
    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return 
     */ 
    protected String getUserInput(String prompt, boolean allowEmpty){
        
        //Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;
        try {
            while(inputReceived == false){

                console.println(prompt);
                input = keyboard.readLine();

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
        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + ioe.getMessage());
        }
            
        return input;   
    }
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have 
     * to type it ourselves.
     * @param prompt
     * @return 
     */
    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
    }
    
    /**
     * Pause the program for the amount of millisecond specified
     * 
     * @param milliseconds
     */
    protected static void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            // do nothing
        }
    
    }
    
    
}
