/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.data;

import com.debug.satyajit.billingsystem.models.AvailableItem;
import com.debug.satyajit.billingsystem.models.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

/**
 *
 * @author shadowleaf
 */
public class ItemsAvailableData {
    //private ObservableList<Item> items;
    private ObservableList<AvailableItem> items;
    private FilteredList filter;
    private SortedList sortedList;

    public ItemsAvailableData() {
        items = FXCollections.observableArrayList();
        filter = new FilteredList(items, e -> true);
    }

    public ObservableList<AvailableItem> getItems() {
        return items;
    }

    public void setItems(ObservableList<AvailableItem> items) {
        this.items = items;
    }

    public FilteredList getFilter() {
        return filter;
    }

    public void setFilter(FilteredList filter) {
        this.filter = filter;
    }

    public SortedList getSortedList() {
        return sortedList;
    }

    public void setSortedList(SortedList sortedList) {
        this.sortedList = sortedList;
    }

}
