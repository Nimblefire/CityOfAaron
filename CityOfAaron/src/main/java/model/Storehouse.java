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
 * @author Andrea
 */
public class Storehouse implements Serializable {
    
    // attributes
    private ArrayList<Author> authors = new ArrayList<Author>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<InventoryItem> tools = new ArrayList<InventoryItem>();
    private ArrayList<Provision> provisions = new ArrayList<Provision>();
    
    // default empty constructor for Java Bean 
    public Storehouse() {
    }
    
    // getters and setters
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
    
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
    public void setAnimals(ArrayList<Animal> animals){
        this.animals = animals;
    }
    
    public ArrayList<InventoryItem> getTools() {
        return tools;
    }
    
    public void setTools(ArrayList<InventoryItem> tools){
        this.tools = tools;
    }
    
    public ArrayList<Provision> getProvisions() {
        return provisions;
    }
    
    public void setProvisions(ArrayList<Provision> provisions){
        this.provisions = provisions;
    }
     
    // auxiliary methods
    @Override
    public String toString() {
        return "Storehouse{" + "authors=" + authors 
                             + ", animals=" + animals 
                             + ", tools=" + tools 
                             + ", provisions=" + provisions 
                             + '}';
    }
    
    
}
