package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;

/**
 * SaleInformation is responsible for storing information related to the transaction.
 * @author caspt
 */
public class Sale {
    private double totalCost;
    private LocalDateTime saleTime;
    private double totalSaleVAT;
    private double payment;
    private double change;
    private ArrayList<Article> articleList = new ArrayList<Article>();
    
    public Sale() {
        setSaleTime();
    }
    
    private void setSaleTime() {
        this.saleTime = LocalDateTime.now();
    }
    
    public double getTotalCost () {
        return this.totalCost;
    }
    
    LocalDateTime getSaleTime () {
        return this.saleTime;
    }
    
    public double getTotalSaleVAT () {
        return this.totalSaleVAT;
    }

    public double getPayment () {
        return this.payment;
    }

    public double getChange () {
        return this.change;
    }

    public ArrayList<Article> getArticleList () {
        return this.articleList;
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

    private Article getArticleInList (ArticleDTO artDTO) {
        for (int i = 0; i < articleList.size(); i++) {
            if (artDTO.getIdentifier() == articleList.get(i).getIdentifier()) {
                return articleList.get(i);
            }
        }
        return null;
    }

    public SaleStatusDTO enterArticleToSale (ArticleDTO artDTO, double quantity) {
        if (isArticleInSale(artDTO)) {
            addQuantityToArticleInList(artDTO, quantity);
        }
        else {
            createArticleInList(artDTO, quantity);
        }
        updateSaleTotalCost();
        updateTotalVATForSale();
        return new SaleStatusDTO (getArticleInList(artDTO), this.totalCost, this.totalSaleVAT);
    }
}
