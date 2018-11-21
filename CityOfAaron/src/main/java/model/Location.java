/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import control.GameControl;
import java.io.Serializable;


/**
 *
 * @author cristinairwin
 */
public class Location implements Serializable {
    //attributes
    private String name;
    private String description;
    private String mapSymbol;
    private String[] gameTips;
    //private String gameTips;
    //private ArrayList<String>gameTips = new ArrayList<>();
    //
    
    //default constructor
    public Location() {
    }
    
    // overloaded constructor
    public Location(String name, String description, String mapSymbol, String[] gameTips) {
        this.name = name;
        this.description = description;
        this.mapSymbol = mapSymbol;
        this.gameTips = gameTips;
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
    
    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }
    
    public String[] getGameTips() {
        return gameTips;
    }
   
    public void setGameTips(String[] gameTips) {
      this.gameTips = gameTips;
    }
    
    @Override
    public String toString() {
        return "Location{"
                + "\n name =" + name
                + "\n description =" + description
                + "\n Map symbol =" + mapSymbol
                + "\n Game Tip =" + gameTips[GameControl.getRandomValue(0, 7)]
                + "}";
    }
}