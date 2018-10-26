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
 * @author Andrea
 */
public class GameControlTest {
    
    public GameControlTest() {
    }

    @Test
    public void test1getRandomValue() {
        System.out.println("Test 1 - valid input test between 1 and 100");
        int random = GameControl.getRandomValue(1, 100);
        assertTrue("Test 1 failed",1 <= random && random <= 100);
        System.out.printf(("Test 1 passed: " + "%d <= %d <= %d\n"),1, random, 100);
    }
    
    @Test
    public void test2getRandomValue() {
        System.out.println("Test 2 - valid input test between 435 and 2736");
        int random = GameControl.getRandomValue(435, 2736);
        assertTrue("Test 2 failed",435 <= random && random <= 2736);
        System.out.printf(("Test 2 passed: " + "%d <= %d <= %d\n"),435, random, 2736);
    }
    
    @Test
    public void test3getRandomValue() {
        System.out.println("Test 3 - invalid input test: negative lowValue");
        int random = GameControl.getRandomValue(-23, 12);
        assertEquals("Test 3 failed", -1, random);
        System.out.println("Test 3 passed");
    }
    
    @Test
    public void test4getRandomValue() {
        System.out.println("Test 4 - invalid input test: negative highValue");
        int random = GameControl.getRandomValue(23, -12);
        assertEquals("highValue is negative",-1, random);
        System.out.println("Test 4 passed");
    }
    
    @Test
    public void test5getRandomValue() {
        System.out.println("Test 5 - invalid input test: lowValue is equal to highValue");
        int random = GameControl.getRandomValue(23, 23);
        assertEquals("lowValue is equal to highValue",-2, random);
        System.out.println("Test 5 passed");
    }
    
    @Test
    public void test6getRandomValue() {
        System.out.println("Test 6 - invalid input test: lowValue is higher than highValue");
        int random = GameControl.getRandomValue(23, 12);
        assertEquals("lowValue is higher than highValue",-2, random);
        System.out.println("Test 6 passed");
    }
    
    @Test
    public void test7getRandomValue() {
        System.out.println("Test 7 - invalid input test: highValue exceeds integer type upper limit");
        int random = GameControl.getRandomValue(23, Integer.MAX_VALUE);
        assertEquals("highValue exceeds int data type upper limit", -3, random);
        System.out.println("Test 7 passed");
    }
    
    @Test
    public void test8getRandomValue() {
        System.out.println("Test 8 - boundary input test: lowValue is equals to 0");
        int random = GameControl.getRandomValue(0, 5000);
        assertTrue("Test 8 failed", 0 <= random && random <= 5000);
        System.out.printf(("Test 8 passed: " + "%d <= %d <= %d\n"),0, random, 5000);
        System.out.println();
    }
}
