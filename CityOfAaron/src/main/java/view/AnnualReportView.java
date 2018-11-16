/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.CityOfAaron;

/**
 *
 * @author dapon
 */
public class AnnualReportView extends ViewBase{
    /**
     * Contructor
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
    
    @Override
    protected boolean doAction(String[] inputs){
        printYear();
        printStarved();
        printNewComers();
        printPopulation();
        printAcres();
        printOfferings();
        printEaten();
        printWheatInStore();
        pause(3000);
        if ((CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved() >= CityOfAaron.getCurrentGame().getCurrentPopulation()) 
                ||  (10 <= CityOfAaron.getCurrentGame().getAnnualReport().getYear())){
            View endGame = new EndGameView();
            endGame.displayView();
        }
        
        return false;
    }
    
    
    
    
    private void printYear(){
        System.out.println("Year number: " + CityOfAaron.getCurrentGame().getAnnualReport().getYear());
    }
    
    private void printStarved(){
        System.out.println("People starved: " + CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved());
        if (CityOfAaron.getCurrentGame().getAnnualReport().getPeopleStarved() == 0){
            System.out.println("Well done, oh wise leader!");
        }
    }
    
    private void printNewComers(){
        System.out.println("People immigrated into the city: " + CityOfAaron.getCurrentGame().getAnnualReport().getPeopleMovedIn());
    }
    
    private void printPopulation(){
        System.out.println("New population: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingPopulation());
    }
    
    private void printAcres(){
        System.out.println("Acres owned: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingAcresOwned());
    }
    
    private void printHarvest(){
        System.out.println("Bushels harvested: " + CityOfAaron.getCurrentGame().getAnnualReport().getBushelsHarvested());
    }
    
    private void printOfferings(){
        System.out.println("Tithing and offerings: " + CityOfAaron.getCurrentGame().getAnnualReport().getTithingAmount() + " bushels");
        if (CityOfAaron.getCurrentGame().getAnnualReport().getTithingAmount() > CityOfAaron.getCurrentGame().getWheatInStorage()*12){
            System.out.println("You offered a lot to the Lord this year, you will surely be blessed for it!");
        }
    }
    
    private void printEaten(){
        System.out.println("Wheat eaten by rats: " + CityOfAaron.getCurrentGame().getAnnualReport().getLostToRats() + " bushels");
    }
    
    private void printWheatInStore(){
        System.out.println("Wheat now in store: " + CityOfAaron.getCurrentGame().getAnnualReport().getEndingWheatInStorage() + " bushels");
    }
}
