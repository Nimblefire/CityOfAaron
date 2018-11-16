/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import app.CityOfAaron;
import model.Game;
import model.Location;
import model.Map;
import model.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dapon
 */
public class MapControlTest {
    
    public MapControlTest() {
    }
    /**
     * Test of setCurrentLocation method, of class MapControl.
     */
    @Test
    public void testSetCurrentLocation() {
        
        System.out.println("setCurrentLocation");
        Game game = new Game();
        game.setMap(MapControl.createMap());
        Point newLocation = new Point();
        newLocation.setRow(1);
        newLocation.setColumn(1);
        Location expResult = game.getMap().getLocations()[1][1];
        Location result = MapControl.setCurrentLocation(game, newLocation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
