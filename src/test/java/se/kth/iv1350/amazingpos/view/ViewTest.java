package se.kth.iv1350.amazingpos.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.ArticleCatalogHandler;
import se.kth.iv1350.amazingpos.integration.ExternalAccountingManager;
import se.kth.iv1350.amazingpos.integration.ReceiptPrinter;

public class ViewTest {
    private View viewInstance;
    
    @BeforeEach
    public void setUp() {
        ReceiptPrinter printer = new ReceiptPrinter();
        ExternalAccountingManager accountingManager = new ExternalAccountingManager();
        ArticleCatalogHandler catalogHandler = new ArticleCatalogHandler();
        
        Controller contr = new Controller(printer, accountingManager, catalogHandler);
        
        this.viewInstance = new View(contr);
        
        
        
    }
    
    @AfterEach
    public void tearDown() {
        this.viewInstance = null;
    }

    @Test
    public void testRunFakeView() {
        viewInstance.runFakeView();
        
    }
}
