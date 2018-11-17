package view;

import app.CityOfAaron;

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
        return "This is the report for this year:\n";
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
        if ((CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved() >= (CityOfAaron.getCurrentGame().getCurrentPopulation() * 0.5))){
            endGame.displayView();
        }
        else if (10 < CityOfAaron.getCurrentGame().getAnnualReport().getYear()) {
            endGame.displayView();
        }
        
        return false;
    }
    
    private void printReport(){

        // print Year
        System.out.println("\nYear number: " + CityOfAaron.getCurrentGame().getAnnualReport().getYear());
        // print people starved
        System.out.println("\nPeople starved: " + CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved());
        if (CityOfAaron.getCurrentGame().getAnnualReport().getYear() >= 1 && CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved() == 0){
            System.out.println("\nWell done, oh wise leader!");}
        // print new entries
        System.out.println("\nPeople immigrated into the city: " + CityOfAaron.getCurrentGame().getAnnualReport().getPeopleMovedIn());
        // print current population
        System.out.println("\nNew population: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingPopulation());
        // print acres owned
        System.out.println("\nAcres owned: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingAcresOwned());
        // print bushels harvested
        System.out.println("\nBushels harvested: " + CityOfAaron.getCurrentGame().getAnnualReport().getBushelsHarvested());
        // print tithing & offering
        System.out.println("\nTithing and offerings: " + CityOfAaron.getCurrentGame().getAnnualReport().getTithingAmount() + " bushels");
        if (CityOfAaron.getCurrentGame().getAnnualReport().getTithingAmount() > CityOfAaron.getCurrentGame().getWheatInStorage()*12){
            System.out.println("\nYou offered a lot to the Lord this year, you will surely be blessed for it!");}
        // print bushels eaten by rats
        System.out.println("\nWheat eaten by rats: " + CityOfAaron.getCurrentGame().getAnnualReport().getLostToRats() + " bushels");
        // print wheat left in storage
        System.out.println("\nWheat now in store: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingWheatInStorage() + " bushels"); 
    }
}