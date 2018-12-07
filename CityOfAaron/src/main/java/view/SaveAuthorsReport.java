/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Author;
import static view.ViewBase.pause;

/**
 *
 * @author Andrea
 */
public class SaveAuthorsReport extends ViewBase {
    
    // Constructor 
    public SaveAuthorsReport(){
    }
    
    @Override
    protected String getMessage(){
        return null;
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
        inputs[0] = getUserInput("\nPlease, enter a file name or a file path to save the report above:");
        
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
    public boolean doAction(String[] inputs) {
                
                String filename = inputs[0];
                Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
                
                
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
                          
        return false; 
    }
}