package se.kth.iv1350.amazingpos.model;

/**
 * Added after feedback for seminar 5.
 * 
 * FinalSaleArticleDTO is used in the list in FinalSaleDTO.
 * 
 */
public class FinalSaleArticleDTO {

    private int identifier;
    private double price;
    private double vatRate;
    private String name;
    private String articleDescription;
    private double quantity;

    public FinalSaleArticleDTO (Article article) {
        this.identifier = article.getIdentifier();
        this.price = article.getPrice();
        this.vatRate = article.getVatRate();
        this.name = article.getName();
        this.articleDescription = article.getArticleDescription();
        this.quantity = article.getQuantity();
    }

    public int getIdentifier () {
        return this.identifier;
    }

    public double getPrice () {
        return this.price;
    }

    public double getVatRate () {
        return this.vatRate;
    }

    public String getName () {
        return this.name;
    }

    public String getArticleDescription () {
        return this.articleDescription;
    }

    public double getQuantity () {
        return this.quantity;
    }

}
