package se.kth.iv1350.amazingpos.model;

public class SaleStatusDTO {
    private Article currentArticle;
    private double currentTotalCost;
    private double currentTotalVAT;

    SaleStatusDTO (Article currentArticle, double currentTotalCost, double currentTotalVAT) {
        this.currentArticle = currentArticle;
        this.currentTotalCost = currentTotalCost;
        this.currentTotalVAT = currentTotalVAT;
    }

    public Article getCurrentArticle () {
        return this.currentArticle;
    }

    public double getCurrentTotalSaleCost () {
        return this.currentTotalCost;
    }

    public double getCurrentTotalVAT () {
        return this.currentTotalVAT;
    }


}
