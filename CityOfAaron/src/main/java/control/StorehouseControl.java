package control;
import model.*;

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
    
    
    public static int[] sortAnimalAges(int[] age) {
        
        for (int i = 0; i < age.length -1; i++) {
            int index = i;
            for (int j = i + 1; j < age.length; j++) 
                if (age[j] < age[index])
                    index = j;
            
            int smallerNumber = age[index];
            age[index] = age[i];
            age[i] = smallerNumber;
        }
        return age;
    }
    
    public static void main(String a[]) {
        int[] age1 = {5, 10, 2, 1, 15};
        int[] age2 = sortAnimalAges(age1);
        for(int i: age2) {
            System.out.print (i);
            System.out.print (", ");
        }
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
