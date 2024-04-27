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
        printAfterIdentifierEntered(contr.enterArticleIdentifier(101), contr.sale);
    }
    
    private void printAfterIdentifierEntered (ArticleDTO articleDTO, Sale currentSale) {
        System.out.println("");
        System.out.println("");
    }
}
