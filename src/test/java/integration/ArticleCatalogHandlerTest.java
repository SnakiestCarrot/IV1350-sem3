/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

import se.kth.iv1350.amazingpos.integration.ArticleCatalogHandler;
import se.kth.iv1350.amazingpos.integration.ArticleDTO;

/**
 *
 * @author caspt
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
    public void testSetSaleTime() {
        ArticleDTO expectedOutput = new ArticleDTO(101);
        instanceToTest.fetchArticleDTO(101);
    }    
}
