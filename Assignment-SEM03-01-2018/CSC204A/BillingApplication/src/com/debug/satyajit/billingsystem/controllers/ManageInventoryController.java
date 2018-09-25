/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.controllers;

import com.debug.satyajit.billingsystem.utility.GlobalUtility;
import com.debug.satyajit.billingsystem.data.ItemsAvailableData;
import com.debug.satyajit.billingsystem.models.AvailableItem;
import com.debug.satyajit.billingsystem.models.BillItem;
import com.debug.satyajit.billingsystem.models.Item;
import com.debug.satyajit.billingsystem.models.PerishableItem;
import com.debug.satyajit.billingsystem.utility.DataUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import org.apache.commons.io.FileUtils;

/**
 * FXML Controller class
 *
 * @author shadowleaf
 */
public class ManageInventoryController implements Initializable {

    /* Items Available Data */
    private ItemsAvailableData itemsAvailable;

    /* Available Items Table Controls */
    @FXML
    private TableView<AvailableItem> itemsAvailableTable;
    @FXML
    private TableColumn<AvailableItem, String> ano;
    @FXML
    private TableColumn<AvailableItem, String> aproduct;
    @FXML
    private TableColumn<AvailableItem, String> amanufacturer;
    @FXML
    private TableColumn<AvailableItem, Double> amrp;
    @FXML
    private TableColumn<AvailableItem, Double> adiscount;
    @FXML
    private TableColumn<AvailableItem, String> aexpiry;
    @FXML
    private TableColumn<AvailableItem, Button> aremove;

    @FXML
    private TextField tf_pno;
    @FXML
    private TextField tf_pname;
    @FXML
    private TextField tf_manufacturer;
    @FXML
    private TextField tf_mrp;
    @FXML
    private TextField tf_discount;
    @FXML
    private CheckBox cb_perishable;
    @FXML
    private DatePicker dp_expiry;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initItemsAvailableList();

//        dp_expiry.setDisable(true);
//        dp_expiry.setValue(LocalDate.now());
        clearInput();
        dp_expiry.setConverter(new StringConverter<LocalDate>() {

            @Override
            public String toString(LocalDate object) {
                if (object == null) {
                    return "";
                }
                return dateTimeFormatter.format(object);
            }

            @Override
            public LocalDate fromString(String string) {
                if (string == null || string.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(string, dateTimeFormatter);
            }
        });
    }

    @FXML
    private void goToHome(ActionEvent event) throws IOException {
        GlobalUtility.getScene().homeScene();
    }

    @FXML
    private void addList(MouseEvent event) {
    }

    @FXML
    private void search(KeyEvent event) {
    }

