/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 *
 * behövs det kommentarer för testerna?
 */
public class ArticleCatalogHandlerTest {
    private ArticleCatalogHandler instanceToTest;

    @BeforeEach
    public void setUp() {
        instanceToTest = new ArticleCatalogHandler();
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
    }

    @Test
    public void testFetchArticleDTOisValid() {
        ArticleDTO expectedOutput = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        ArticleDTO actualOutput = instanceToTest.fetchArticleDTO(101);

        assertTrue(actualOutput.equals(expectedOutput), "The two ArticleDTO objects do not match.");
    }

    @Test
    public void testFetchArticleDTODifferentIdentifier() {
        ArticleDTO expectedOutput = new ArticleDTO(102, 1.99, 0.25, "Orange", "This is an orange");
        ArticleDTO actualOutput = instanceToTest.fetchArticleDTO(103);

        assertFalse(actualOutput.equals(expectedOutput), "The two ArticleDTO objects match.");
    }

    @Test
    public void testFetchArticleDTOisNotValid() {
        ArticleDTO expectedOutput = null;
        ArticleDTO actualOutput = instanceToTest.fetchArticleDTO(99);

        assertTrue(actualOutput == expectedOutput, "The method did not return null with an invalid article identifier.");
    }
}
