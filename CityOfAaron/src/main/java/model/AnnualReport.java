
package model;

import java.io.Serializable;

public class AnnualReport implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int year;
    private int endingWheatInStorage;
    private int endingPopulation;
    private int endingAcresOwned;
    
    private int bushelsPerAcre;
    private int bushelsHarvested;
    private int tithingAmount;
    private int lostToRats;
    private int peopleStarved;
    private int peopleMovedIn;
    
    public AnnualReport(){
    }
    
    public AnnualReport(int year, int endingWheatInStorage, int endingPopulation, int endingAcresOwned, int bushelsPerAcre, int bushelsHarvested, int tithingAmount, int lostToRats, int peopleStarved, int peopleMovedIn){
        this.year = year;
        this.endingWheatInStorage = endingWheatInStorage;
        this.endingPopulation = endingPopulation;
        this.endingAcresOwned = endingAcresOwned;
        this.bushelsPerAcre = bushelsPerAcre;
        this.bushelsHarvested = bushelsHarvested;
        this.tithingAmount = tithingAmount;
        this.lostToRats = lostToRats;
        this.peopleStarved = peopleStarved;
        this.peopleMovedIn = peopleMovedIn;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public int getEndingWheatInStorage() {
        return endingWheatInStorage;
    }
    
    public void setEndingWheatInStorage(int endingWheatInStorage) {
        this.endingWheatInStorage = endingWheatInStorage;
    }
    
    public int getEndingPopulation() {
        return endingPopulation;
    }
    
    public void setEndingPopulation(int endingPopulation) {
        this.endingPopulation = endingPopulation;
    }
    
    public int getEndingAcresOwned() {
        return endingAcresOwned;
    }
    
    public void setEndingAcresOwned(int endingAcresOwned) {
        this.endingAcresOwned = endingAcresOwned;
    }
   
    public int getBushelsPerAcre(){
        return bushelsPerAcre;
    }
    
    public void setBushelsPerAcre(int bushelsPerAcre){
        this.bushelsPerAcre = bushelsPerAcre;
    }
    
   public int getBushelsHarvested() {
       return bushelsHarvested;
   }
   
   public void setBushelsHarvested(int bushelsHarvested){
       this.bushelsHarvested = bushelsHarvested;
   }
   
   public int getTithingAmount() {
       return tithingAmount;
   }
   
   public void setTithingAmount(int tithingAmount) {
       this.tithingAmount = tithingAmount;
   }
   
   public int getLostToRats() {
       return lostToRats;
   }
   
   public void setLostToRats(int lostToRats) {
       this.lostToRats = lostToRats;
   }
   
   public int getPeopleStarved() {
       return peopleStarved;
   }
   
   public void setPeopleStarved(int peopleStarved) {
       this.peopleStarved = peopleStarved;
   }
   
   public int getPeopleMovedIn() {
       return peopleMovedIn;
   }
   
   public void setPeopleMovedIn(int peopleMovedIn) {
       this.peopleMovedIn = peopleMovedIn;
   }
}
   