    private void initItemsAvailableList() {
        itemsAvailable = new ItemsAvailableData();

        // Assign the Columns
        ano.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getProductNumber()));
        aproduct.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getProductName()));
        amanufacturer.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getManufacturerName()));
        amrp.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getMRP()));
        adiscount.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getDiscount()));
        aexpiry.setCellValueFactory(value -> {
            if (((AvailableItem) value.getValue()).isPerishable()) {
                return new SimpleObjectProperty<>(DataUtility.dateFormat.format(((PerishableItem) value.getValue().getItem()).getExpiryDate()));
            }
            return new SimpleObjectProperty<>("");
        });
        aremove.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getDelButton()));

        itemsAvailableTable.setItems(itemsAvailable.getItems());

        // Read the data from the CSV File
        try {
            readData();
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readData() throws IOException, FileNotFoundException, ParseException {
        /* clear all the items first */
        itemsAvailable.getItems().clear();

        GlobalUtility.getDataUtility().readItems().forEach(e -> {
            AvailableItem toAdd = new AvailableItem(e);
            toAdd.getDelButton().setOnAction(event -> itemsAvailable.getItems().remove(toAdd));
            itemsAvailable.getItems().add(toAdd);
        });
    }

    @FXML
    private void backupData(ActionEvent event) {
        String destPath = GlobalUtility.dataFolder + "ItemData" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".csv";
        try {
            File source = new File(GlobalUtility.getDataUtility().getFilePath());
            File destination = new File(destPath);
            FileUtils.copyFile(source, destination);
            createAlert("File Backup", "Location: " + destPath, "CSV File Backed Up Successfully", Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Backing up Data");
            alert.setContentText(e.getMessage());
            alert.setHeaderText("Cannot Write Data to " + destPath);
            alert.showAndWait();
        }
    }

    @FXML
    private void saveData(ActionEvent event) {
        try {
            GlobalUtility.getDataUtility().writeItems(itemsAvailable.getItems());
            createAlert("Data Saved", "ItemData.csv Data written Successfully", "Data Saved Successfully", Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Writing Data");
            alert.setContentText(e.getMessage());
            alert.setHeaderText("Cannot Write Data to ItemsData.csv");
            alert.showAndWait();
        }
    }

    @FXML
    private void addItem(ActionEvent event) throws ParseException {
        String pno = tf_pno.getText();
        String pname = tf_pname.getText();
        String pmanufacturer = tf_manufacturer.getText();
        String pmrp = tf_mrp.getText();
        String pdiscount = tf_discount.getText();

        AvailableItem _availableItem = null;

        if (cb_perishable.isSelected()) {
            //String pexpiry = dateTimeFormatter.format(dp_expiry.getValue());
            String pexpiry = dp_expiry.getValue().toString();
            if (validateInput(pname, pmanufacturer, pno, pmrp, pdiscount, pexpiry)) {
                PerishableItem _perishableItem = new PerishableItem(
                        new Item(pname, pmanufacturer, pno, Double.parseDouble(pmrp), Double.parseDouble(pdiscount)),
                        DataUtility.dateFormat.parse(pexpiry));
                _availableItem = new AvailableItem(_perishableItem);
            }
        } else {
            if (validateInput(pname, pmanufacturer, pno, pmrp, pdiscount)) {
                Item _item = new Item(pname, pmanufacturer, pno, Double.parseDouble(pmrp), Double.parseDouble(pdiscount));
                _availableItem = new AvailableItem(_item);
            }
        }

        /* if avaialableItem was not null then add it to the list */
        if (_availableItem != null) {
            final AvailableItem toAdd = _availableItem;
            _availableItem.getDelButton().setOnAction(_event -> {
                itemsAvailable.getItems().remove(toAdd);
            });
            itemsAvailable.getItems().add(_availableItem);
            clearInput();
        }

    }

    private void clearInput() {
        tf_pno.setText("");
        tf_pname.setText("");
        tf_manufacturer.setText("");
        tf_mrp.setText("");
        tf_discount.setText("");
        cb_perishable.setSelected(false);
        dp_expiry.setDisable(true);
        dp_expiry.setValue(LocalDate.now());
    }

    @FXML
    private void cb_perishable_click(ActionEvent event) {
        if (cb_perishable.isSelected()) {
            dp_expiry.setDisable(false);
        } else {
            dp_expiry.setDisable(true);
        }
    }

    private boolean validateInput(String pname, String pmanufacturer, String pno, String pmrp, String pdiscount) {
        if (pname.equals("")) {
            createAlert("Error", "For example:  Potatoes", "Enter Product Name", Alert.AlertType.INFORMATION);
            return false;
        } else if (pmanufacturer.equals("")) {
            createAlert("Error", "For example: ACME", "Enter Manufacturer", Alert.AlertType.INFORMATION);
            return false;
        } else if (pno.equals("")) {
            createAlert("Error", "For example: 1234", "Enter Product Number, must be unique", Alert.AlertType.INFORMATION);
            return false;
        } else if (pmrp.equals("")) {
            createAlert("Error", "For example: 50.20", "Enter Product MRP", Alert.AlertType.INFORMATION);
            return false;
        } else if (pdiscount.equals("")) {
            createAlert("Error", "For example: 10.0", "Enter the product discount percentage", Alert.AlertType.INFORMATION);
            return false;
        }

        /* Check if the item already is there in our items list */
        AvailableItem foundItem = itemsAvailable.getItems().stream()
                .filter(x -> x.getItem().getProductNumber().equals(pno))
                .findFirst()
                .orElse(null);

        if (foundItem != null) {
            createAlert("Error", "Please enter a unique Product Number", pno + " already exists", Alert.AlertType.ERROR);
            return false;
        }

        /* Check for parsing errors */
        try {
            Integer.parseInt(pno);
        } catch (NumberFormatException e) {
            createAlert("Error", "Error Parsing the Product Number", e.getMessage(), Alert.AlertType.ERROR);
            return false;
        }

        try {
            Double.parseDouble(pmrp);
        } catch (NumberFormatException e) {
            createAlert("Error", "Error Parsing the Product MRP", e.getMessage(), Alert.AlertType.ERROR);
            return false;
        }

        try {
            Double.parseDouble(pdiscount);
        } catch (NumberFormatException e) {
            createAlert("Error", "Error Parsing the Product Discount", e.getMessage(), Alert.AlertType.INFORMATION);
            return false;
        }

        return true;
    }

    private boolean validateInput(String pname, String pmanufacturer, String pno, String pmrp, String pdiscount, String pexpiry) {
        Boolean prevValidation = validateInput(pname, pmanufacturer, pno, pmrp, pdiscount);
        if (prevValidation == false) {
            return false;
        }
        if (pexpiry.equals("")) {
            createAlert("Error", "For example: 1999/06/17", "Enter Product Expiry", Alert.AlertType.INFORMATION);
            return false;
        }
        return true;
    }

    private void createAlert(String title, String contextText, String headerText, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(contextText);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
}
