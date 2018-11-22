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
    public static void pickAuthorsByTitle(String title){  
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        
        for(Author author : authors){
            if (author.getTitle().equals(title)) {
            System.out.println(author.getTitle().toUpperCase() + " " + author.getName());
            }
        }
    }
    
    /**
    public static void pickAuthorLongestName(){  
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        int maxLength = 0;
        Author authLongestName;
        for(Author author : authors){
           if (author.toString().length() > maxLength){
                maxLength = author.toString().length();
                authLongestName.toString() = author[maxLength].getTitle().toUpperCase() + " " + author[maxLength].getName(); 
           }   
           System.out.println(authorLongestName);
        }
    }
    */
}
