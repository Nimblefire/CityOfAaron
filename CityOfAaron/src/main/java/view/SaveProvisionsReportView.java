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
import java.util.ArrayList;
import model.*;
import static view.ViewBase.pause;

/**
 *
 * @author dapon
 */
public class SaveProvisionsReportView extends ViewBase{

    @Override
    protected String getMessage() {
        return null;
    }

    @Override
    protected String[] getInputs() {
        // Declare the array to have the number of elements you intend to get from the user.
        String[] inputs = new String[1];
        
        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        inputs[0] = getUserInput("\nPlease, enter a file name or a file path to save the report above:");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
         
        return inputs;
    }

    @Override
    protected boolean doAction(String[] inputs) {
        String filename = inputs[0];
        ArrayList<Provision> provisions = CityOfAaron.getCurrentGame().getStorehouse().getProvisions();

        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("\n\nProvisions Report");
            report.printf("%n%-15s%10s%10s%15s", "Name", "Condition", "Quantity", "Perishable");
            report.printf("%n%-15s%10s%10s%15s", "----", "---------", "---------", "----------");
            
            for (Provision provision : provisions) {
                String perishable;
                if (provision.getPerishable()){
                    perishable = "Yes";
                } else {
                    perishable = "No";
                }
                report.printf("%n%-15s%10s%10s%15s", provision.getName(), provision.getCondition(), provision.getQuantity(), perishable);
            }

            report.println();
            report.println("End");
            console.println("\nReport successfully saved in " + filename);
            report.flush();

        } catch (IOException exception) {
            ErrorView.display(this.getClass().getName(), "Unreachable or unsupported file path");
            exception.printStackTrace();
            pause(1000);
            return true;
        }

        return false;
    }

    
}
