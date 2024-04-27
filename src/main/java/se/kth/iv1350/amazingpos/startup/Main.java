package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.ArticleCatalogHandler;
import se.kth.iv1350.amazingpos.integration.ExternalAccountingManager;
import se.kth.iv1350.amazingpos.integration.ReceiptPrinter;
import se.kth.iv1350.amazingpos.view.View;


/**
 * Initializes the entire application, contains the main method
 * @author caspt
 */
public class Main {
    /**
     * The main method where the application is run within.
     * @param args main does not take any arguments from the command line.
     */
    public static void main(String[] args) {
        ReceiptPrinter printer = new ReceiptPrinter();
        ExternalAccountingManager accountingManager = new ExternalAccountingManager();
        ArticleCatalogHandler catalogHandler = new ArticleCatalogHandler();
        
        Controller contr = new Controller(printer, accountingManager, catalogHandler);
        View view = new View(contr);
        
        view.runFakeView();
        
    }
}
