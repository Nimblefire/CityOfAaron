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
 * @author Team Irwin - DaPonte - Rochira
 */
public class PeopleControlTest {
    
    public PeopleControlTest() {
    }
    

    /**
     * Test of calculateMortality method, of class PeopleControl.
     */
    @Test
    public void test1CalculateMortality() {
        
        
        //Test Case 1
        System.out.println("\tcalculateMortality Test case 1");
        //call the method
        int result = PeopleControl.calculateMortality(15000, 500);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 1 failed",0, result);
    }
     
    @Test
    public void test2CalculateMortality() {
        //Test Case 2
        System.out.println("\tcalculateMortality Test case 2");
        //call the method
        int result = PeopleControl.calculateMortality(9000, 500);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 2 failed",50, result);
    }
    
    @Test
    public void test3CalculateMortality() {
        //Test Case 3
        System.out.println("\tcalculateMortality Test case 3");
        //call the method
        int result = PeopleControl.calculateMortality(19, 500);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 3 failed",500, result);
    }
    
    @Test
    public void test4CalculateMortality() {
        //Test Case 4
        System.out.println("\tcalculateMortality Test case 4");
        //call the method
        int result = PeopleControl.calculateMortality(-10000, 500);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 4 failed",-1, result);
    }
     
    @Test
    public void test5CalculateMortality() {
        //Test Case 5
        System.out.println("\tcalculateMortality Test case 5");
        //call the method
        int result = PeopleControl.calculateMortality(10000, -500);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 5 failed",-2, result);
    }    
    
    @Test
    public void test6CalculateMortality() {
        //Test Case 6
        System.out.println("\tcalculateMortality Test case 6");
        //call the method
        int result = PeopleControl.calculateMortality(10000, 0);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 6 failed",-2, result);
    }
    
    @Test
    public void test7CalculateMortality() {
        //Test Case 7
        System.out.println("\tcalculateMortality Test case 7");
        //call the method
        int result = PeopleControl.calculateMortality(10000, 1);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 7 failed",0, result);
    }
    
    @Test
    public void test8CalculateMortality() {
        //Test Case 8
        System.out.println("\tcalculateMortality Test case 8");
        //call the method
        int result = PeopleControl.calculateMortality(0, 500);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 8 failed",500, result);
    }

    @Test
    public void test9CalculateMortality() {
        //Test Case 9  
        // this is an extra text case to check how the method handles floating point values
        System.out.println("\tcalculateMortality Test case 9");
        //call the method
        int result = PeopleControl.calculateMortality(7587, 500);
        //test to see if the result returned equals the expected amount
        assertEquals("Test 9 failed",121, result);
    }
    
}
