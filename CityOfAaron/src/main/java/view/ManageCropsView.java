package view;

/**
 *
 * @author Andrea
 */

public class ManageCropsView extends ViewBase {

    /**
     * Constructor
     */
    public ManageCropsView(){            
    }

    @Override
    protected String getMessage(){
        return "Manage Crops Menu\n"
                + "-----------------\n"
                + "B - Buy Land\n"
                + "S - Sell Land\n"
                + "F - Feed the People\n"
                + "P - Plant Crops\n"
                + "T - Pay Tithes and Offerings\n"
                + "Q - Back to Game Menu\n";
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
            case "B":
                buyLand();
                break;
            case "S":
                sellLand();
                break;
            case "F":
                feedThePeople();
                break;
            case "P":
                plantCrops();
                break;
            case "T":
                payTithesOfferings();
                break;
            case "Q":
                System.out.println("Exiting Manage Crops Menu...\n");
                return false;
            default:
                System.out.println("Invalid selection, try again.\n");
        }
                
       return true; 
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    // To fulfill the requirements of the rubric (do-while logic + two String methods)
    private void buyLand(){
        BuyLandView buyLand = new BuyLandView();
        buyLand.displayView();
        //System.out.println("Implementation coming soon...");
    }

    private void sellLand(){
        System.out.println("Implementation coming soon...");
    }

    private void feedThePeople(){
        FeedPeopleView feedPeople = new FeedPeopleView();
        feedPeople.displayView();
    }

    private void plantCrops(){
        System.out.println("Implementation coming soon...");
    }

    private void payTithesOfferings(){
        PayTithingView payTithing = new PayTithingView();
        payTithing.displayView();
        //System.out.println("Implementation coming soon...");
    }
    
}
