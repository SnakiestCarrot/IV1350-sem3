package se.kth.iv1350.amazingpos.model;

public class SaleStatusDTO {
    private Article currentArticle;
    private double currentTotalCost;
    private double currentTotalVAT;

    /**
     * SaleStatusDTO stores information about the sale, 
     * like most recently added article, the cost of the sale so far, and the vat of the sale so far.
     * @param currentArticle the most recently added article
     * @param currentTotalCost the running total of the sale
     * @param currentTotalVAT the running total VAT cost of the sale
     */

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
