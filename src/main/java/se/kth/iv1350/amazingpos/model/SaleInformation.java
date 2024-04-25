package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;

/**
 * SaleInformation is responsible for storing information related to the transaction.
 * @author caspt
 */
public class SaleInformation {
    private int totalCost;
    private LocalDateTime saleTime;
    private int totalSaleVAT;
    private double payment;
    private double change;
    
    public SaleInformation() {
        setSaleStartTime();
    }
    
    private void setSaleStartTime() {
        this.saleTime = LocalDateTime.now();
    }
}
