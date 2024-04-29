/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Article;

/**
 * ArticleDTO is a class that should represent the data collected from the 
 * ArticleCatalog about individual articles. It is placeholder for now.
 * @author caspt
 */
public class ArticleDTO {
    private int identifier;
    private double price;
    private double vatRate;
    private String name;
    
    public ArticleDTO (int identifier, double price, double vatRate, String name) {
        this.identifier = identifier;
        this.price = price;
        this.vatRate = vatRate;
        this.name = name;
    }

    public boolean equals (ArticleDTO articleDTOToCompare) {
        boolean identifierMatch = this.getIdentifier() == articleDTOToCompare.getIdentifier();
        boolean priceMatch = this.getPrice() == articleDTOToCompare.getPrice();
        boolean nameMatch = this.getName() == articleDTOToCompare.getName();
        boolean vatRateMatch = this.getVatRate() == articleDTOToCompare.getVatRate();

        return identifierMatch && priceMatch && nameMatch && vatRateMatch;
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
}
