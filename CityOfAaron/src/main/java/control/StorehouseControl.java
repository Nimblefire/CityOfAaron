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
    
    public static void pickAuthorLongestName(){  
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        int maxLength = 0;
        int index = 0;
        for(Author author : authors){
           if (author.getName().length() > maxLength){
                maxLength = author.getName().length();
                index = Arrays.asList(authors).indexOf(author);
           }   
        }
        System.out.println(authors[index].getTitle().toUpperCase() + " " + authors[index].getName());
    }
    
    public static void pickAuthorByRandomIndex(int randomIndex){
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        int index = 0;
        for(Author author : authors){
            if (randomIndex == Arrays.asList(authors).indexOf(author)){
                index = randomIndex;
            }
        }
        System.out.println(authors[index].getTitle().toUpperCase() + " " + authors[index].getName());
    }
    
}
