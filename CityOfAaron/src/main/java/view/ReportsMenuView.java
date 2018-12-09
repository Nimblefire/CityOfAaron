package view;

/**
 *
 * @author Andrea
 */
import model.*;
import app.*;
import control.*;
import exceptions.GameControlException;
import java.util.ArrayList;

public class ReportsMenuView extends ViewBase {

    /**
     * Constructor
     */
    public ReportsMenuView() {
    }
    
    public static String currentFlag = null;
    public static String getCurrentFlag(){
        return currentFlag;
    }
    
    public static void setCurrentFlag(String flag){
        currentFlag = flag;
    }

    @Override
    protected String getMessage() {
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
     *
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
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        String flag;
        switch (inputs[0].trim().toUpperCase()) {
            case "A":
                flag = "A";
                setCurrentFlag(flag);
                    try {
                        reportAuthors();
                    } catch (GameControlException gc) {
                            ErrorView.display(this.getClass().getName(),gc.getMessage());
                    }
                break;
            case "L":
                flag ="L";
                setCurrentFlag(flag);
                    try {
                        reportLivestocks();
                    }catch (GameControlException gc) {
                            ErrorView.display(this.getClass().getName(), gc.getMessage());
                    }
                break;
            case "P":
                currentFlag = "P";
                try {
                    reportProvisions();
                } catch (GameControlException gc) {
                    ErrorView.display(this.getClass().getName(), gc.getMessage());
                }
                break;
            case "T":
                reportTools();

                break;
            case "B":
                console.println("Exiting Report Menu...\n");
                return false;
            default:
                console.println("Invalid selection, try again.\n");
        }

        return true;
    }

    // To fulfill the requirements of the rubric (do-while logic + two String methods)
    private void reportAuthors() throws GameControlException {

        // Get authors from the Storehouse 
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        console.println("\nLet's get to know the authors:\n");

        // Display the Authors
        for ( Author aut : authors ){
                console.println(aut.getTitle() +" "+ aut.getName());
        }
        
        SaveReportView view = new SaveReportView();
        view.displayView();

        /* Alternative
        int i = 0;
        do {
            console.println(authors[i].getTitle().toUpperCase() + " " + authors[i].getName());
            i++;
        } while (i < authors.length);
        */
        
        /*
        System.out.println("\nFollow the list of male authors:");
        ArrayList<String> maleAuths = control.StorehouseControl.pickAuthorsByTitle("Mr");
        for(String auth : maleAuths){
            System.out.println(auth);
        }
          
        System.out.println("\nFollow the list of female authors:");
        ArrayList<String> femaleAuths = control.StorehouseControl.pickAuthorsByTitle("Mrs");
        for(String auth : femaleAuths){
            System.out.println(auth);
        }
        
        System.out.println("\nFollow the longest author's name");
        String authorLong = control.StorehouseControl.pickAuthorLongestName();
        System.out.println(authorLong);
        
        System.out.println("\nFollow the name of an author randomly chosen by the system");
        String author = control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(0, authors.length-1));
        System.out.println(author);
        
        System.out.println("\nFollow the alphabetical list of the authors by using the sort() method");
        String[] sortedAuth = control.StorehouseControl.sortAuthorsByName();
        for(String name : sortedAuth){
                System.out.println(name);
        }
        
        System.out.println("\nFollow the alphabetical list of the authors by using the bubble sort method");
        Author[] sortedAuthByLogarithm = control.StorehouseControl.sortAuthorsByNameAlgorithm();
        for(Author aut : sortedAuthByLogarithm){
            System.out.println(aut.getName());
        }
        
        // LET'S TEST ONE OF THE GAMECONTROLEXCEPTION ERRORS
        
        //System.out.println("\nRaise a GameControlException error when the author is randomly chosen" + 
        //                   "\nby providing negative values to the getRandomValue function"+
        //                   "\n---------------------------------------------------------------------");
        // control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(0, -1));
        
        System.out.println("\nRaise a GameControlException error when the author is randomly chosen" + 
                           "\nby providing a higher value which is smaller than the lower one"+
                           "\n---------------------------------------------------------------------");
        control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(5, 2));
        
        System.out.println("\nRaise a GameControlException error when the author is randomly chosen" +
                           "\nby providing a higher value that equals integer type upper limit" +
                           "\n----------------------------------------------------------------------------------");
        control.StorehouseControl.pickAuthorByRandomIndex(GameControl.getRandomValue(0, Integer.MAX_VALUE));
        */    
    }

