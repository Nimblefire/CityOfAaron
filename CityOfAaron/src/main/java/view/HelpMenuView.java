package view;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */

public class HelpMenuView extends ViewBase {

    /**
     * Constructor
     */
    public HelpMenuView(){
    }
    
    @Override
    protected String getMessage(){
        return "\nHelp Menu\n"
                + "---------\n"
                + "G - What are the goals of the game?\n"
                + "W - Where is the city of Aaron?\n"
                + "M - How do I view the map?\n"
                + "L - How do I move to another location?\n"
                + "S - How do I display a list of animals, provisions and tools in the city storehouse?\n"
                + "B - Back to Main menu\n";
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
        // included in the getUserInput method (line 92)
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
            case "G":
                whatAreTheGoals();
                break;
            case "W":
                whereIsTheCity();
                break;
            case "M":
                viewTheMap();
                break;
            case "L":
                moveToLocation();
                break;
            case "S":
                checkStorehouse();
                break;
            case "B":
                System.out.println("Exiting Help Menu...");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            default: 
                System.out.println("Invalid selection, try again.");
                
        }
        return true;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void whatAreTheGoals(){
        System.out.println("\nGoals of the game\n"
                         + "-----------------\n"
                         + "1. Govern the City of Aaron successfully for a 10 year term of office\n"
                         + "2. Determine how to allocate your bushels of wheat, each year you can\n"
                         + "   a. buy and sell acres of land\n"
                         + "   b. feed your people\n"
                         + "   c. plant seeds for next year's crops\n"
                         + "   d. pay tithes and offerings\n"
                         + "3. Don't starve your people; if more than 50% of the population starves\n   in one year, your people will feed you to the rats.\n\n"
                         + "If you make it to the 11th year, your rule will be evaluated and\nyou'll be ranked against great figures in history.\n\n" );
    }

    private void whereIsTheCity(){
        System.out.println("\nThe legendary City of Aaron, named after the high priest Aaron, brother of Moses, stands in vicinity\nof Moroni and Nephihah. The cities face Irreantum, which, being interpreted, is 'many waters'.\n\n");
    }

    private void viewTheMap(){
        System.out.println("\nYou can access the Map from the Game Menu, which is available when you start a new\ngame or load a saved game. Each location will teach you something about your role.\n");
    }

    private void moveToLocation(){
        System.out.println("\nThe Map Menu includes a list of locations from which to choose from\nand move between. You will be moving by foot or by horse.\n");
    }

    private void checkStorehouse(){
        System.out.println("\nTo display a list of animals, provisions, and tools, access the Game Menu and select Reports Menu or 'R'.\n");
    }
    
}
