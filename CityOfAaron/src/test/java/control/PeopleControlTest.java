/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cristinairwin
 */
public class PeopleControlTest {
    
    public PeopleControlTest() {
    }
   

    /**
     * Test of calculateMortality method, of class PeopleControl.
     */
    @Test
    public void testCalculateMortality() {
        System.out.println("calculateMortality");
        
        //Test Case 1
        System.out.println("\tTest case 1");
        // defie the input variables
        int wheatForPeople = 150000;
        int curPop = 500;
        int expDeaths = 0;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 2
        System.out.println("\tTest case 2");
        // defie the input variables
        wheatForPeople = 9000;
        curPop = 500;
        expDeaths = 50;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 3
        System.out.println("\tTest case 3");
        // defie the input variables
        wheatForPeople = 19;
        curPop = 500;
        expDeaths = 500;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 4
        System.out.println("\tTest case 4");
        // defie the input variables
        wheatForPeople = -10000;
        curPop = 500;
        expDeaths = -1;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 5
        System.out.println("\tTest case 5");
        // defie the input variables
        wheatForPeople = 10000;
        curPop = -500;
        expDeaths = -2;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 6
        System.out.println("\tTest case 6");
        // defie the input variables
        wheatForPeople = 10000;
        curPop = 0;
        expDeaths = -2;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 7
        System.out.println("\tTest case 7");
        // defie the input variables
        wheatForPeople = 10000;
        curPop = 1;
        expDeaths = 0;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 8
        System.out.println("\tTest case 8");
        // defie the input variables
        wheatForPeople = 0;
        curPop = 500;
        expDeaths = 500;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        
        //Test Case 9
        System.out.println("\tTest case 9");
        // defie the input variables
        wheatForPeople = 7587;
        curPop = 500;
        expDeaths = 121;
        //call the method
        result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        System.out.println(result);
    }
    
}
