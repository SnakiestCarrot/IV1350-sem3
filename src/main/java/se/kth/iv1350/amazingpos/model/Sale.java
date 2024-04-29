package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;

/**
 * Sale is responsible for storing and handling information related to the transaction.
 * @author caspt
 */
public class Sale {
    private SaleInformation saleInformation;
    
    public Sale() {
        this.saleInformation = new SaleInformation();
    }

    public double getTotalSaleCost () {
        return this.saleInformation.getTotalCost();
    }

    public void enterArticleToSale (ArticleDTO artDTO, double quantity) {
        this.saleInformation.enterArticleToSaleInformation(artDTO, quantity);
    }
}
