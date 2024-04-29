/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import java.util.ArrayList;

/**
 * Handles operations related to fetching article data transfer objects (DTOs) based on article identifiers.
 * This class checks the validity of an article identifier and retrieves the corresponding ArticleDTO if valid.
 */
public class ArticleCatalogHandler {

    private ArrayList<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
    private int identifierOffset = 101;

    public ArticleCatalogHandler () {
        articleDTOList.add(new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana"));
        articleDTOList.add(new ArticleDTO(102, 1.99, 0.25, "Orange", "This is an orange"));
        articleDTOList.add(new ArticleDTO(103, 0.99, 0.25, "Apple", "This is an apple"));
    }
    
    private boolean checkValidArticle(int identifier) {
        return identifier >= 101 && identifier <= 103;
    }

    private ArticleDTO fetchDTOFromFakeDatabase (int identifier) {
        return this.articleDTOList.get(identifier - identifierOffset);
    }
    
    public ArticleDTO fetchArticleDTO (int identifier) {
        if (!checkValidArticle(identifier)) {
            return null;
        }
        else {
            return fetchDTOFromFakeDatabase(identifier);
        }
    }


    
}
