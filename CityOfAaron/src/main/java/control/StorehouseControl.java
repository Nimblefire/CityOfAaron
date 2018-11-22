/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author dapon
 */
public class StorehouseControl {
    
    
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
}
