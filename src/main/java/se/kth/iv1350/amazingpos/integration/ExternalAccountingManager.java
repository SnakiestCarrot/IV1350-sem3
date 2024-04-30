/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Sale;

/**
 * ExternalAccountingManager will represent the system that handles the payment 
 * and change of the transaction. 
 */
public class ExternalAccountingManager {
    private double funds = 9999;

    public void updateAccountingSystem (double saleTotalCost) {
        this.funds = this.funds + saleTotalCost;
    }
}
