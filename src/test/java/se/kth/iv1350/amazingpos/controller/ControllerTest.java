package se.kth.iv1350.amazingpos.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.ArticleCatalogHandler;
import se.kth.iv1350.amazingpos.integration.ExternalAccountingManager;
import se.kth.iv1350.amazingpos.integration.ReceiptPrinter;
import se.kth.iv1350.amazingpos.model.SaleStatusDTO;

public class ControllerTest {
    private Controller testController;
    private ReceiptPrinter testPrinter;
    private ExternalAccountingManager testAccMan;
    private ArticleCatalogHandler testCatHan;

    @BeforeEach
    public void setUp() {

        testPrinter = new ReceiptPrinter();
        testAccMan = new ExternalAccountingManager();
        testCatHan = new ArticleCatalogHandler();

        testController = new Controller(testPrinter, testAccMan, testCatHan);
        testController.requestNewSale();
    }

    @AfterEach
    public void tearDown() {
        testPrinter = null;
        testAccMan = null;
        testCatHan = null;

        testController = null;
    }
    
    @Test
    public void testEnterArticle() {
        int identifier = 101;
        int quantity = 2;
        
        SaleStatusDTO saleStatus = testController.enterArticle(identifier, quantity);
        
        assertNotNull(saleStatus);
        assertEquals(identifier, saleStatus.getCurrentArticle().getIdentifier());
        assertEquals(quantity, saleStatus.getCurrentArticle().getQuantity());
    }
    
    @Test
    public void testRegisterPayment() {
        Controller controller = new Controller(new ReceiptPrinter(), new ExternalAccountingManager(), new ArticleCatalogHandler());
        controller.requestNewSale();
        double payment = 50.0;
        
        controller.registerPayment(payment);
        
        assertNotNull(controller.getSale());
        assertEquals(payment, controller.getSale().getPayment());
        assertEquals(payment - controller.getSale().getTotalCost(), controller.getSale().getChange());
    }
}
