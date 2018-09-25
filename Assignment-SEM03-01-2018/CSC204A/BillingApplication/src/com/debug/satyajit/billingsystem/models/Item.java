/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.models;

import javafx.scene.image.ImageView;

/**
 *
 * @author shadowleaf
 */
public class Item {
    
    private String productName;
    private String manufacturerName;
    private String productNumber;
    private Double MRP;
    private Double discount;
    
    private ImageView perishableIndicator;


    public Item(String productName, String manufacturerName, String productNumber, Double MRP, Double discount) {
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.productNumber = productNumber;
        this.MRP = MRP;
        this.discount = discount;
    }
    
    public Item(Item item) {
        this.productName = item.getProductName();
        this.manufacturerName = item.getManufacturerName();
        this.productNumber = item.getProductNumber();
        this.MRP = item.getMRP();
        this.discount = item.getDiscount();
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public Double getMRP() {
        return MRP;
    }

    public Double getDiscount() {
        return discount;
    }
    
}
