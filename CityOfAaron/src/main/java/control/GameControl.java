/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.*;
import java.util.Random;

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
        newGame.setStorehouse(GameControl.createStorehouse());
        newGame.setAcresOwned(1000);
        newGame.setCurrentPopulation(100);
        newGame.setWheatInStorage(2000);
        newGame.setBushelsForFood(0);
            
        //LandControl.getCurrentLandPrice();
            
        return newGame;
    }
        
    public static Storehouse createStorehouse(){
        Storehouse newStorehouse = new Storehouse();
        Author irwin = new Author();
        Author rochira = new Author();
        Author daPonte = new Author();
            
        irwin.setName("Cristina Irwin");
        rochira.setName("Andrea Rochira");
        daPonte.setName("Stefano Da Ponte");
        irwin.setTitle("Mrs");
        rochira.setTitle("Mr");
        daPonte.setTitle("Mr");
            
        Author[] authorArray = {irwin, rochira, daPonte};
            
        newStorehouse.setAuthors(authorArray);
            
        return newStorehouse;
    }
    
    public static Game loadGameFromFile(String filename) {
        Game savedGame = new Game();
        
        return savedGame;
    }
}
