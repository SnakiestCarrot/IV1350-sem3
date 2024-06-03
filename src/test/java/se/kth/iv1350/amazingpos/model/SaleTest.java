package se.kth.iv1350.amazingpos.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;

public class SaleTest {
    private Sale instanceToTest;

    @BeforeEach
    public void setUp() {
        instanceToTest = new Sale();
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
    }

    @Test
    public void testEnterArticleToSale() {
        ArticleDTO testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        Article testArticle = new Article(testArticleDTO, 1);

        instanceToTest.enterArticleToSale(testArticleDTO, 1);

        assertTrue(instanceToTest.getArticleList().get(0).equals(testArticle), 
        "The two ArticleDTO objects do not match.");
    }

    @Test
    public void testRepeatedArticleEntryUpdatesQuantityCorrectly() {
        ArticleDTO testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        Article twoTestArticles = new Article(testArticleDTO, 2);

        instanceToTest.enterArticleToSale(testArticleDTO, 1);
        instanceToTest.enterArticleToSale(testArticleDTO, 1);

        assertTrue(instanceToTest.getArticleList().get(0).equals(twoTestArticles),
        "The article quantity should be updated to 2 after adding the same article twice, but it was not.");
    }

    @Test
    public void testAddingUniqueItemsToSale() {
        ArticleDTO testArticleDTOBanana = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        ArticleDTO testArticleDTOOrange = new ArticleDTO(102, 1.99, 0.25, "Orange", "This is an orange");

        Article testBanana = new Article(testArticleDTOBanana, 1);
        Article testTwoBananas = new Article(testArticleDTOBanana, 2);
        Article testOrange = new Article(testArticleDTOOrange, 1);

        instanceToTest.enterArticleToSale(testArticleDTOBanana, 1);        
        instanceToTest.enterArticleToSale(testArticleDTOOrange, 1);

        assertTrue(instanceToTest.getArticleList().get(0).equals(testBanana) && 
        instanceToTest.getArticleList().get(1).equals(testOrange), "Did not correctly add unique articles to sale.");

        instanceToTest.enterArticleToSale(testArticleDTOBanana, 1);

        assertTrue(instanceToTest.getArticleList().get(0).equals(testTwoBananas) && 
        instanceToTest.getArticleList().get(1).equals(testOrange), "Did not update article quantity when adding a previously entered item.");
    }

    @Test
    public void testCalculateTotalCostForMultipleItems() {
        ArticleDTO testArticleDTOBanana = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        ArticleDTO testArticleDTOOrange = new ArticleDTO(102, 1.99, 0.25, "Orange", "This is an orange");

        instanceToTest.enterArticleToSale(testArticleDTOBanana, 2);


        assertTrue(instanceToTest.getTotalCost() == testArticleDTOBanana.getPrice() * 2, "Total cost does not match the expected value.");

        instanceToTest.enterArticleToSale(testArticleDTOOrange, 1);

        assertTrue(instanceToTest.getTotalCost() == testArticleDTOBanana.getPrice() * 2 + testArticleDTOOrange.getPrice(), "Total cost does not match expected value.");
    }

    @Test
    public void testCalculateTotalVATForMultipleArticles() {
        ArticleDTO testArticleDTOBanana = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        ArticleDTO testArticleDTOOrange = new ArticleDTO(102, 1.99, 0.25, "Orange", "This is an orange");

        instanceToTest.enterArticleToSale(testArticleDTOBanana, 2);

        assertTrue(instanceToTest.getTotalSaleVAT() == (testArticleDTOBanana.getVatRate() * testArticleDTOBanana.getPrice()) * 2, "Total VAT does not match expected value.");

        instanceToTest.enterArticleToSale(testArticleDTOOrange, 1);

        assertTrue(instanceToTest.getTotalSaleVAT() == (testArticleDTOBanana.getVatRate() * testArticleDTOBanana.getPrice()) * 2 + (testArticleDTOOrange.getVatRate() * testArticleDTOOrange.getPrice()), "Total VAT does not match expected value.");
    }
}
