/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import app.CityOfAaron;
import model.*;
import exceptions.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public static int getRandomValue(int lowValue, int highValue) throws GameControlException {
        // if (true){
        //    throw new RuntimeException("Nasty error");
        //}
        if( lowValue < 0 || highValue < 0 ) {
            throw new GameControlException("Function getRandomValue: the lower value and/or the higher value provided cannot be negative");
        } 

        if( highValue <= lowValue ){
            throw new GameControlException("Function getRandomValue: the higher value cannot be smaller or equal to the lower value");
        }

        if ( highValue == Integer.MAX_VALUE){
            throw new GameControlException("Function getRandomValue: the higher value can't be equal to 2.147.483.647");
        }
        
        return randValue.nextInt(highValue + 1 - lowValue) + lowValue;
    } 
    
    /**
     * 
     * @param playerName
     * @return newGame
     * @throws GameControlException
     */
    public static Game createNewGame(String playerName) throws GameControlException {
        //Create new game
        Game newGame = new Game(new Player(playerName), MapControl.createMap(), createStorehouse());
        
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
    
    public static AnnualReport liveTheYear(
           Game game, int tithesPercent, int bushelsForFood, int acresToPlant) throws GameControlException, WheatControlException, PeopleControlException {
        
        if(game == null || tithesPercent < 0 || tithesPercent > 100 || bushelsForFood < 0 || acresToPlant < 0){
            //return null;
        }
        
        AnnualReport report = game.getAnnualReport();
        game.setLandPrice(LandControl.createLandPrice());
        
        int totalWheat = game.getWheatInStorage();
        
        int harvested = WheatControl.calculateHarvest(tithesPercent, acresToPlant);
        int tithingAmount = (int)((tithesPercent/100.0) * harvested);
        int lostToRats = WheatControl.calculateLossToRats(getRandomValue(1,100), totalWheat, tithesPercent);
    
        int peopleStarved = PeopleControl.calculateMortality(bushelsForFood, game.getCurrentPopulation());
        int peopleMovedIn = PeopleControl.calculateNewMoveIns(game.getCurrentPopulation());
    
        totalWheat = totalWheat + harvested - tithingAmount - lostToRats;
        game.setWheatInStorage(totalWheat);
        game.setCurrentPopulation(game.getCurrentPopulation() - peopleStarved + peopleMovedIn);
    
        report.setEndingWheatInStorage(game.getWheatInStorage());
        report.setEndingPopulation(game.getCurrentPopulation());
        report.setEndingAcresOwned(game.getAcresOwned());
        report.setYear(report.getYear()+1);
        game.setTithesPercent(0);
        return report;
    }
        
    private static Storehouse createStorehouse(){
        //Declaration and population of the InventoryItems
        //Create the Arrays and assign the values
        Author[] authorArray = {new Author("Cristina Irwin","Mrs")
                               ,new Author("Andrea Rochira","Mr")
                               ,new Author("Stefano Da Ponte","Mr")};
                                    
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Warhorse",ItemType.ANIMAL,Condition.GOOD,6,5));
        animals.add(new Animal("Milking cow",ItemType.ANIMAL,Condition.GOOD,20,10));
        animals.add(new Animal("Goat", ItemType.ANIMAL,Condition.GOOD,100,2));
        animals.add(new Animal("Chicken", ItemType.ANIMAL,Condition.FAIR,200,1));
        animals.add(new Animal("Working horse", ItemType.ANIMAL,Condition.POOR, 50, 15));
        
        ArrayList<Provision> provisions = new ArrayList<>();
        provisions.add(new Provision("Apple",ItemType.PROVISIONS,Condition.FAIR,500,true));
        provisions.add(new Provision("Date",ItemType.PROVISIONS,Condition.GOOD,1000,true));
        provisions.add(new Provision("Wood Beams",ItemType.PROVISIONS,Condition.GOOD,200,false));
        
        
        ArrayList<InventoryItem> tools = new ArrayList<>();
        tools.add(new InventoryItem("Hammer",ItemType.TOOL,Condition.POOR,20));
        tools.add(new InventoryItem("Saw",ItemType.TOOL,Condition.GOOD,30));
        tools.add(new InventoryItem("Axe", ItemType.TOOL,Condition.FAIR,35));
        
        //Creation of the Storehouse
        Storehouse newStorehouse = new Storehouse(authorArray, animals, tools, provisions);
        
        return newStorehouse;
    }
    
    //Later we could establish default values for the beginning of the first year
    private static AnnualReport createAnnualReport(Game game){
        AnnualReport report = new AnnualReport(1, game.getWheatInStorage(), game.getCurrentPopulation(), game.getAcresOwned(), 3, 3000, 300, 0, 0, 5);
       
        return report;
    }
    
    //TODO Complete the method with the different input checks
    public static boolean gameShouldEnd(Game game, int previousPopulation){
        if (game.getAnnualReport().getPeopleStarved() >= previousPopulation * 0.5 
                || game.getAnnualReport().getYear() > 10){
            return true;
        }
        return false;
    }
    
    // Save Game Method
    public static boolean saveGame(Game game, String fileName) throws GameControlException, IOException {
        
        if ( game == null || (fileName == null || fileName.length() < 1 )) {
            throw new GameControlException("The game object OR the file path is null");
        }
        
        String newFilePath = /*CityOfAaron.getDefaultPath() +*/ fileName + ".dat";
        
        try (ObjectOutputStream objectStream =
            new ObjectOutputStream(new FileOutputStream(newFilePath))) {

            objectStream.writeObject(game);

        } catch (IOException exception) {
            throw exception;
        }
        
        return true;
    }
    
    // Load saved game
    public static boolean getGame(String fileName) throws GameControlException, IOException {
        
        if ( fileName == null || fileName.length() < 1 ) {
            throw new GameControlException("The file path is null");
        } 
        
        String newFilePath = /*CityOfAaron.getDefaultPath() +*/ fileName + ".dat";
        
        try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(newFilePath))) {

            Game game = (Game)objectStream.readObject();
            
            CityOfAaron.setCurrentGame(game);

        } catch (ClassNotFoundException exception) {
               
            exception.getMessage();
            return false;
            
        }  
        return true;
    }  
}
