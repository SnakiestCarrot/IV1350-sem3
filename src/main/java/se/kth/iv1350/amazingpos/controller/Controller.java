package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.*;
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
    
    /**
     * Creates instance of Sale class.
     */
    public void requestNewSale() {
        this.sale = new Sale();
    }
    
    private ArticleDTO fetchArticleDTO (int identifier) {
        return catalogHandler.fetchArticleDTO(identifier);
    }

    /**
     * Method to enter article based on identifier and quantity to the sale object.
     * Returns a SaleStatusDTO for view to display information.
     * @param identifier
     * @param quantity
     * @return SaleStatusDTO
     */
    public SaleStatusDTO enterArticle (int identifier, double quantity) {
        return this.sale.enterArticleToSale(fetchArticleDTO(identifier), quantity);
    }

    public double getCurrentTotalSaleCost () {
        return this.sale.getTotalCost();
    }

    /**
     * Registers payment to sale. 
     * @param payment
     */
    public void registerPayment (double payment) {
        this.sale.registerFinalPayment(payment);

        accountingManager.updateAccountingSystem(this.sale.getTotalCost());


        catalogHandler.updateInventorySystem(this.sale.getArticleList());
    }

    public Sale getSale () {
        return this.sale;
    }

    /**
     * Tells printer to print receipt.
     */
    public void printReceipt ()  {
        this.printer.printReceipt(getSale());
    }
}
