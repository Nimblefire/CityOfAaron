/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;

/** 
 * @author team Irwin - DaPonte - Rochira
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import model.*;
import view.*;

public class CityOfAaron {
        
    // keep a copy of the current Game object in the main class
    public static Game currentGame = null;
    
    public static Game getCurrentGame(){
        return currentGame;
    } 
    
    public static void setCurrentGame(Game game){
        currentGame = game;
    }
    
    // instance variables for character stream files and their getters and setters
    private static BufferedReader inFile = null;
    private static PrintWriter outFile = null;
    private static PrintWriter logFile = null;

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        CityOfAaron.inFile = inFile;
    }
    
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        CityOfAaron.outFile = outFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        CityOfAaron.logFile = logFile;
    }
    
    // call the StartProgramView view
    public static void main(String[] args){
        
        try {
            // include the stream files in this try...catch block to handle any 
            // runtime I/O exceptions that may occur while opening them
            inFile = new BufferedReader(new InputStreamReader(System.in));
            outFile = new PrintWriter(System.out, true);
            
            // the program writes all of the log messages to this file 
            // in the current directory (e.g., your project folder)
            logFile = new PrintWriter("logFile.txt");
            
            // calling point fot startProgramMenuView
            View startProgramView = new StartProgramView();
            startProgramView.displayView();
        } catch (Throwable te) {
            System.console().printf("Exception caught from the main method");
            System.console().printf(te.getMessage());
            te.printStackTrace();
        }   // add a finally clause to close the file streams 
            finally {
                // include the code to close the stream files in a try...catch block  
                // to catch any exception in case they don't close properly
                try {
                    //  verify that the stream file variables do not have 
                    //  a null value before calling the close() method
                    if (inFile != null)
                        inFile.close();
                    if (outFile != null)
                        outFile.close();
                    if (logFile != null)
                        logFile.close();
                } catch (IOException ioe) {
                    System.console().printf("Error closing file");
                    return;
                }
        }
    } 
}
