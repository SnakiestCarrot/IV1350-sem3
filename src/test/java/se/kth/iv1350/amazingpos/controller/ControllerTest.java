package se.kth.iv1350.amazingpos.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.ArticleCatalogHandler;
import se.kth.iv1350.amazingpos.integration.ArticleDTO;
import se.kth.iv1350.amazingpos.integration.ExternalAccountingManager;
import se.kth.iv1350.amazingpos.integration.ReceiptPrinter;
import se.kth.iv1350.amazingpos.model.Sale;

public class ControllerTest {
    private Controller testController;
    private ReceiptPrinter testPrinter;
    private ExternalAccountingManager testAccMan;
    private ArticleCatalogHandler testCatHan;
    private ArticleDTO testArticleDTO;


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
        testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");

        int quantity = 1;
        
        Sale sale = new Sale();
        sale.enterArticleToSale(testArticleDTO, quantity);

        assertEquals(quantity, sale.getArticleList().get(0).getQuantity());
    }

    /* 
     * This test is to address the following feedback
     * 2. The tests for the controller are not complete, there's for example no test for alternative flow 3-4b.
     */
    @Test
    public void testRepeatedArticleEntry() {
        testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");

        int quantity = 1;
        
        Sale sale = new Sale();
        sale.enterArticleToSale(testArticleDTO, quantity);
        sale.enterArticleToSale(testArticleDTO, quantity);

        assertEquals(quantity * 2, sale.getArticleList().get(0).getQuantity());
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
