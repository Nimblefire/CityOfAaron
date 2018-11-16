/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.*;
import java.util.Random;
import java.util.ArrayList;

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
     * @return 
     */
    public static Game createNewGame(String playerName){
        Game newGame = new Game();
        Player newPlayer = new Player();
        newGame.setPlayer(newPlayer);
        newPlayer.setName(playerName);
        newGame.setMap(MapControl.createMap());
        newGame.setStorehouse(createStorehouse());
        newGame.setAcresOwned(990);
        newGame.setCurrentPopulation(100);
        newGame.setWheatInStorage(5000);
        newGame.setBushelsForFood(0);
        newGame.setLandPrice(GameControl.getRandomValue(17, 27));
        newGame.setAnnualReport(createAnnualReport());
            
        return newGame;
    }
        
    private static Storehouse createStorehouse(){
        
        //Creation of the Storehouse
        Storehouse newStorehouse = new Storehouse();
        
        //Declaration and population of the InventoryItems
        Author irwin = new Author();
        irwin.setName("Cristina Irwin");
        irwin.setTitle("Mrs");
        
        Author rochira = new Author();
        rochira.setName("Andrea Rochira");
        rochira.setTitle("Mr");
        
        Author daPonte = new Author();
        daPonte.setName("Stefano Da Ponte");    
        daPonte.setTitle("Mr");
        
        Animal horse = new Animal();
        horse.setName("Warhorse");
        horse.setItemType(ItemType.ANIMAL);
        horse.setCondition(Condition.GOOD);
        horse.setQuantity(6);
        horse.setAge(5);
        
        Animal cow = new Animal();
        cow.setName("Milking cow");
        cow.setItemType(ItemType.ANIMAL);
        cow.setCondition(Condition.GOOD);
        cow.setQuantity(20);
        cow.setAge(10);
        
        Provision apples = new Provision();
        apples.setItemType(ItemType.PROVISIONS);
        apples.setName("Apple");
        apples.setCondition(Condition.FAIR);
        apples.setQuantity(500);
        apples.setPerishable(true);
        
        Provision dates = new Provision();
        dates.setItemType(ItemType.PROVISIONS);
        dates.setName("Date");
        dates.setCondition(Condition.GOOD);
        dates.setQuantity(1000);
        dates.setPerishable(true);
        
        Provision woodBeams = new Provision();
        woodBeams.setItemType(ItemType.PROVISIONS);
        woodBeams.setName("Wood Beams");
        woodBeams.setCondition(Condition.GOOD);
        woodBeams.setQuantity(200);
        woodBeams.setPerishable(false);
        
        
        InventoryItem hammers = new InventoryItem();
        hammers.setItemType(ItemType.TOOL);
        hammers.setName("Hammer");
        hammers.setCondition(Condition.POOR);
        hammers.setQuantity(20);
        
        InventoryItem saws = new InventoryItem();
        saws.setItemType(ItemType.TOOL);
        saws.setName("Saw");
        saws.setCondition(Condition.GOOD);
        saws.setQuantity(30);
        
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
    
    private static AnnualReport createAnnualReport(){
        AnnualReport report = new AnnualReport();
        return report;
    }
    
    public static Game loadSavedgame(String filename) {
        Game savedGame = new Game();
        Player returningPlayer = new Player();
        savedGame.setPlayer(returningPlayer);
        returningPlayer.setName(filename);
        
        
        return savedGame;
    }
}
