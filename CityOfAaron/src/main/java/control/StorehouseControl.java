package control;

import model.*;
import app.CityOfAaron;
import java.util.Arrays;
import java.util.ArrayList;

// class containing the methods for navigating the arrays and arrayLists
public class StorehouseControl {

    //created by Cristina Irwin
    public static void sortAnimalbyName() {
        ArrayList<Animal> animals = CityOfAaron.getCurrentGame().getStorehouse().getAnimals();

        for (int i = 0; i < animals.size() - 1; i++) { //size()
            for (int j = i + 1; j < animals.size(); j++) {//size()
                if (animals.get(j).getName().compareTo(animals.get(i).getName()) < 0) {
                    Animal temp = animals.get(i);
                    animals.set(i, animals.get(j));
                    animals.set(j, temp);
                }
            }
        }

    }

    public static ArrayList<Animal> filterAnimalbyCondition(String conditionString) {

        ArrayList<Animal> animals = CityOfAaron.getCurrentGame().getStorehouse().getAnimals();
        ArrayList<Animal> filteredAnimals = new ArrayList<>();
        Condition condition = Condition.valueOf(conditionString);

        for (Animal animal : animals) {
            if (animal.getCondition() == condition) {
                filteredAnimals.add(animal);

            }
        }
        return filteredAnimals;
    }

    public static void sortAnimalbyAge() {
        ArrayList<Animal> animals = CityOfAaron.getCurrentGame().getStorehouse().getAnimals();

        for (int i = 0; i < animals.size() - 1; i++) {
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(i).getAge() < (animals.get(j).getAge())) {
                    //if (animals.get(j).getAge().compareTo(animals.get(i).getAge())< 0) {
                    Animal temp = animals.get(i);
                    animals.set(i, animals.get(j));
                    animals.set(j, temp);
                }

            }
        }
    }

    // created by Andrea Rochira
    public static void pickAuthorsByTitle(String title) {
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();

        for (Author author : authors) {
            if (author.getTitle().equals(title)) {
                System.out.println(author.getTitle().toUpperCase() + " " + author.getName());
            }
        }
    }

    public static void pickAuthorLongestName() {
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        int maxLength = 0;
        int index = 0;
        for (Author author : authors) {
            if (author.getName().trim().length() > maxLength) {
                maxLength = author.getName().trim().length();
                index = Arrays.asList(authors).indexOf(author);
            }
        }
        System.out.println(authors[index].getTitle().toUpperCase() + " " + authors[index].getName());
    }

    public static void pickAuthorByRandomIndex(int randomIndex) {
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        String author = authors[randomIndex].getTitle().toUpperCase() + " " + authors[randomIndex].getName();
        System.out.println(author);
    }
    
    public static void sortAuthorsByName(){
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        String[] sortedAuth = new String[authors.length];
        int i = 0;
            for(Author author : authors){
                String authorName = author.getName();
                sortedAuth[i] = authorName;
                i++;
            }
        Arrays.sort(sortedAuth);
            for(String name : sortedAuth){
                System.out.println(name);
            }
    }
    
    // credit to Brother Anderson
    public static void sortAuthorsByNameAlgorithm(){
        Author[] authors = CityOfAaron.getCurrentGame().getStorehouse().getAuthors();
        
        for (int i=0; i < authors.length-1; i++){
        
            for (int j=i+1; j < authors.length; j++){
                
                // if author[i] > author[j], then swap them...
                if (authors[i].getName().compareTo( authors[j].getName() ) > 0){
                    Author temp = authors[i];
                    authors[i] = authors[j];
                    authors[j] = temp;
                }
            }
        }
        
        // print
        for (Author author : authors){
            System.out.println(author.getName());
        }
    }
    
}
