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
public class Author implements Serializable {
    
    // attributes
    private String name;
    private String title;
    
    // default empty constructor for Java Bean class
    public Author() {
    }
    
    // getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    // auxiliary methods
    @Override
    public String toString() {
        return "Author{" + "name=" + name 
                         + ", title=" + title + '}';
    }
    
}
