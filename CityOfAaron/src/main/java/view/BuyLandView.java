package view;

import app.CityOfAaron;

/**
 *
 * @author cristinairwin
 */
public class BuyLandView extends ViewBase {

    /**
     * Constructor
     */
    public BuyLandView() {
    }

    @Override
    protected String getMessage() {

        return "\nBuy Land\n"
                + "--------------------\n"
                + "Land is selling for " + CityOfAaron.getCurrentGame().getLandPrice() + " an acre.\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("How many acres of new land do you want to buy?");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        if (inputs[0] == null || inputs[0].equals("")) {
            ErrorView.display(this.getClass().getName(),"Missing amount. Returning to the Manage Crops Menu");
            return false; //if false return to Manage Crops, true keeps going
        }

        int acresToBuy;
        try {
            acresToBuy = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException exception) {
            ErrorView.display(this.getClass().getName(),"Acres must be a whole number. Try again.");
            return true;//keep going
        }

        boolean check = inputCheck(acresToBuy);
        pause(2500);

        return check;
    }

    private boolean inputCheck(int acresToBuy) {
        //int wheatCost = GameControl.getRandomValue(17, 27);
        int totalWheatCost = CityOfAaron.getCurrentGame().getLandPrice() * acresToBuy;

        //if acresToBuy is less than -1 ask player to enter in number 0 or larger. 
        if (acresToBuy < 0) {
            ErrorView.display(this.getClass().getName(),"Please enter a number 0 or larger.");
            return true;
        } //if total wheat price (wheatPrice * acresToBuy) is greater than the wheat in storage, ask user to try again.
        else if (totalWheatCost > CityOfAaron.getCurrentGame().getWheatInStorage()) {
            ErrorView.display(this.getClass().getName(),"You don't have enough wheat, please try again");
            return true;
        } //if acresToBuy is more than people to tend it (1 person can maintain 10 acres), ask user to try again.
        /*else if ((CityOfAaron.getCurrentGame().getCurrentPopulation() * 10) < (acresToBuy + CityOfAaron.getCurrentGame().getAcresOwned())) {
            ErrorView.display(this.getClass().getName()," You don't have enought people to work that amount of land, please enter in another number. ");
            return true;//Have to ask input again
        }*/ else {
            reportAcresOwned(acresToBuy);
            reportWheatInStorage(CityOfAaron.getCurrentGame().getLandPrice(), totalWheatCost);
            return false;

        }

    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input.
    private void reportAcresOwned(int acresToBuy) {
        //add the number of acres purchased to the acres owned
        //acresToBuy + acresOwned = acresOwned;
        CityOfAaron.getCurrentGame().setAcresOwned(acresToBuy + CityOfAaron.getCurrentGame().getAcresOwned());
        console.println("You now have " + CityOfAaron.getCurrentGame().getAcresOwned() + " acres of land.\n");
    }

    private void reportWheatInStorage(int wheatPrice, int totalWheatCost) {
        //subtract the wheat used to purchase the land from the wheat in storage
        //CityOfAaron.getCurrentGame().getWheatInStorage() - wheatCost = wheatInStorage;
        CityOfAaron.getCurrentGame().setWheatInStorage(CityOfAaron.getCurrentGame().getWheatInStorage() - totalWheatCost);
        console.println("You now have " + CityOfAaron.getCurrentGame().getWheatInStorage() + " bushels of wheat in storage.\n");
    }
}
