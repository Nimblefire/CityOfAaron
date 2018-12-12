
package control;

import app.CityOfAaron;
import exceptions.*;

/**
 *
 * @author cristinairwin
 */
public class WheatControl {
    
    public static int calculateHarvest(int tithesOfferings, int acresPlanted) throws GameControlException,WheatControlException {
       //int RanddomNumber;
        //int low = 0;
        //int high = 0;
        //int randomTest = GameControl.getRandomValue(low, high);
        int randomNumber = 0;
        
        //If acresPlanted < 0, then RETURN message
        if(acresPlanted < 0) {
            throw new WheatControlException("The amount of acres cannot be negative\n");
        }

        //If tithesOfferings is > than 100, then RETURN message
        if(tithesOfferings > 100) {
            throw new WheatControlException("You can't pay a tithing greater than 100% of your bushels\n");
        }
        //If tithesOfferings is < 0, then RETURN message
        if(tithesOfferings < 0) {
            throw new WheatControlException("The tithing amount cannot be negative\n");
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
        CityOfAaron.getCurrentGame().setBushelsPerAcre(randomNumber);
        return calculateHarvest;
    }
    
    public static int calculateLossToRats(int randomNumber, int wheatInStorage, int tithesPercentage) throws WheatControlException, GameControlException {
        //int randomNumber = GameControl.getRandomValue(1, 100);
        int wheatEaten;
        int randomPercentage = 0;
        
        //IF randomNumber < 1 OR randomNumber > 100 THEN RETURN message
        if (randomNumber < 1 || randomNumber > 100){
            throw new GameControlException("randomNumber out of range\n");
        }
        
        //IF wheatInStorage < 0 THEN RETURN message
        if (wheatInStorage < 0){
            throw new WheatControlException("The amount of wheat in storage cannot be negative\n");
        }
        
        //IF tithesPercentage < 0 THEN RETURN message
        if (tithesPercentage < 0){
            throw new WheatControlException("The tithes percentage cannot be negative\n");
        }
    
        //IF randomNumber >= 30 THEN wheatEaten = 0
        if (randomNumber >= 30){
            wheatEaten = 0;
        }
        
        //IF randomNumber < 30 AND randomNumber >= 1 THEN
        if (randomNumber < 30 && randomNumber >= 1){
            //IF tithingPercentage < 8 THEN wheatEaten = getRandomNumber(6, 10)/100 * wheatInStorage
            if (tithesPercentage < 8){
                randomPercentage = GameControl.getRandomValue(6, 10);
            }
            
            //IF tithingPercentage >= 8 AND tithingPercentage <= 12 THEN wheatEaten = getRandomNumber(3, 7)/100 * wheatInStorage
            if (tithesPercentage >= 8 && tithesPercentage <= 12){
                randomPercentage = GameControl.getRandomValue(3, 7);
            }
            
            //IF tithingPercentage > 12 THEN wheatEaten = getRandomNumber(3, 5)/100 * wheatInStorage
            if (tithesPercentage > 12){
                randomPercentage = GameControl.getRandomValue(3, 5);
            }
        }
        return wheatEaten = randomPercentage * wheatInStorage/100;
    }
}
