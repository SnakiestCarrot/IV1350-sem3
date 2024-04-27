package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.Sale;

/**
 * This is the application's controller, all method calls from view go through this class.
 */
public class Controller {
    private ReceiptPrinter printer;
    private ExternalAccountingManager accountingManager;
    private ArticleCatalogHandler catalogHandler;
    private Sale sale;
    /**
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
    
    public ArticleDTO enterArticleIdentifier (int identifier) {
        return catalogHandler.fetchArticleDTO(identifier);
    }
}
