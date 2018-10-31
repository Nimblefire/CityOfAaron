/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import model.Game;
import view.StartProgramView;

/**
 *
 * @author Andrea
 */
public class CityOfAaron {
    
    // keep a copy of the current Game object in the main class
    public static Game currentGame = null;
    
    public static Game getCurrentGame(){
        return currentGame;
    } 
    
    public static void setCurrentGame(Game game){
        currentGame = game;
    }
    
    public static void main(String[] args){
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayView();
    } 
}
