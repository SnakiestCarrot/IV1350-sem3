/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.amazingpos.integration.ArticleCatalogHandler;
import se.kth.iv1350.amazingpos.integration.ArticleDTO;

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
        ArticleDTO expectedOutput = new ArticleDTO(101);

        ArticleDTO actualOutput = instanceToTest.fetchArticleDTO(101);

        boolean identifierMatch = actualOutput.getIdentifier() == expectedOutput.getIdentifier();
        boolean priceMatch = actualOutput.getPrice() == expectedOutput.getPrice();
        boolean nameMatch = actualOutput.getName() == expectedOutput.getName();
        boolean vatRateMatch = actualOutput.getVatRate() == expectedOutput.getVatRate();

        boolean allMatch = identifierMatch && priceMatch && nameMatch && vatRateMatch;
        assertTrue(allMatch, "The two ArticleDTO objects do not match.");
    }

    @Test
    public void testFetchArticleDTODifferentIdentifier() {
        ArticleDTO expectedOutput = new ArticleDTO(105);

        ArticleDTO actualOutput = instanceToTest.fetchArticleDTO(104);

        boolean identifierMatch = actualOutput.getIdentifier() == expectedOutput.getIdentifier();
        boolean priceMatch = actualOutput.getPrice() == expectedOutput.getPrice();
        boolean nameMatch = actualOutput.getName() == expectedOutput.getName();
        boolean vatRateMatch = actualOutput.getVatRate() == expectedOutput.getVatRate();

        boolean allMatch = identifierMatch && priceMatch && nameMatch && vatRateMatch;
        assertFalse(allMatch, "The two ArticleDTO objects match.");
    }

    @Test
    public void testFetchArticleDTOisNotValid() {
        ArticleDTO expectedOutput = null;

        ArticleDTO actualOutput = instanceToTest.fetchArticleDTO(99);

        assertTrue(actualOutput == expectedOutput, "The method did not return null with an invalid identifier.");
    }
}
