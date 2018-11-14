
package view;

/**
 *
 * @author team Irwin - DaPonte - Rochira
 */
public class StartProgramView extends ViewBase {
    
    /**
     * Constructor
     */
    public StartProgramView() {
        super();
    }
    
    @Override
    protected String getMessage() {
        
        return  "\n\n**************************************************************************************\n"
                + "*                                                                                    *\n"
                + "*                            Welcome to the city of Aaron!                           *\n"
                + "*                                                                                    *\n"
                + "**************************************************************************************\n\n"
                + "\tYou have been summoned here by the High Priest to assume your role as\n"
                + "\truler of the city.\n\tTo fulfill your duty, you are going to manage the following tasks:\n"
                + "\t\u27BD buy and sell land\n"
                + "\t\u27BD determine how much wheat to plant each year\n"
                + "\t\u27BD determine how much to set aside to feed your people\n"
                + "\tIn addition, it will be your job to pay an annual tithe on the wheat\n"
                + "\tthat is harvested. If you fail to provide enough wheat for the people,\n"
                + "\tpeople will starve, some people will die, and your workforce will be\n"
                + "\tdiminished. Plan carefully. And Oh, there is always a danger of rats\n\teating your wheat.\n\n";
    }
    

    /**
     * In this case the view does not collect any user input,
     * it only displays the welcome message and then the MAIN menu.
     * @return 
     */
    @Override
    public String[] getInputs() {
        
        return null;
    }

    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        
        startMainMenuView();
        
        // return false so that whoever call us doesn't call us again 
        return false;
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    
    private void startMainMenuView(){
        pause(2000);
        View mainMenu = new MainMenuView();
        //MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayView();
    }
    
}
