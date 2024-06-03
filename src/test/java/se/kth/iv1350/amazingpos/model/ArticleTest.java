package se.kth.iv1350.amazingpos.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;

public class ArticleTest {
    ArticleDTO testArticleDTO;
    Article testArticle;

    @BeforeEach
    public void setUp() {
        testArticleDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        testArticle = new Article(testArticleDTO, 10);
    }

    @AfterEach
    public void tearDown() {
        testArticleDTO = null;
        testArticle = null;
    }

    @Test
    public void testAddingArticleQuantity() {
        testArticle.addQuantity(10);

        assertTrue(testArticle.getQuantity() == 20, "The article does not have the expected quantity.");
    }

    @Test
    public void testSubtractingArticleQuantity() {
        testArticle.subtractQuantity(5);

        assertTrue(testArticle.getQuantity() == 5, "The article does not have the expected quantity.");
    }
}
