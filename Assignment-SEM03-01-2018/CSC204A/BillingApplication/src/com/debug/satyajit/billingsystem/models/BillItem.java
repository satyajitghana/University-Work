/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.models;

import javafx.beans.Observable;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 *
 * @author shadowleaf
 */
public class BillItem extends Item {

    private String description;
    private FloatProperty netPrice = new SimpleFloatProperty();
    private IntegerProperty quantity = new SimpleIntegerProperty();

    private FloatProperty value = new SimpleFloatProperty();
    private FloatProperty savings = new SimpleFloatProperty();

    public Button delButton;
    public Spinner<Integer> qtySpinner;

    public BillItem(Item item) {
        super(item);
        this.description = item.getProductName() + " by " + item.getManufacturerName();
        this.value = new SimpleFloatProperty(new Float(item.getMRP()));
        this.quantity = new SimpleIntegerProperty(1);

        doCalculation();

        /* Set the button */
        Image image = new Image(BillItem.class.getResourceAsStream("/images/bin.png"));

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(20);
        this.delButton = new Button("");
        this.delButton.setGraphic(imageView);

        /* Set the Quantity Spinner */
        this.qtySpinner = new Spinner<>(1, 20, 1);
        this.qtySpinner.setEditable(true);
        this.qtySpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.quantity.set(newValue);
            doCalculation();
        });
    }

    public void doCalculation() {
        this.netPrice.set(this.quantity.getValue() * ((new Float(this.getMRP())) * new Float(1 - (this.getDiscount() / 100))));
        this.savings.set(new Float(this.quantity.getValue() * this.getMRP()) - this.netPrice.getValue());
    }

    public BillItem(String description, Float netPrice, Integer quantity, Float value, Float savings, Item item) {
        super(item);
        this.description = description;
        this.netPrice.set(netPrice);
        this.quantity.set(quantity);
        this.value.set(value);
        this.savings.set(savings);
    }

    /* Callback method for observable value changes */
    public static Callback<BillItem, Observable[]> extractor() {
        return (BillItem b) -> new Observable[]{
            b.quantityProperty(),
            b.valueProperty(),
            b.savingsProperty(),
            b.netPriceProperty()
        };
    }

    /* Properties */
    public final IntegerProperty quantityProperty() {
        return this.quantity;
    }
    
    public final FloatProperty valueProperty() {
        return this.value;
    }
    
    public final FloatProperty savingsProperty() {
        return this.savings;
    }
    
    public final FloatProperty netPriceProperty() {
        return this.netPrice;
    }

    /* Getters and Setters */
    public String getDescription() {
        return description;
    }

    public Float getNetPrice() {
        return netPrice.getValue();
    }

    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    public Float getValue() {
        return this.value.getValue();
    }
    
    public Float getSavings() {
        return this.savings.getValue();
    }

    public Spinner<Integer> getQtySpinner() {
        return qtySpinner;
    }

    public Button getDelButton() {
        return delButton;
    }

}
