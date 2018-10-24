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
    public void test1CalculateMortality() {
        System.out.println("calculateMortality");
        
        //Test Case 1
        System.out.println("\tTest case 1");
        // define the input variables
        int wheatForPeople = 150000;
        int curPop = 500;
        int expDeaths = 0;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }
     
    @Test
    public void test2CalculateMortality() {
        //Test Case 2
        System.out.println("\tTest case 2");
        // define the input variables
        int wheatForPeople = 9000;
        int curPop = 500;
        int expDeaths = 50;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }
    
    @Test
    public void test3CalculateMortality() {
        //Test Case 3
        System.out.println("\tTest case 3");
        // define the input variables
        int wheatForPeople = 19;
        int curPop = 500;
        int expDeaths = 500;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }
    
    @Test
    public void test4CalculateMortality() {
        //Test Case 4
        System.out.println("\tTest case 4");
        // define the input variables
        int wheatForPeople = -10000;
        int curPop = 500;
        int expDeaths = -1;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }
     
    @Test
    public void test5CalculateMortality() {
        //Test Case 5
        System.out.println("\tTest case 5");
        // define the input variables
        int wheatForPeople = 10000;
        int curPop = -500;
        int expDeaths = -2;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }    
    
    @Test
    public void test6CalculateMortality() {
        //Test Case 6
        System.out.println("\tTest case 6");
        // define the input variables
        int wheatForPeople = 10000;
        int curPop = 0;
        int expDeaths = -2;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }
    
    @Test
    public void test7CalculateMortality() {
        //Test Case 7
        System.out.println("\tTest case 7");
        // define the input variables
        int wheatForPeople = 10000;
        int curPop = 1;
        int expDeaths = 0;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }
    
    @Test
    public void test8CalculateMortality() {
        //Test Case 8
        System.out.println("\tTest case 8");
        // define the input variables
        int wheatForPeople = 0;
        int curPop = 500;
        int expDeaths = 500;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
    }

    @Test
    public void test9CalculateMortality() {
        //Test Case 9  
        // this is an extra text case to check how the method handles floating point values
        System.out.println("\tTest case 9");
        // define the input variables
        int wheatForPeople = 7587;
        int curPop = 500;
        int expDeaths = 121;
        //call the method
        int result = PeopleControl.calculateMortality(wheatForPeople, curPop);
        //test to see if the result returned equals the expected amount
        assertEquals(expDeaths, result);
        System.out.println(result);
    }
    
}
