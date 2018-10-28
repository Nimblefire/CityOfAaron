
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
    
    public static int calculateLossToRats(int randomNumber, int wheatInStorage, int tithesPercentage){
        //int randomNumber = GameControl.getRandomValue(1, 100);
        int wheatEaten;
        int randomPercentage = 0;
        
        //IF randomNumber < 1 OR randomNumber > 100 THEN RETURN -1
        if (randomNumber < 1 || randomNumber > 100){
            return -1;
        }
        
        //IF wheatInStorage < 0 THEN RETURN -2
        if (wheatInStorage < 0){
            return -2;
        }
        
        //IF tithesPercentage < 0 THEN RETURN -3
        if (tithesPercentage < 0){
            return -3;
        }
    
        //IF randomNumber >= 30 THEN wheatEaten = 0
        if (randomNumber >= 30){
            wheatEaten = 0;
        }
        
        //IF randomNumber < 30 AND randomNumber >= 1 THEN
        if (randomNumber < 30 && randomNumber >= 1){
            //IF tithingPercentage < 8 THEN wheatEaten = getRandomNumber(6, 10)/100 * wheatInStorage
            if (tithesPercentage < 8){
                //randomPercentage = GameControl.getRandomValue(6, 10);
                randomPercentage = 9;
            }
            
            //IF tithingPercentage >= 8 AND tithingPercentage <= 12 THEN wheatEaten = getRandomNumber(3, 7)/100 * wheatInStorage
            if (tithesPercentage >= 8 && tithesPercentage <= 12){
                //randomPercentage = GameControl.getRandomValue(3, 7);
                randomPercentage = 7;
            }
            
            //IF tithingPercentage > 12 THEN wheatEaten = getRandomNumber(3, 5)/100 * wheatInStorage
            if (tithesPercentage > 12){
                //randomPercentage = GameControl.getRandomValue(3, 5);
                randomPercentage = 4;
            }
        }
        return wheatEaten = randomPercentage * wheatInStorage/100;
    }
}
