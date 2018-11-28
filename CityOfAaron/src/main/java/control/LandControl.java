/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.GameControlException;

/**
 *
 * @author dapon
 */
public class LandControl {
    
    //TODO Figure out how to implement it
    public static int createLandPrice() throws GameControlException{
        int randomValue = GameControl.getRandomValue(17, 27);
        return randomValue;
    }
}
