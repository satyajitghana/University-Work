/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.models;

import java.util.Date;
import javafx.scene.image.ImageView;

/**
 *
 * @author shadowleaf
 */
public class PerishableItem extends Item {
    
    private ImageView perishableIndicator;
    private Date expiryDate;
    
    public PerishableItem(Item item) {
        super(item);
    }
    
    public PerishableItem(Item item, Date expiry) {
        super(item);
        this.expiryDate = expiry;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

}
