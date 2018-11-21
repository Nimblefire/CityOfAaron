/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import app.CityOfAaron;
import model.*;
import java.util.Random;
import java.util.ArrayList;
import view.EndGameView;
import view.View;

/**
 *
 * @author Andrea Rochira
 */

public class GameControl {
    
    private static Random randValue = new Random();
    
    /** Hint from Brother Anderson
     *  Protected setter for tests to inject a mock random number
     * @param random
     */ 
    protected static void setRandValue(Random random){
        randValue = random;
    }
    
    public static int getRandomValue(int lowValue, int highValue){
    
        if( lowValue < 0 || highValue < 0 ) {
            return -1;
        } 

        if( highValue <= lowValue ){
            return -2;
        }

        if ( highValue == Integer.MAX_VALUE){
            return -3;
        }

        return randValue.nextInt(highValue + 1 - lowValue) + lowValue;
    } 
    
    /**
     * Process the current year's results and update the Game object.
     * 
     * @param game The current Game object (pass by reference)
     * @param tithesPercent The percentage of tithing selected for the year
     * @param bushelsForFood The number of bushels of wheat allocated as food for the year
     * @param acresToPlant The number of acres to be used for planing
     * 
     * @return The year's Annual Report data
     */
    
    /*public static AnnualReport liveTheYear(
           Game game, int tithesPercent, int bushelsForFood, int acresToPlant) {
        
       if(game == null || tithesPercent < 0 || tithesPercent > 100 || bushelsForFood < 0 || acresToPlant < 0){
            //return null;
        }
        
        AnnualReport report = new AnnualReport();
        report.setLandPrice(LandControl.getCurrentLandPrice());
        
        int totalWheat = game.getWheatInStorage();
        
        int harvested = WheatControl.calculateHarvest(tithesPercent, acresToPlant);
        int tithingAmount = (int)(double)((tithesPercent/100.0) * harvested);
        int lostToRats = WheatControl.calculateLossToRats(wheatIn, tithesPercent);
    
        int peopleStarved = PeopleControl.calculateMortality(bushelsForFood, game.getCurrentPopulation());
        int peopleMovedIn = PeopleControl.calculateNewMoveIns(game.getCurrentPopulation());
    
        totalWheat = totalWheat + harvested - tithingAmount - lossToRats;
        game.setWheatInStorage(totalWheat);
        game.setCurrentPopulation(game.getCurrentPopulation() - peopleStarved + peopleMovedIn);
    
        report.setEndingWheatInStorage(game.getWheatInStorage());
        report.setEndingPopulation(game.getCurrentPopulation());
        report.setEndingAcresOwned(game.getAcresOwned());
        return report;
    }*/
    
    /**
     * 
     * @param playerName
     * @return newGame
     */
    public static Game createNewGame(String playerName){
        //Create new game
        Game newGame = new Game();
        
        //Create new player
        Player newPlayer = new Player();
        
        //Assign a name to player and player to the game
        newGame.setPlayer(newPlayer);
        newPlayer.setName(playerName);
        
        //Create the Map and assign it to the game
        newGame.setMap(MapControl.createMap());
        
        //Create he Storehouse and assign it to the game
        newGame.setStorehouse(createStorehouse());
        
        //Set the acres at the beginning of the game
        newGame.setAcresOwned(990);
        
        //Set the population at the beginning of the game
        newGame.setCurrentPopulation(100);
        
        //Set the wheat in store at the beginning of the game
        newGame.setWheatInStorage(5000);
        
        //Set the Bushels set aside as food (Not really needed)
        newGame.setBushelsForFood(0);
        
        //Set the price per acre for the first year
        newGame.setLandPrice(getRandomValue(17, 27));
        
        //Create the annual report object and assign it to the game
        newGame.setAnnualReport(createAnnualReport(newGame));
            
        return newGame;
    }
        
    private static Storehouse createStorehouse(){
        
        //Creation of the Storehouse
        Storehouse newStorehouse = new Storehouse();
        
        //Declaration and population of the InventoryItems
        
        // Authors
        Author irwin = new Author("Cristina Irwin","Mrs");
        Author rochira = new Author("Andrea Rochira","Mr");        
        Author daPonte = new Author("Stefano Da Ponte","Mr");

        // Animals
        Animal horse = new Animal("Warhorse",ItemType.ANIMAL,Condition.GOOD,6,5);
        Animal cow = new Animal("Milking cow",ItemType.ANIMAL,Condition.GOOD,20,10);
        
        // Provisions
        Provision apples = new Provision("Apple",ItemType.PROVISIONS,Condition.FAIR,500,true);
        Provision dates = new Provision("Date",ItemType.PROVISIONS,Condition.GOOD,1000,true);
        Provision woodBeams = new Provision("Wood Beams",ItemType.PROVISIONS,Condition.GOOD,200,false);
        
        // Tools
        InventoryItem hammers = new InventoryItem("Hammer",ItemType.TOOL,Condition.POOR,20);
        InventoryItem saws = new InventoryItem("Saw",ItemType.TOOL,Condition.GOOD,30);
        
        //Create the Arrays and assign the values
        Author[] authorArray = {irwin, rochira, daPonte};
        
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(horse);
        animals.add(cow);
        
        ArrayList<Provision> provisions = new ArrayList<>();
        provisions.add(apples);
        provisions.add(dates);
        provisions.add(woodBeams);
        
        
        ArrayList<InventoryItem> tools = new ArrayList<>();
        tools.add(hammers);
        tools.add(saws);
        
        
        //Assign the Arrays to the Storehouse
        newStorehouse.setAuthors(authorArray);
        newStorehouse.setAnimals(animals);
        newStorehouse.setProvisions(provisions);
        newStorehouse.setTools(tools);
        
        return newStorehouse;
    }
    
    //Later we could establish default values for the beginning of the first year
    private static AnnualReport createAnnualReport(Game game){
        AnnualReport report = new AnnualReport();
        report.setBushelsHarvested(3000);
        report.setBushelsPerAcre(3);
        report.setEndingAcresOwned(game.getAcresOwned());
        report.setEndingPopulation(game.getCurrentPopulation());
        report.setEndingWheatInStorage(game.getWheatInStorage());
        report.setLostToRats(0);
        report.setPeopleMovedIn(5);
        report.setPeopleStarved(0);
        report.setTithingAmount(300);
        report.setYear(1);
        return report;
    }
    
    public static Game loadSavedgame(String filename) {
        Game savedGame = new Game();
        Player returningPlayer = new Player();
        savedGame.setPlayer(returningPlayer);
        returningPlayer.setName(filename);
        
        
        return savedGame;
    }
    
    //TODO Complete the method with the different input checks
    public static boolean gameShouldEnd(Game game, int previousPopulation){
        if (game.getAnnualReport().getPeopleStarved() >= previousPopulation * 0.5 
                || game.getAnnualReport().getYear() > 10){
            return true;
        }
        return false;
    }
}
