/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Team Irwin - DaPonte - Rochira
 */
public class PeopleControl {
    
    public static int calculateMortality(int wheatForPeople, int curPop) {
        // Calculate the number of people who are not fed the amount required to
        // sustain life (20 bushels per person).
        
        //bushels per person is a local constant value
        final int BUSHELS_PER_PERSON = 20;
        //local variable (return value) 
        int deaths = 0;
  
           
        //IF wheatForPeople < 0 THEN RETURN -1
        if(wheatForPeople < 0) { 
            return -1;
        }
        //IF curPop <= 0 THEN RETURN -2
        if(curPop <= 0) { 
            return -2;
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
}
