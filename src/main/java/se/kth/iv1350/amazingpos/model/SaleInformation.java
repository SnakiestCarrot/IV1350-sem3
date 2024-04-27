package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * SaleInformation is responsible for storing information related to the transaction.
 * @author caspt
 */
public class SaleInformation {
    private double totalCost;
    private LocalDateTime saleTime;
    private double totalSaleVAT;
    private double payment;
    private double change;
    private ArrayList<Article> articleList = new ArrayList<Article>();
    
    public SaleInformation() {
        setSaleTime();
    }
    
    private void setSaleTime() {
        this.saleTime = LocalDateTime.now();
    }
    
    double getTotalCost () {
        return this.totalCost;
    }
    
    LocalDateTime getSaleTime () {
        return this.saleTime;
    }
    
    double getTotalSaleVAT () {
        return this.totalSaleVAT;
    }
}
