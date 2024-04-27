/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

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
    
    public ArticleDTO (int identifier) {
        this.identifier = identifier;
        this.price = 2.99;
        this.vatRate = 0.25;
        this.name = "Banana";
        System.out.println(this.name == "Banana");
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
    
    public void setIdentifier (int identifierToSet) {
        this.identifier = identifierToSet;
    }
    
    public void setPrice (double priceToSet) {
        this.price = priceToSet;
    }
    
    public void setVatRate (double vatRateToSet) {
        this.vatRate = vatRateToSet;
    }
    
    public void setName (String nameToSet) {
        this.name = nameToSet;
    }
}
