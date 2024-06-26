package se.kth.iv1350.amazingpos.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.ArticleCatalogHandler;
import se.kth.iv1350.amazingpos.integration.ArticleDTO;
import se.kth.iv1350.amazingpos.integration.ExternalAccountingManager;
import se.kth.iv1350.amazingpos.integration.ReceiptPrinter;
import se.kth.iv1350.amazingpos.model.Article;
import se.kth.iv1350.amazingpos.model.Sale;

public class ControllerTest {
    private Controller testController;
    private ReceiptPrinter testPrinter;
    private ExternalAccountingManager testAccMan;
    private ArticleCatalogHandler testCatHan;
    private ArticleDTO testArticleDTO;
    private Sale testSale;



    @BeforeEach
    public void setUp() {

        testPrinter = new ReceiptPrinter();
        testAccMan = new ExternalAccountingManager();
        testCatHan = new ArticleCatalogHandler();

        testController = new Controller(testPrinter, testAccMan, testCatHan);
        testController.requestNewSale();

        testSale = new Sale();
    }

    @AfterEach
    public void tearDown() {
        testPrinter = null;
        testAccMan = null;
        testCatHan = null;

        testController = null;
    }
    
    /*
     * This tests the enterArticleToSale method. 
     * The intent is to test the branch where the if statement is false so a
     * new article is created in the list rather than a quantity being added
     */
    @Test
    public void testEnterArticle() {
        testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");

        int quantity = 1;
        
        Sale sale = new Sale();
        sale.enterArticleToSale(testArticleDTO, quantity);

        assertEquals(quantity, sale.getArticleList().get(0).getQuantity(), "The item within the list did not update the quantity correctly.");
    }

    /* 
     * This test is to address the following feedback:
     * 2. The tests for the controller are not complete, there's for example no test for alternative flow 3-4b.
     * It tests the method enterArticleToSale and intends to test the branch where the if statement is true, so that 
     * a quantity is added to an existing article
     */
    @Test
    public void testRepeatedArticleEntry() {
        testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");

        int quantity = 1;
        
        Sale sale = new Sale();
        sale.enterArticleToSale(testArticleDTO, quantity);
        sale.enterArticleToSale(testArticleDTO, quantity);

        assertEquals(quantity * 2, sale.getArticleList().get(0).getQuantity(), "The item within the list did not update the quantity correctly.");
    }

    @Test
    public void testAddingMultipleUniqueItemsToSale () {
        ArticleDTO testArticleDTOBanana = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        ArticleDTO testArticleDTOOrange = new ArticleDTO(102, 1.99, 0.25, "Orange", "This is an orange");

        Article testBanana = new Article(testArticleDTOBanana, 1);
        Article testTwoBananas = new Article(testArticleDTOBanana, 2);
        Article testOrange = new Article(testArticleDTOOrange, 1);

        Sale sale = new Sale();

        sale.enterArticleToSale(testArticleDTOBanana, 1);        
        sale.enterArticleToSale(testArticleDTOOrange, 1);

        assertTrue(sale.getArticleList().get(0).equals(testBanana) && 
        sale.getArticleList().get(1).equals(testOrange), "Did not correctly add unique articles to sale.");

        sale.enterArticleToSale(testArticleDTOBanana, 1);

        assertTrue(sale.getArticleList().get(0).equals(testTwoBananas) && 
        sale.getArticleList().get(1).equals(testOrange), "Did not update article quantity when adding a previously entered item.");
    }
    
    @Test
    public void testRegisterPayment() {
        Controller controller = new Controller(new ReceiptPrinter(), new ExternalAccountingManager(), new ArticleCatalogHandler());
        controller.requestNewSale();
        double payment = 50.0;
        
        controller.registerPayment(payment);
        
        assertNotNull(controller.getFinalSaleDTO(), "getFinalSaleDTO returns null, when an object of type FinalSaleDTO was expected");
        assertEquals(payment, controller.getFinalSaleDTO().getPayment(), "Payment does not match the expected value.");
        assertEquals(payment - controller.getFinalSaleDTO().getTotalCost(), controller.getFinalSaleDTO().getChange(), "Total cost does not match the expected value.");
    }

    @Test
    public void testInitialization() {
        assertNotNull(testPrinter, "Printer should not be null after initialization");
        assertNotNull(testAccMan, "Accounting Manager should not be null after initialization");
        assertNotNull(testCatHan, "Catalog Handler should not be null after initialization");
        assertNotNull(testSale, "Sale should not be null after initialization");
    }

}
