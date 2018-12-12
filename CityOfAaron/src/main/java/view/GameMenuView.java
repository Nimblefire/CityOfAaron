
package view;

import app.CityOfAaron;
import control.GameControl;
import control.LandControl;
import control.PeopleControl;
import exceptions.GameControlException;
import exceptions.WheatControlException;
import exceptions.PeopleControlException;
import model.AnnualReport;
import model.Game;

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
        return  "\nGame Menu\n"
                + "---------\n"
                + "M - View the Map\n"
                + "L - Move to a new location\n"
                + "C - Manage the Crops\n"
                + "Y - Live the Year\n"
                + "A - Show Annual Report\n"
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
        
        View AnnualReport = new AnnualReportView();
        
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
                // this is the core method of the game
                try {
                    liveTheYear();
                } catch (WheatControlException | GameControlException | PeopleControlException ce) {
                    ErrorView.display(this.getClass().getName(),ce.getMessage());
                }

                AnnualReport.displayView();
                break;
            case "A":
                AnnualReport.displayView();
                break;
            case "R":
                reportsMenu();
                break;
            case "S":
                saveGame();
                break;
            case "B":
                console.println("\nExiting Game Menu...");
                // return false if you want this view to exit and return to the view that called it.
                return false;
            default: 
                ErrorView.display(this.getClass().getName(),"\nInvalid selection, try again.");
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
    
    private void liveTheYear() throws WheatControlException, GameControlException, PeopleControlException {
        
        Game game = CityOfAaron.getCurrentGame();
        
        int tithesPercent = game.getTithesPercent();
        
        if ( tithesPercent == 0 ) {
            console.println("The current amount of bushles consacrated for tithing is 0");
            View view = new PayTithingView();
            view.displayView();
        }
        
        int acresToPlant = game.getAcresToPlant();
            
        if ( acresToPlant == 0 ) {
            console.println("You are currently planting 0 acres of land");
            View view = new PlantCropsView();
            view.displayView();
        }
        
        if ( game.getBushelsForFood() == 0 ) {
            View view = new FeedPeopleView();
            view.displayView();
        }
        
        AnnualReport report = GameControl.liveTheYear(game, game.getTithesPercent(), game.getBushelsForFood(), game.getAcresToPlant());
        
        game.setAnnualReport(report); 
    }

    private void reportsMenu(){
        View reports = new ReportsMenuView();
        reports.displayView();    
    }
     
    private void saveGame(){
        View saveGame = new SaveGameView();
        saveGame.displayView();
    }
}
