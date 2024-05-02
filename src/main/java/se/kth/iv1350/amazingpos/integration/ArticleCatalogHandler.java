/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import java.util.ArrayList;

import se.kth.iv1350.amazingpos.model.Article;

/**
 * Handles operations related to fetching article data transfer objects (DTOs) based on article identifiers.
 * This class checks the validity of an article identifier and retrieves the corresponding ArticleDTO if valid.
 * 
 * Stores made up items used for seminar task represented as ArticleDTOs.
 */
public class ArticleCatalogHandler {
    private final int ID_OFFSET = 101;

    private final int LOWEST_VALID_ID = 101;
    private final int HIGHEST_VALID_ID = 103;

    private ArrayList<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
    private ArrayList<Article> catalogArticleList = new ArrayList<Article>();

    private double bananaStartingInventory = 200.0;
    private double orangeStartingInventory = 200.0;
    private double appleStartingInventory = 200.0;

    public ArticleCatalogHandler () {
        ArticleDTO bananaDTO = new ArticleDTO(101, 2.99, 0.25, "Banana", "This is a banana");
        ArticleDTO orangeDTO = new ArticleDTO(102, 1.99, 0.25, "Orange", "This is an orange");
        ArticleDTO appleDTO = new ArticleDTO(103, 0.99, 0.25, "Apple", "This is an apple");

        catalogArticleList.add(new Article(bananaDTO, bananaStartingInventory));
        catalogArticleList.add(new Article(orangeDTO, orangeStartingInventory));
        catalogArticleList.add(new Article(appleDTO, appleStartingInventory));

        articleDTOList.add(bananaDTO);
        articleDTOList.add(orangeDTO);
        articleDTOList.add(appleDTO);
    }
    
    private boolean checkValidArticle(int identifier) {
        return identifier >= LOWEST_VALID_ID && identifier <= HIGHEST_VALID_ID;
    }

    private ArticleDTO fetchDTOFromFakeDatabase (int identifier) {
        return this.articleDTOList.get(identifier - ID_OFFSET);
    }
    
    /**
     * Fetches ArticleDTO from fake database based on identifier parameter.
     * 
     * @param identifier
     * @return ArticleDTO
     */
    public ArticleDTO fetchArticleDTO (int identifier) {
        if (!checkValidArticle(identifier)) {
            return null;
        }
        else {
            return fetchDTOFromFakeDatabase(identifier);
        }
    }

    /**
     * Method for updating inventory system. Subtracts quantity of bought item in our made up database.
     * 
     * @param saleArticleList
     */
    public void updateInventorySystem (ArrayList<Article> saleArticleList) {
        Article currentArticle;

        for (int i = 0; i < saleArticleList.size(); i++) {
            currentArticle = saleArticleList.get(i);
            catalogArticleList.get(findArticleIndexInList(currentArticle)).subtractQuantity(currentArticle.getQuantity());
        }
    }

    private int findArticleIndexInList (Article articleToFind) {
        int identifierToFind = articleToFind.getIdentifier();

        for (int i = 0; i < catalogArticleList.size(); i++) {
            if (identifierToFind == catalogArticleList.get(i).getIdentifier()) {
                return i;
            }
        }
        return -1;
    }
    
}
