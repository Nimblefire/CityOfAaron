
package view;
/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class GameMenuView extends ViewBase {
    
    /**
     * Constructor
     */
    
    
    public GameMenuView() {
    }
    
    @Override
    protected String getMessage () {
        return "Game Menu\n"
                + "---------\n"
                + "M - View the Map\n"
                + "L - Move to a new location\n"
                + "C - Manage the Crops\n"
                + "Y - Live the Year\n"
                + "R - Reports Menu\n"
                + "S - Save Game\n"
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
        
        
        //if more that 50% pf people starve call
        //gameOver();
        
        // calls final rating at the end of 10 years
        //finalRating();
        

        switch ( inputs[0].trim().toUpperCase() ){
            case "M":
                viewMap();
                break;
            case "L":
                newLocation();
                break;
            case "C":
                manageCrops();
                break;
            case "Y":
                liveTheYear();
                //this is where we will put function to determine if the game ends, and when to display final report
                break;
            case "R":
                reportsMenu();
                break;
            case "S":
                saveGame();
                break;
            case "B":
                System.out.println("\nExiting Game Menu...");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            default: 
                System.out.println("\nInvalid selection, try again.");
        }
              
        return true;
    }
     
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void viewMap(){
        MapView mapView = new MapView();
        mapView.displayView();
    }

    private void newLocation(){
        // System.out.println("*** newLocation() called. Implementation coming soon... ");
         NewLocationView view = new NewLocationView();
         view.displayView();
    }

    private void manageCrops(){
        View manageCrops = new ManageCropsView();
        manageCrops.displayView();
    }
    
    private void liveTheYear(){
        System.out.println("*** liveTheYear() called. Implementation coming soon... ");
    }

    private void reportsMenu(){
        View reports = new ReportsMenuView();
        reports.displayView();    
    }
     
    private void saveGame(){
        View saveGame = new SaveGameView();
        saveGame.displayView();
    }
    
    private void gameOver() {
        View gameOver = new EndGameView();
        gameOver.displayView();
    }
     
     //private void currentAnnualReport() {
         //System.out.println("*** currentAnnualReport() called. Implementation coming soon... ");
     //}
     
     //private void finalRating() {
         //System.out.println("*** finalRating() called. Find out how player did after 10 years. Implementation coming soon... ");
     //}
}
