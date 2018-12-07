/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;
import model.*;
import java.util.ArrayList;
import java.io.*;
import exceptions.*;
import control.*;

/**
 *
 * @author cristinairwin
 */
public class SaveLivestockReportView extends ViewBase {

    /*
    Constructor
     */
    public SaveLivestockReportView() {

    }

    @Override
    protected String getMessage() {
        return null;
        //return "\nDo you want to save this report on your local disk?\n"
        //+ "Y - Save the report\n"
        //+ "N - Back to Report Menu\n";
    }

    /*
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get from the user.
        String[] inputs = new String[1];

        // the following string is printed to the console by the statement 'System.out.println(prompt)'
        inputs[0] = getUserInput("\nPlease, enter a file name or a file path to save the report: ");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    /*
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        String filename = inputs[0];
        ArrayList<Animal> animals = CityOfAaron.getCurrentGame().getStorehouse().getAnimals();

        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("\n\nLivestock Report                 ");
            report.printf("%n%-20s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
            report.printf("%n%-20s%10s%10s%10s", "----", "---", "---------", "---------");

            for (Animal animal : animals) {
                report.printf("%n%-20s%10s%10s%10s", animal.getName(), animal.getAge(),
                        animal.getCondition(), animal.getQuantity());
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
