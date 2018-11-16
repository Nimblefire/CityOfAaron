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
    private int landPrice;
    
    // default constructor
    public Game() {
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
    
    public int getLandPrice(){
        return landPrice;
    }
    
    public void setLandPrice(int landPrice){
        this.landPrice = landPrice;
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
