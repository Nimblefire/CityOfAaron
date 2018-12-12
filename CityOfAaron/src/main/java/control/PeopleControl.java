/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.*;
import exceptions.*;

/**
 *
 * @author Team Irwin - DaPonte - Rochira
 */
public class PeopleControl {
    
    public static int calculateMortality(int wheatForPeople, int curPop) throws PeopleControlException {
        // Calculate the number of people who are not fed the amount required to
        // sustain life (20 bushels per person).
        
        //bushels per person is a local constant value
        final int BUSHELS_PER_PERSON = 20;
        //local variable (return value) 
        int deaths = 0;
  
           
        //IF wheatForPeople < 0 THEN RETURN message
        if(wheatForPeople < 0) { 
            throw new PeopleControlException("The amount of wheat for people cannot be less than 0.\n");
        //return -1;
        }
        //IF curPop <= 0 THEN RETURN message
        if(curPop <= 0) { 
            throw new PeopleControlException("Current Population should be greater than 0.\n");
            //return -2;
        }

        //IF wheatForPeople > (curPop * 20) THEN deaths = 0
        
        if(wheatForPeople > (curPop * BUSHELS_PER_PERSON)) {
            deaths = 0;
        }
        
        //IF wheatForPeople <= (curPop * 20) THEN deaths = curPop - FLOOR(wheatForPeople / 20
        if(wheatForPeople <= (curPop * BUSHELS_PER_PERSON)) {
            deaths = curPop - (int)Math.floor(wheatForPeople / BUSHELS_PER_PERSON);
             
        }
        return deaths;
    }
    
    public static int calculateNewMoveIns(int curPop) throws PeopleControlException, GameControlException {
        
        int randomValue = GameControl.getRandomValue(1,5);
        
        int peopleMoved = curPop * randomValue / 100;
        
        return peopleMoved;
    }
    
}