    private void reportLivestocks() throws GameControlException{
        // Get animals from Storehouse
        //for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getAnimals().size(); i++) {
            //console.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getName()
                    //+ "\nAge: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getAge()
                   // + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getCondition()
                    //+ "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getQuantity());
            //print title and column headings
            console.println("\n\nLivestock Report                 ");
            console.printf("%n%-20s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
            console.printf("%n%-20s%10s%10s%10s", "----", "---", "---------", "---------");

            for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getAnimals().size(); i++) {
            console.printf("%n%-20s%10s%10s%10s", CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getName(), 
                    CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getAge(), 
                    CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getCondition(), 
                    CityOfAaron.getCurrentGame().getStorehouse().getAnimals().get(i).getQuantity());
            console.println();
            pause(2000);
        }

        // List Animals in Alphabetical Order
        console.println("\n\nList Animals in Alphabetical order   ");
        console.printf("%n%-15s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
        console.printf("%n%-15s%10s%10s%10s", "----", "---", "---------", "---------");
        
        control.StorehouseControl.sortAnimalbyName();

        for (Animal animal : CityOfAaron.getCurrentGame().getStorehouse().getAnimals()) {
            console.printf("%n%-15s%10d%10s%7d", animal.getName()
                                             , animal.getAge()
                                             , animal.getCondition()
                                             , animal.getQuantity());
        console.println();
        pause(1000);
            //console.println(animal);
        }
        //Filter the Animals in GOOD condition
        console.println("\n\nAnimals in GOOD condition    ");
        console.printf("%n%-15s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
        console.printf("%n%-15s%10s%10s%10s", "----", "---", "---------", "---------");
        ArrayList<Animal> filteredAnimals = StorehouseControl.filterAnimalbyCondition("GOOD");
        for (Animal animal : filteredAnimals) {
            console.printf("%n%-15s%10d%10s%7d",animal.getName()
                                             , animal.getAge()
                                             , animal.getCondition()
                                             , animal.getQuantity());
        //console.println(animal);
        console.println();
        pause(1000);
        }

        //Sort Animals by age
        console.println("\n\nList Animals by Age, oldest to youngest    ");
        console.printf("%n%-15s%10s%10s%10s", "Name", "Age", "Condition", "Quantity");
        console.printf("%n%-15s%10s%10s%10s", "----", "---", "---------", "---------");
        control.StorehouseControl.sortAnimalbyAge();
        for (Animal animal : CityOfAaron.getCurrentGame().getStorehouse().getAnimals()) {
            console.printf("%n%-15s%10d%10s%7d",animal.getName()
                                             , animal.getAge()
                                             , animal.getCondition()
                                             , animal.getQuantity());
        console.println();
        pause(1000);
        //console.println(animal);
        }

        SaveReportView view = new SaveReportView();
        view.displayView();
        
        //SaveLivestockReportView view = new SaveLivestockReportView();
        //view.displayView();
    }

    private void reportProvisions() throws GameControlException{
        console.println("\n\nList Animals in Alphabetical order   ");
        console.printf("%n%-15s%10s%10s%15s", "Name", "Condition", "Quantity", "Perishable");
        console.printf("%n%-15s%10s%10s%15s", "----", "---------", "---------", "---------");
        ArrayList<Provision> provisions = CityOfAaron.getCurrentGame().getStorehouse().getProvisions();
        for (Provision provision : provisions) {
                String perishable;
                if (provision.getPerishable()){
                    perishable = "Yes";
                } else {
                    perishable = "No";
                }
                console.printf("%n%-15s%10s%10s%15s", provision.getName(), provision.getCondition(), provision.getQuantity(), perishable);
            }

        SaveReportView view = new SaveReportView();
        view.displayView();
    }

    private void reportTools() {
        for (int i = 0; i < CityOfAaron.getCurrentGame().getStorehouse().getTools().size(); i++) {
            console.println("\nName: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getName()
                    + "\nCondition: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getCondition()
                    + "\nQuantity: " + CityOfAaron.getCurrentGame().getStorehouse().getTools().get(i).getQuantity());
            pause(2000);
        }

        SaveReportView view = new SaveReportView();
        view.displayView();
    }
}
