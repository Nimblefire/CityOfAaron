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
public class WheatControlTest {
    
    public WheatControlTest() {
    }

    /**
     * Test of calculateHarvest method, of class WheatControl.
     */
    @Test
        public void test1CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(1);
        
        System.out.println("\tValid inputs: Test case 1 with fake random 3 (2+1), 500 * 3 = 1500");
        int tithesOfferings = 15;
        int acresPlanted = 500;
        int expResult = 1500;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    @Test
    public void test2CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(2);
        
        System.out.println("\tValid inputs: Test case 2 with fake random 4 (2+2), 4 * 1 = 4");
        int tithesOfferings = 15;
        int acresPlanted = 1;
        int expResult = 4;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    @Test
    public void test3CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(1);
        
        System.out.println("\tValid input: Test case 3 with fake random 3 (2+1), 3 * 500 = 1500");
        int tithesOfferings = 9;
        int acresPlanted = 500;
        int expResult = 1500;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void test4CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(1);
        
        System.out.println("\tValid inputs: Test case 4 with fake random 3 (2+1), 3 * 1 = 3");
        int tithesOfferings = 9;
        int acresPlanted = 1;
        int expResult = 3;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void test5CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(1);
        
        System.out.println("\tValid inputs: Test case 5 with fake random 2 (1+1), 2 * 500 = 1000");
        int tithesOfferings = 6;
        int acresPlanted = 500;
        int expResult = 1000;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void test6CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(1);
        
        System.out.println("\tValid inputs: Test case 6 with fake random 2 (1+1), 2 * 1 =2");
        int tithesOfferings = 6;
        int acresPlanted = 1;
        int expResult = 2;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void test7CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(2);
        
        System.out.println("\tInvalid inputs: Test case 7 with fake random 4 (2+2)");
        int tithesOfferings = 15;
        int acresPlanted = -500;
        int expResult = -1;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void test8CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(2);
        
        System.out.println("\tInvalid inputs: Test case 8 with fake random 4 (2+2)");
        int tithesOfferings = 110;
        int acresPlanted = 500;
        int expResult = -2;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void test9CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(2);
        
        System.out.println("\tInvalid inputs: Test case 9 with fake random 4 (2+2)");
        int tithesOfferings = -15;
        int acresPlanted = 500;
        int expResult = -2;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void test10CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(2);
        
        System.out.println("\tBoundary inputs: Test case 10 with fake random 4 (2+2), 0 * 0 = 0 ");
        int tithesOfferings = 15;
        int acresPlanted = 0;
        int expResult = 0;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void test11CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(1);
        
        System.out.println("\tBoundary inputs: Test case 11 with fake random 2 (1+1), 2 * 500 = 1000");
        int tithesOfferings = 0;
        int acresPlanted = 500;
        int expResult = 1000;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void test12CalculateHarvest() {
        FakeRandom fakeRandom = new FakeRandom();
        GameControl.setRandValue(fakeRandom);
        fakeRandom.add(0);
        
        System.out.println("\tValid inputs: Test case 12 with fake random 1 (0+1), 1 * 1 = 1");
        int tithesOfferings = 6;
        int acresPlanted = 1;
        int expResult = 1;
        int result = WheatControl.calculateHarvest(tithesOfferings, acresPlanted);
        assertEquals(expResult, result);
        
    }
    
}
