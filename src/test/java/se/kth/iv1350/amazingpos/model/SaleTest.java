package se.kth.iv1350.amazingpos.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;
import se.kth.iv1350.amazingpos.model.Sale;

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
        ArticleDTO testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana");
        Article twoTestArticles = new Article(testArticleDTO, 2);

        instanceToTest.enterArticleToSale(testArticleDTO, 1);
        instanceToTest.enterArticleToSale(testArticleDTO, 1);

        assertTrue(instanceToTest.getArticleList().get(0).equals(twoTestArticles),
        "The article quantity should be updated to 2 after adding the same article twice, but it was not.");
    }

    @Test
    public void testAddingTwoUniqueItems() {
        ArticleDTO testArticleDTOBanana = new ArticleDTO(101, 2.99, 0.25, "Banana");
        ArticleDTO testArticleDTOOrange = new ArticleDTO(102, 1.99, 0.25, "Orange");

        instanceToTest.enterArticleToSale(testArticleDTOOrange, 1);
        instanceToTest.enterArticleToSale(testArticleDTOBanana, 1);

        
    }
}
