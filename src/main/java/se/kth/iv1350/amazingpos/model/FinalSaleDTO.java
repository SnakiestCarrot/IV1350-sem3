package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Made after feedback for seminar 5.
 * 
 * FinalSaleDTO is a DTO version of the sale object after sale is finalized, used to be sent in controller.
 * 
 */ 
public class FinalSaleDTO {
    private double totalCost;
    private LocalDateTime saleTime;
    private double totalSaleVAT;
    private double payment;
    private double change;
    private ArrayList<Article> articleList = new ArrayList<Article>();

    public FinalSaleDTO (Sale sale) {
        this.totalCost = sale.getTotalCost();
        this.saleTime = sale.getSaleTime();
        this.totalSaleVAT = sale.getTotalSaleVAT();
        this.payment = sale.getPayment();
        this.change = sale.getChange();
        this.articleList = sale.getArticleList();
    }

    public double getTotalCost () {
        return this.totalCost;
    }
    
    public LocalDateTime getSaleTime () {
        return this.saleTime;
    }
    
    public double getTotalSaleVAT () {
        return this.totalSaleVAT;
    }

    public double getPayment () {
        return this.payment;
    }

    public double getChange () {
        return this.change;
    }

    public ArrayList<Article> getArticleList () {
        return this.articleList;
    }


}
