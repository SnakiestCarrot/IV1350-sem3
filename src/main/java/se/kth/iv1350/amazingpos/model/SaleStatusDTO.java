package se.kth.iv1350.amazingpos.model;

public class SaleStatusDTO {
    private Article currentArticle;

    private double currentTotalCost;
    private double currentTotalVAT;

    private int articleID;
    private String articleName;
    private double articleCost;
    private double  articleVAT;
    private String articleDescription;

    /**
     * Changed after feedback for seminar 5.
     * 
     * SaleStatusDTO stores information about the sale, 
     * like most recently added article, the cost of the sale so far, and the vat of the sale so far.
     * 
     * @param currentArticle the most recently added article
     * @param currentTotalCost the running total of the sale
     * @param currentTotalVAT the running total VAT cost of the sale
     */

    SaleStatusDTO (Article currentArticle, double currentTotalCost, double currentTotalVAT) {
        this.currentTotalCost = currentTotalCost;
        this.currentTotalVAT = currentTotalVAT;
        this.articleID = currentArticle.getIdentifier();
        this.articleName = currentArticle.getName();
        this.articleCost = currentArticle.getPrice();
        this.articleVAT = currentArticle.getVatRate();
        this.articleDescription = currentArticle.getArticleDescription();
    }


    public double getCurrentTotalSaleCost () {
        return this.currentTotalCost;
    }

    public double getCurrentTotalVAT () {
        return this.currentTotalVAT;
    }

    public int getIdentifier () {
        return this.articleID;
    }

    public String getArticleName () {
        return this.articleName;
    }

    public double getArticleCost () {
        return this.articleCost;
    }

    public double getArticleVatRate () {
        return this.articleVAT;
    }

    public String getArticleDescription () {
        return this.articleDescription;
    }

}
