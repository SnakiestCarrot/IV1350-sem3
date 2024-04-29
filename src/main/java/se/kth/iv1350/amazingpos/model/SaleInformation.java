package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;

/**
 * SaleInformation is responsible for storing information related to the transaction.
 * @author caspt
 */
public class SaleInformation {
    private double totalCost;
    private LocalDateTime saleTime;
    private double totalSaleVAT;
    private double payment;
    private double change;
    private ArrayList<Article> articleList = new ArrayList<Article>();
    
    public SaleInformation() {
        setSaleTime();
    }
    
    private void setSaleTime() {
        this.saleTime = LocalDateTime.now();
    }
    
    double getTotalCost () {
        return this.totalCost;
    }
    
    LocalDateTime getSaleTime () {
        return this.saleTime;
    }
    
    double getTotalSaleVAT () {
        return this.totalSaleVAT;
    }

    private boolean isArticleInSale (ArticleDTO artDTO) {
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).getIdentifier() == artDTO.getIdentifier()) {
                return true;
            }
        }
        return false;
    }

    private void addQuantityToArticleInList (ArticleDTO articleToAdd, double quantity) {
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).getIdentifier() == articleToAdd.getIdentifier()) {
                articleList.get(i).addQuantity(quantity);
            }
        }
    }

    private void createArticleInList (ArticleDTO artDTO, double quantity) {
        articleList.add(new Article(artDTO, quantity));
    }

    private void updateSaleTotalCost () {
        double newTotalCost = 0;
        for (int i = 0; i < articleList.size(); i++) {
            newTotalCost += calculateArticleCost(articleList.get(i));
        }

        this.totalCost = newTotalCost;
    }

    private double calculateArticleCost (Article article) {
        return article.getPrice() * article.getQuantity();
    }

    private double calculateArticleVAT (Article article) {
        return calculateArticleCost(article) * article.getVatRate();
    }

    private void updateTotalVATForSale () {
        double newTotalSaleVAT = 0;
        for (int i = 0; i < articleList.size(); i++) {
            newTotalSaleVAT += calculateArticleVAT(articleList.get(i));
        }

        this.totalSaleVAT = newTotalSaleVAT;
    }

    public void enterArticleToSaleInformation (ArticleDTO artDTO, double quantity) {
        if (isArticleInSale(artDTO)) {
            addQuantityToArticleInList(artDTO, quantity);
        }
        else {
            createArticleInList(artDTO, quantity);
        }
        updateSaleTotalCost();
    }
}
