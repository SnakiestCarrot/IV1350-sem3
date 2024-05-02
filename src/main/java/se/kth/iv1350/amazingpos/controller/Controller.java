package se.kth.iv1350.amazingpos.controller;

import java.util.ArrayList;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.Article;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.model.SaleStatusDTO;

/**
 * This is the application's controller, all method calls from view go through this class.
 */
public class Controller {
    private ReceiptPrinter printer;
    private ExternalAccountingManager accountingManager;
    private ArticleCatalogHandler catalogHandler;
    private Sale sale;
    /**
     * Initializes a new instance of the Controller class, setting up the necessary components for handling receipt printing,
     * accounting updates, and article information retrieval.
     * 
     * @param printer Takes a ReceiptPrinter instance to later be used for the printing of the receipt.
     * @param accountingManager Takes an ExternalAccountingManager instance to later update the external accounting system
     * @param catalogHandler Takes an ArticleCatalogHandler instance to fetch article information
     */
    public Controller (ReceiptPrinter printer,
            ExternalAccountingManager accountingManager,
            ArticleCatalogHandler catalogHandler) 
    {
        this.printer = printer;
        this.accountingManager = accountingManager;
        this.catalogHandler = catalogHandler;
    }
    
    public void requestNewSale() {
        this.sale = new Sale();
    }
    
    private ArticleDTO fetchArticleDTO (int identifier) {
        return catalogHandler.fetchArticleDTO(identifier);
    }

    public SaleStatusDTO enterArticle (int identifier, double quantity) {
        return this.sale.enterArticleToSale(fetchArticleDTO(identifier), quantity);
    }

    public double getCurrentTotalSaleCost () {
        return this.sale.getTotalCost();
    }

    public void registerPayment (double payment) {
        this.sale.registerFinalPayment(payment);

        accountingManager.updateAccountingSystem(this.sale.getTotalCost());
        System.out.println("Sent sale info to external accounting system.");
        System.out.println();

        catalogHandler.updateInventorySystem(this.sale.getArticleList());
        printArticleListSentToInventory(this.sale.getArticleList());
    }

    private void printArticleListSentToInventory (ArrayList<Article> articleList) {
        for (int i = 0; i < articleList.size(); i++) {
            int identifier = articleList.get(i).getIdentifier();
            double quantity = articleList.get(i).getQuantity();
            System.out.println(
                "Told external inventory system to decrease inventory quantity of item \n" 
            +     identifier + " by " + quantity
            );
        }
        
    }

    public Sale getSale () {
        return this.sale;
    }

    public void printReceipt ()  {
        this.printer.printReceipt(getSale());
    }
}
