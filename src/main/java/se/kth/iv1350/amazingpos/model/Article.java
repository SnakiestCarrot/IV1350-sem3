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
    private double quantity;
    
    public Article (ArticleDTO artDTO, double amount) {
        this.identifier = artDTO.getIdentifier();
        this.price = artDTO.getPrice();
        this.vatRate = artDTO.getVatRate();
        this.name = artDTO.getName();
        this.quantity = quantity;
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

    public double getQuantity () {
        return this.quantity;
    }

    public void setQuantity (double quantityToSet) {
        this.quantity = quantityToSet;
    }
}
