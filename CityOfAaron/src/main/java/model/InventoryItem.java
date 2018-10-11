/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author dapon
 */
public class InventoryItem implements Serializable{
    
    //attributes
    private String name;
    private ItemType itemType;
    private int quantity;
    private Condition condition;
    
    //default constructor
    public InventoryItem(){
 
    }
    
    //getter and setter
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        //if 
        this.name = name;
    }
    
    
    public ItemType getItemType(){
        return itemType;
    }
    
    public void setItemType(ItemType itemType){
        this.itemType = itemType;
    }
    
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    
    public Condition getCondition(){
        return condition;
    }
    
    public void setCondition(Condition condition){
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "InventoryItem{" 
                + "\n name=" + name 
                + "\n itemType=" + itemType 
                + "\n quantity=" + quantity 
                + "\n condition=" + condition 
                + '}';
    }
    
}
