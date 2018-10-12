/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author cristinairwin
 */
public class Location implements Serializable {
    //attributes
    private String name;
    private String description;
    private String mapSymbol;
    //private String[] gameTips;
    private String gameTips;
    //private ArrayList<String>gameTips = new ArrayList<>();
    //
    
    //default constructor
    public Location() {
    }
    
    //getters and setters
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getMapSymbol() {
        return mapSymbol;
    }
    
    public void setMapSymbol(String symbol) {
        this.mapSymbol = symbol;
    }
    
    public String getGameTips() {
    //public String[] getGameTips() {
        return gameTips;
    }
    
    //public String[]getGameTips() {
        //return}
    
    public void setGametips (String gameTips){
    //public void setGameTips(String[] tips) {
      this.gameTips = gameTips;
    }
    
    @Override
    public String toString() {
        return "Location{"
                + " name =" + name
                + ", description =" + description
                + ", Map symbol =" + mapSymbol
                + ", Game Tip =" + gameTips
                + '}';
    }
}