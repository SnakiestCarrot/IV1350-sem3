package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.kth.iv1350.amazingpos.model.FinalSaleArticleDTO;

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
    private List<FinalSaleArticleDTO> articleList;

    public FinalSaleDTO (Sale sale) {
        this.totalCost = sale.getTotalCost();
        this.saleTime = sale.getSaleTime();
        this.totalSaleVAT = sale.getTotalSaleVAT();
        this.payment = sale.getPayment();
        this.change = sale.getChange();

        ArrayList<FinalSaleArticleDTO> mutableArticleList = new ArrayList<FinalSaleArticleDTO>();
        
        for (int i = 0; i < sale.getArticleList().size(); i++){
            mutableArticleList.add(new FinalSaleArticleDTO(sale.getArticleList().get(i)));
        }

        this.articleList = Collections.unmodifiableList(mutableArticleList);
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

    public List<FinalSaleArticleDTO> getArticleList () {
        return this.articleList;
    }


}
