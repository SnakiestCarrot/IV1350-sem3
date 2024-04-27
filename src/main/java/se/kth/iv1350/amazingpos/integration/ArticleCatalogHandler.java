/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

/**
 * Handles operations related to fetching article data transfer objects (DTOs) based on article identifiers.
 * This class checks the validity of an article identifier and retrieves the corresponding ArticleDTO if valid.
 */
public class ArticleCatalogHandler {
    
    private boolean checkValidArticle(int identifier) {
        return identifier > 100;
    }
    
    public ArticleDTO fetchArticleDTO (int identifier) {
        if (!checkValidArticle(identifier)) {
            return null;
        }
        else {
            return new ArticleDTO (identifier);
        }
    }
    
}
