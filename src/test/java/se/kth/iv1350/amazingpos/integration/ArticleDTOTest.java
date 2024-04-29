package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.integration.ArticleDTO;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ArticleDTOTest {
    private ArticleDTO instanceToTest;

        @BeforeEach
        public void setUp() {
            instanceToTest = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        }
        
        @AfterEach
        public void tearDown() {
            instanceToTest = null;
        }

        @Test
        public void testEqualsIsTrue() {
            ArticleDTO expectedOutput = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");

            assertTrue(instanceToTest.equals(expectedOutput), "The two ArticleDTO objects do not match.");
        }

        @Test
        public void testEqualsIsFalse() {
            
            ArticleDTO expectedOutput = new ArticleDTO(102, 1.99, 0.25, "Apple", "This is an apple");

            assertFalse(instanceToTest.equals(expectedOutput), "The two ArticleDTO objects match.");
        }
}
