/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.utility;

import com.debug.satyajit.billingsystem.models.AvailableItem;
import com.debug.satyajit.billingsystem.models.Item;
import com.debug.satyajit.billingsystem.models.PerishableItem;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author shadowleaf
 */
public class DataUtility {

    private String filePath;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public DataUtility(String filePath) {
        this.filePath = filePath;
    }

    public CSVReader getCSVReader() throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        return new CSVReader(fileReader);
    }
    
    public CSVWriter getCSVWriter() throws IOException {
        /* Append True */
        FileWriter fileWriter = new FileWriter(filePath);
        return new CSVWriter(fileWriter);
    }
    
    public CSVWriter getCSVWriter(Boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, append);
        return new CSVWriter(fileWriter);
    }

    public ObservableList<Item> readItems() throws FileNotFoundException, IOException, ParseException {
        ObservableList<Item> items = FXCollections.observableArrayList();
        CSVReader reader = getCSVReader();
        String[] nextRecord;
        /* Read the Header */
        reader.readNext();
        while ((nextRecord = reader.readNext()) != null) {
            Item item = new Item(nextRecord[1], nextRecord[2], nextRecord[0], Double.parseDouble(nextRecord[3]), Double.parseDouble(nextRecord[4]));
            if (nextRecord.length > 5 && !nextRecord[5].equals("")) {
                PerishableItem perishableItem = new PerishableItem(item, dateFormat.parse(nextRecord[5]));
                items.add(perishableItem);
            } else {
                items.add(item);
            }
        }

        return items;
    }
    
    public void writeItems(ObservableList<AvailableItem> availableItem) throws IOException {
        /* Try with Resource */
        try (CSVWriter writer = getCSVWriter()) {
            /* Store all lines here */
            ArrayList <String []> lines = new ArrayList<>();
            String[] header = "productNumber,productName,manufacturerName,MRP,discount,Expiry".split(",");
            lines.add(header);
            availableItem.forEach(_availableItem -> {
                Item item = _availableItem.getItem();
                String line = item.getProductNumber()+","+item.getProductName()+","+item.getManufacturerName()+","+item.getMRP()+","+item.getDiscount();
                if (item instanceof PerishableItem)
                    line += ","+DataUtility.dateFormat.format(((PerishableItem)item).getExpiryDate());
                String record[];
                record = line.split(",");
                lines.add(record);
            });
            writer.writeAll(lines);
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
