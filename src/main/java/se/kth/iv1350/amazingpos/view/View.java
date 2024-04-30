package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.model.Article;
import se.kth.iv1350.amazingpos.model.SaleStatusDTO;

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
        enterArticleIdentifier(101, 1);
    }
    /**
     * Prints the details of an article and the current running total after an identifier is entered.
     * This method is designed to provide a quick summary of article information and total sales cost on the console. 
     * @param articleDTO articleDTO contains details like name, price, vat rate and identifier.
     * @param totalSaleCost totalSaleCost represents the current state of the sum of all registered articles so far.
     */
    private void printAfterIdentifierEntered (SaleStatusDTO saleStatus) {
        Article article = saleStatus.getCurrentArticle();
        
        double articleQuantity = article.getQuantity();
        int articleID = article.getIdentifier();
        String articleName = article.getName();
        double articleCost = article.getPrice();
        double articleVAT = article.getVatRate();
        String articleDescription = article.getArticleDescription();

        double saleCost = saleStatus.getCurrentTotalSaleCost();
        double saleVAT = saleStatus.getCurrentTotalVAT();
        
        System.out.println("Add " + articleQuantity + " with item id " + articleID);
        System.out.println("Item ID: " + articleID);
        System.out.println("Item name: " + articleName);
        System.out.println("Item cost: " + articleCost + " SEK");
        System.out.println("VAT: " + (articleVAT*100) + "%");
        System.out.println("Item description: " + articleDescription);
        System.out.println("");
        System.out.println("Total cost (incl VAT): " + saleCost);
        System.out.println("Total VAT: " + saleVAT);
    }

    private void enterArticleIdentifier (int identifier, double quantity) {
        SaleStatusDTO saleStatus = contr.enterArticle(identifier, quantity);

        printAfterIdentifierEntered(saleStatus);
    }
}
