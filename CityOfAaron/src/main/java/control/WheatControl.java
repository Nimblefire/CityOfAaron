
package control;

import java.util.Random;

/**
 *
 * @author cristinairwin
 */
public class WheatControl {
    
    public static int calculateHarvest(int tithesOfferings, int acresPlanted) {
       //int RanddomNumber;
        //int low = 0;
        //int high = 0;
        //int randomTest = GameControl.getRandomValue(low, high);
        int randomNumber = 0;
        //Is this supposed to be setRandValue???

        
        //If acresPlanted < 0, then RETURN -1.
        if(acresPlanted < 0) {
            return -1;
        }

        //If tithesOfferings is > than 100, then RETURN -2.
        if(tithesOfferings > 100) {
            return -2;
        }
        //If tithesOfferings is < 0, then RETURN -2.
        if(tithesOfferings < 0) {
            return -2;
        }
       
        
        //If tithesOfferings is > 12, then randomNumber between 2 and 5.
        if(tithesOfferings > 12) {
            //GameControl.getRandomValue(acresPlanted, acresPlanted);
            randomNumber = GameControl.getRandomValue(2, 5);
        }

        //If tithesOfferings between 12 and 8 (<12 and >8), then random number between 2 and 4.
        if(tithesOfferings >= 8 && tithesOfferings <= 12) {
           randomNumber = GameControl.getRandomValue(2, 4);
            
        }

        //If tithesOfferings is < 8, then randomNumber between 1 and 3.
        if(tithesOfferings < 8) {
          randomNumber = GameControl.getRandomValue(1, 3);
        }

        
        //calculatHarvest = acresPlanted * RandomNumber
        int calculateHarvest = acresPlanted * randomNumber;
        
        //RETURN calculateHarvest (store calculateHarvest)
        return calculateHarvest;
    }
}
