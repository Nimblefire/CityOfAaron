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
        inputs[0] = getUserInput("\n Please, enter a file name or a file path to save the report: ");

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
        //ArrayList<Animal> animal = animal;
        ArrayList<Animal> animal = CityOfAaron.getCurrentGame().getStorehouse().getAnimals();

        
        try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            report.println("\n\nLivestock Report                 ");
            report.printf("%n%-20s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
            report.printf("%n%-20s%10s%10s%10s", "----", "---", "---------", "---------");
            
            for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getAnimals().size(); i++) 
                report.printf("%n%-20s%10s%10s%10s", animal.get(i).getName(),  animal.get(i).getAge(), 
                                                     animal.get(i).getCondition(), animal.get(i).getQuantity());
            report.println();
            report.println("End");
            report.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        
   return false;
    }
        //switch (inputs[0].trim().toUpperCase()) {
            //case "Y":
                //try {
                //saveAnimalReport();
                //} catch (GameControlException |  IOException gc) {
                    //ErrorView.display(this.getClass().getName(), gc.getMessage());
                //}
                //break;
            //case "N":
                //console.println("Back to Report Menu...\n");
                //break;
            //default:
                //ErrorView.display(this.getClass().getName(), "Invalid selection, try again.\n");
                //return true;
        //}
     
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.

   // private void saveReport() {
       // View saveReport = new SaveLivestockReportView();
        //saveReport.displayView();
   // }
    //private void saveAnimalReport(ArrayList<Animal> animal, String filename) throws GameControlException, IOException {

    //private void saveAnimalReport() throws GameControlException, IOException {
        
        //ArrayList<Animal> animal = CityOfAaron.getCurrentGame().getStorehouse().getAnimals();
        //String filename = "Livestock.txt";
        
        //try (PrintWriter report = new PrintWriter(new FileWriter(filename))) {
            //report.println("\n\nLivestock Report                 ");
            //report.printf("%n%-20s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
            //report.printf("%n%-20s%10s%10s%10s", "----", "---", "---------", "---------");
            
            //for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getAnimals().size(); i++) 
                //report.printf("%n%-20s%10s%10s%10s", CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getName(),
                        //CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getAge(),
                       //CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getCondition(),
                        //CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getQuantity());
            //report.println();
            //report.println("End");
            //report.flush();
        //} catch (IOException exception) {
            //exception.printStackTrace();
        //}
        //console.println("'Saving report on disk' options coming soon...");
        //String fileLocation = "animalreport.txt";
        //create BufferedReader object for input file
       // try {

            //print initial report
            //console.println("\n\nLivestock Report                 ");
            //console.printf("%n%-20s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
            //console.printf("%n%-20s%10s%10s%10s", "----", "---", "---------", "---------");

            //for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getAnimals().size(); i++) {
                //console.printf("%n%-20s%10s%10s%10s", CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getName(),
                        //CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getAge(),
                       // CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getCondition(),
                        //CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getQuantity());
                //console.println();
            //}

            //console.println("'Saving report on disk' options coming soon...");
        //} catch (IOException ex) {
            //ErrorView.display(this.getClass().getName(), ex.getMessage());
            //pause(3000);
       // }
    //}
}
