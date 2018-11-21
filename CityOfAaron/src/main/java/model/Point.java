/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;

/**
 *
 * @author cristinairwin
 */
public class Point implements Serializable{
    //attributes
    private int row;
    private int column;
    
    //default constructor
    
    public Point() {
    }
    //overloaded constructor
    public Point(int row, int column){
        this.row = row;
        this.column = column;
    }
    
    //getters and setters
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public void setColumn(int column) {
        this.column =column;
    }
    
    @Override
    public String toString() {
        return "Point{"
                + " row =" + row
                + "\n column =" + column
                + '}';
    }
}
