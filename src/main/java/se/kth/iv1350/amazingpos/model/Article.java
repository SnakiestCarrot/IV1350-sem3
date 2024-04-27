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
    private double amount;
    
    public Article (ArticleDTO artDTO, double amount) {
        this.identifier = artDTO.getIdentifier();
        this.price = artDTO.getPrice();
        this.vatRate = artDTO.getVatRate();
        this.name = artDTO.getName();
        this.amount = amount;
    }
}
