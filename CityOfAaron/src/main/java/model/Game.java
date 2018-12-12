/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Andrea
 */
public class Game implements Serializable {

    // attributes
    private Player thePlayer;
    private Map theMap;
    private Storehouse theStorehouse;
    private int currentPopulation;
    private int acresOwned;
    private int wheatInStorage;
    private int bushelsForFood;
    private int acresToSell;
    private int landPrice;
    private AnnualReport annualReport;
    private int tithesPercent;
    private int acresToPlant;
    private int bushelsPerAcre;

    // default constructor
    public Game() {
    }
    //simple overloaded constructor
    public Game(Player thePlayer, Map theMap, Storehouse theStorehouse) {
        this.thePlayer = thePlayer;
        this.theMap = theMap;
        this.theStorehouse = theStorehouse;
    }
    //fully overloaded constructor
    public Game(Player thePlayer, Map theMap, Storehouse theStorehouse, int currentPopulation, int acresOwned, int wheatInStorage, int bushelsForFood, int acresToSell, int landPrice, AnnualReport annualReport) {
        this.thePlayer = thePlayer;
        this.theMap = theMap;
        this.theStorehouse = theStorehouse;
        this.annualReport = annualReport;
        this.currentPopulation = currentPopulation;
        this.acresOwned = acresOwned;
        this.wheatInStorage = wheatInStorage;
        this.bushelsForFood = bushelsForFood;
        this.acresToSell = acresToSell;
        this.landPrice = landPrice;
    }

    // getters and setters methods
    public Player getPlayer() {
        return thePlayer;
    }
    
    public void setPlayer(Player thePlayer){
        this.thePlayer = thePlayer;
    }
    
    public Map getMap(){
        return theMap;
    }
    
    public void setMap(Map theMap){
        this.theMap = theMap;
    }
    
    public Storehouse getStorehouse(){
        return theStorehouse;
    }
    
    public void setStorehouse(Storehouse theStorehouse){
        this.theStorehouse = theStorehouse;
    }
    
    public int getCurrentPopulation(){
        return currentPopulation;
    }
    
    public void setCurrentPopulation(int currentPopulation){
        this.currentPopulation = currentPopulation;
    }
    
    public int getAcresOwned(){
        return acresOwned;
    }
    
    public void setAcresOwned(int acresOwned){
        this.acresOwned = acresOwned;
    }
    
    public int getWheatInStorage(){
        return wheatInStorage;
    }
    
    public void setWheatInStorage(int wheatInStorage){
        this.wheatInStorage = wheatInStorage;
    }
    
    public int getBushelsForFood(){
        return bushelsForFood;
    }
    
    public void setBushelsForFood(int bushelsForFood){
        this.bushelsForFood = bushelsForFood;
    }
    
    public int getAcresToSell(){
        return acresToSell;
    }
    
    public void setAcresToSell(int acresToSell){
        this.acresToSell = acresToSell;
    }
    
    public int getLandPrice(){
        return landPrice;
    }
    
    public void setLandPrice(int landPrice){
        this.landPrice = landPrice;
    }
    
    public AnnualReport getAnnualReport(){
        return annualReport;
    }
    
    public void setAnnualReport(AnnualReport annualReport){
        this.annualReport = annualReport;
    }

    public int getTithesPercent() {
        return tithesPercent;
    }

    public void setTithesPercent(int tithesPercent) {
        this.tithesPercent = tithesPercent;
    }

    public int getAcresToPlant() {
        return acresToPlant;
    }

    public void setAcresToPlant(int acresToPlant) {
        this.acresToPlant = acresToPlant;
    }

    public int getBushelsPerAcre() {
        return bushelsPerAcre;
    }

    public void setBushelsPerAcre(int bushelsPerAcre) {
        this.bushelsPerAcre = bushelsPerAcre;
    }
    
    @Override
        public String toString() {
        return "Game{" + "thePlayer=" + thePlayer 
                       + ", theMap=" + theMap 
                       + ", theStorehouse=" + theStorehouse 
                       + ", currentPopulation=" + currentPopulation 
                       + ", acresOwned=" + acresOwned 
                       + ", wheatInStorage=" + wheatInStorage + '}';
        
        
        
    }
    
    
    
}
