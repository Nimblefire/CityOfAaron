package control;

import app.CityOfAaron;
import model.*;
import java.util.Arrays;

// class containing the methods for navigating the arrays and arrayLists
public class StorehouseControl {
    
    // created by ...
    public static String searchAnimal(String animalName){
        String name = null;
        return name;
    }
    
    // created by Andrea Rochira
    public static String sortAuthors(int val){  
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        
        
        
        Author authorSelected = authors[val];
        String author = authors[val].getTitle() + " " + authors[val].getName();
        return author;
    }
    
    
    
}
