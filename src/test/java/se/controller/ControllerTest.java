package se.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    private ArticleDTO testArticleDTOBanana;
    private Article banana;
    private Controller testController;
    private ReceiptPrinter testPrinter;
    private ExternalAccountingManager testAccMan;
    private ArticleCatalogHandler testCatHan;
    private Sale testSale;

    @BeforeEach
    public void setUp() {
        testArticleDTOBanana = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        banana = new Article(testArticleDTOBanana, 2);

        testPrinter = new ReceiptPrinter();
        testAccMan = new ExternalAccountingManager();
        testCatHan = new ArticleCatalogHandler();

        testSale = new Sale();

        testController = new Controller(testPrinter, testAccMan, testCatHan);
    }

    @AfterEach
    public void tearDown() {
        testArticleDTOBanana = null;
        banana = null;

        testPrinter = null;
        testAccMan = null;
        testCatHan = null;

        testController = null;
    }
    
    @Test
    public void testEnterArticle() {
        int identifier = 101;
        int quantity = 2;

        ArticleDTO testArticleDTOBanana = new ArticleDTO(identifier, 2.99, 0.25, "Banana", "This is a banana");
        
        testSale.enterArticleToSale(testArticleDTOBanana, quantity);

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
