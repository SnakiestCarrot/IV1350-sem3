package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinalSaleDTOTest {
    FinalSaleDTO instanceToTest;

    @BeforeEach
    public void setUp() {
        Sale sale = new Sale();
        ArticleDTO testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        sale.enterArticleToSale(testArticleDTO, 1);

        instanceToTest = new FinalSaleDTO(sale);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;

    }

    @Test
    public void testConstructorWorks() {


        assertTrue(101 == instanceToTest.getArticleList().get(0).getIdentifier(), "Identifier doesnt match");
        assertTrue(2.99 == instanceToTest.getArticleList().get(0).getPrice(), "Price doesnt match");
        assertTrue(0.25 == instanceToTest.getArticleList().get(0).getVatRate(), "VATRate doesnt match");
        assertTrue(instanceToTest.getArticleList().get(0).getName().equals("Banana"), "Name doesnt match");
        assertTrue(instanceToTest.getArticleList().get(0).getArticleDescription().equals("This is a banana"), "Description doesnt match");
        assertTrue(1 == instanceToTest.getArticleList().get(0).getQuantity(), "Quantity doesnt match");
    }
}
