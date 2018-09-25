/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.models;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author shadowleaf
 */
public class AvailableItem implements Perishable {
    /* Why didn't i extend Item here ? because not all items are available, so let it contain the item and not inherit every property of item as iteself
    thought this would be a better way of dealing with it */
        Item item;
        ImageView perishableIndicator;
        
            
    /* These are used for Editing the available items */
    public Button delButton;

    public AvailableItem(Item item) {
        this.item = item;
        
        /* Why not display the expiry ? why just an indicator ? well, why should i tell the customer the expiry,
         if it has not expired, then the seller can sell it, if you want to see the expiry explicitly, then
         refer to the data file, which contains all the data */
        if (isPerishable()) {
            Image image = new Image(BillItem.class.getResourceAsStream("/images/clock.png"));
            perishableIndicator = new ImageView(image);
            perishableIndicator.setPreserveRatio(true);
            perishableIndicator.setFitHeight(20);
        }
        
        /* Set the button */
        Image image = new Image(BillItem.class.getResourceAsStream("/images/bin.png"));

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(20);
        this.delButton = new Button("");
        this.delButton.setGraphic(imageView);
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public Boolean isPerishable() {
        return this.item instanceof PerishableItem;
    }
    
    public Item getItem() {
        return item;
    }

    public ImageView getPerishableIndicator() {
        return perishableIndicator;
    }

    public Button getDelButton() {
        return delButton;
    }
    
}
