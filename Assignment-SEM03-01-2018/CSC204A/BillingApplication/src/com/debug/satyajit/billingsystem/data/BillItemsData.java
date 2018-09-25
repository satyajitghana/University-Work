/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.data;

import com.debug.satyajit.billingsystem.models.BillItem;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author shadowleaf
 */


public class BillItemsData {
    private ObservableList<BillItem> billItems;
    private FloatProperty grandTotal;
    private FloatProperty totalSavings;
    private IntegerProperty totalItems;

    public FloatProperty getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(FloatProperty grandTotal) {
        this.grandTotal = grandTotal;
    }

    public FloatProperty getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(FloatProperty totalSavings) {
        this.totalSavings = totalSavings;
    }

    public IntegerProperty getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(IntegerProperty totalItems) {
        this.totalItems = totalItems;
    }

    public BillItemsData() {
        billItems = FXCollections.observableArrayList(BillItem.extractor());
        grandTotal = new SimpleFloatProperty(0f);
        totalSavings = new SimpleFloatProperty(0f);
        totalItems = new SimpleIntegerProperty(0);
            
        billItems.addListener((ListChangeListener.Change<? extends BillItem> c) -> {
            calculateBill();
        });
    }

    public ObservableList<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(ObservableList<BillItem> billItems) {
        this.billItems = billItems;
    }
    
    public void calculateBill() {
        grandTotal.setValue(0f);
        totalSavings.setValue(0f);
        totalItems.setValue(0);
        billItems.forEach(billItem -> {
            grandTotal.setValue(grandTotal.getValue() + billItem.getNetPrice());
            totalSavings.setValue(totalSavings.getValue() + billItem.getSavings());
            totalItems.setValue(totalItems.getValue() + billItem.getQuantity());
        });
    }
    
}
