/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;

/**
 *
 * @author cristinairwin
 */
public class WheatControl {
    public static int calculateHarvest(int tithesPercent, int acresPlanted) {
        
        // Calculate the amount of wheat harvested, based on the percentage 
        // of tithing paid. Assume that GameControl.getRandomNumber(low,high) 
        // is available to be called.
        int low = 1;
        int high = 6;
        //Random randomNumberTest = new Random(System.currentTimeMillis());
        //int tithingPercent = 0;
        
        int tithingPercent = GameControl.getRandomValue(low, high);
   
        
        //if acresPlanted < 0 then return -1
        if(acresPlanted < 0) {
            return -1;
        }
        //if tithingPercent < 0 OR tithingPercent > 100 then return -2
        if(tithingPercent < 0 || tithingPercent > 100) {
            return -2;
        }

        //if tithingPercent < 8 then low = 1, high = 3
        if(tithingPercent < 8) {
            low = 1;
            high = 3;
        }
        //if tithingPercent >= 8 AND tithingPercent <= 12 then low = 2, high = 4
        if(tithingPercent >= 8 && tithingPercent <= 12) {
            low = 2;
            high = 4;
        }
        
        //if tithingPercent > 12 then low = 2, high = 5
        if(tithingPercent > 12) {
            low = 2;
            high = 5;
        }

        //yield = GameControl.getRandomNumber(low, high)
        int wheatForPeople = GameControl.getRandomValue(low, high); 
        
        //return yield * acresPlanted
        return wheatForPeople * acresPlanted;
        
    }
}
