
package control;
import model.*;

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
    
    public static void main(String a[]) {
        int[] age1 = {5, 10, 2, 1, 15};
        int[] age2 = sortAnimalAges(age1);
        for(int i: age2) {
            System.out.print (i);
            System.out.print (", ");
        }
    }
}
