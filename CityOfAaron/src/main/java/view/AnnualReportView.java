package view;

import app.CityOfAaron;
import control.GameControl;

/**
 *
 * @author dapon
 */
public class AnnualReportView extends ViewBase{
    /**
     * Constructor
     */
    public AnnualReportView(){
    }
    
    @Override
    public String getMessage(){
        return "This is the report for last year:";
    }
    
    @Override
    protected String[] getInputs(){
        return null;
    }
    
    // initialize EndGameView
    View endGame = new EndGameView();
    
    @Override
    protected boolean doAction(String[] inputs){
        
        printReport();
        
        pause(3000);
        
        // selection to evaluate if calling for the EndGameView
        if (GameControl.gameShouldEnd(CityOfAaron.getCurrentGame(), CityOfAaron.getCurrentGame().getCurrentPopulation())){
            endGame.displayView();
        }
        
        return false;
    }
    
    private void printReport(){

        // print Year
        console.println("\nYear number: " + CityOfAaron.getCurrentGame().getAnnualReport().getYear());
        // print people starved
        console.println("\nPeople starved: " + CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved());
        if (CityOfAaron.getCurrentGame().getAnnualReport().getYear() > 1 && CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved() == 0){
            console.println("Well done, oh wise leader!");}
        // print new entries
        console.println("\nPeople immigrated into the city: " + CityOfAaron.getCurrentGame().getAnnualReport().getPeopleMovedIn());
        // print current population
        console.println("\nNew population: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingPopulation());
        // print acres owned
        console.println("\nAcres owned: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingAcresOwned());
        //print bushels per acre
        console.println("\nBushels per acre: " + CityOfAaron.getCurrentGame().getAnnualReport().getBushelsPerAcre());
        // print bushels harvested
        console.println("\nBushels harvested: " + CityOfAaron.getCurrentGame().getAnnualReport().getBushelsHarvested());
        // print tithing & offering
        console.println("\nTithing and offerings: " + CityOfAaron.getCurrentGame().getAnnualReport().getTithingAmount() + " bushels");
        if (CityOfAaron.getCurrentGame().getAnnualReport().getTithingAmount() > CityOfAaron.getCurrentGame().getWheatInStorage()*12){
            console.println("You offered a lot to the Lord this year, you will surely be blessed for it!");}
        // print bushels eaten by rats
        console.println("\nWheat eaten by rats: " + CityOfAaron.getCurrentGame().getAnnualReport().getLostToRats() + " bushels");
        // print wheat left in storage
        console.println("\nWheat now in store: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingWheatInStorage() + " bushels"); 
    }
}