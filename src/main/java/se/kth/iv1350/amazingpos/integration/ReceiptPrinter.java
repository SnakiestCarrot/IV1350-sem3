/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Article;
import se.kth.iv1350.amazingpos.model.Sale;

/**
 * ReceiptPrinter takes in SaleInformation and uses it to print a receipt at the end of the sale.
 */
public class ReceiptPrinter {
    public void printReceipt (Sale sale) {
        System.out.println("------------------ Begin receipt -------------------");
        System.out.println("Time of Sale: " + sale.getSaleTime());
        System.out.println("");
        for (int i = 0; i < sale.getArticleList().size(); i++) {
            printArticleInReceipt(sale.getArticleList().get(i));
        }
        System.out.println("");
        System.out.println("Total: \t" + sale.getTotalCost());
        System.out.println("VAT: \t" + sale.getTotalSaleVAT());
        System.out.println("");
        System.out.println("Cash: \t" + sale.getPayment());
        System.out.println("Change: \t" + sale.getChange());
        System.out.println("------------------ End receipt ---------------------");
    }

    private void printArticleInReceipt (Article article) {
        double quantity = article.getQuantity();
        double price = article.getPrice();
        String name = article.getName();
        double totalPriceForArticle = calculateTotalArticleCost(article);
        System.out.println(name + "\t" + quantity + "x" + price + "\t" + totalPriceForArticle);
    }

    private double calculateTotalArticleCost (Article article) {
        return article.getPrice() * article.getQuantity();
    }
}
