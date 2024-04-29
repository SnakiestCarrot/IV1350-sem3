package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.ArticleDTO;
import se.kth.iv1350.amazingpos.model.Sale;

/**
 * This view is a fake representation of the real user interface view, to be able to 
 * complete the seminar task.
 */
public class View {
    
    private Controller contr;
    
    /**
     * View constructor to make the interactions between the user interface and
     * model possible
     * @param contr Takes a Controller instance as argument to connect it with
     * the rest of the application
     */
    public View (Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Fakes a execution of the view running and issuing inputs and getting outputs
     */
    public void runFakeView() {
        contr.requestNewSale();
    }
    /**
     * Prints the details of an article and the current running total after an identifier is entered.
     * This method is designed to provide a quick summary of article information and total sales cost on the console. 
     * @param articleDTO articleDTO contains details like name, price, vat rate and identifier.
     * @param totalSaleCost totalSaleCost represents the current state of the sum of all registered articles so far.
     */
    private void printAfterIdentifierEntered (ArticleDTO articleDTO, double totalSaleCost) {
        System.out.println("Article name: " + articleDTO.getName());
        System.out.println("Article price: " + articleDTO.getPrice());
        System.out.println("Running total: " + totalSaleCost);
    }
}
