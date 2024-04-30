/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ArticleDTO;

/**
 * Represents an article, with necessary details like identifier and price.
 * This class is used to create an article instance from ArticleDTO.
 */
public class Article {
    
    private int identifier;
    private double price;
    private double vatRate;
    private String name;
    private String articleDescription;
    private double quantity;

    /**
     * A constructor method that makes an Article object. Article objects hold the same information
     * as an ArticleDTO, but include a quantity variable. 
     * @param artDTO The DTO you are appending a quantity to.
     * @param quantity The quantity you are adding to the DTO.
     */
    
    public Article (ArticleDTO artDTO, double quantity) {
        this.identifier = artDTO.getIdentifier();
        this.price = artDTO.getPrice();
        this.vatRate = artDTO.getVatRate();
        this.name = artDTO.getName();
        this.articleDescription = artDTO.getArticleDescription();
        this.quantity = quantity;
    }

    /**
     * The equals method is used for testing purposes, to ensure two articles are equal.
     * @param articleToCompare The article object you are comparing with.
     * @return
     */
    public boolean equals (Article articleToCompare) {
        boolean identifierMatch = this.getIdentifier() == articleToCompare.getIdentifier();
        boolean priceMatch = this.getPrice() == articleToCompare.getPrice();
        boolean nameMatch = this.getName() == articleToCompare.getName();
        boolean vatRateMatch = this.getVatRate() == articleToCompare.getVatRate();
        boolean descriptionMatch = this.articleDescription == articleToCompare.getArticleDescription();
        boolean quantityMatch = this.getQuantity() == articleToCompare.getQuantity();

        return identifierMatch && priceMatch && nameMatch && vatRateMatch&& descriptionMatch && quantityMatch;
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

    public void addQuantity (double quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    public void subtractQuantity (double quantityToSubtract) {
        this.quantity -= quantityToSubtract;
    }
}
