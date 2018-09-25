package com.debug.satyajit.billingsystem.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.debug.satyajit.billingsystem.utility.GlobalUtility;
import com.debug.satyajit.billingsystem.data.BillItemsData;
import com.debug.satyajit.billingsystem.data.ItemsAvailableData;
import com.debug.satyajit.billingsystem.models.AvailableItem;
import com.debug.satyajit.billingsystem.models.BillItem;
import com.debug.satyajit.billingsystem.models.Item;
import com.debug.satyajit.billingsystem.models.PerishableItem;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.DottedLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.InvalidationListener;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author shadowleaf
 */
public class GenerateBillController implements Initializable {

    @FXML
    private Button homeButton;
    
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
    private TableColumn<AvailableItem, ImageView> aperishable;
    
    @FXML
    private TextField search;
    
    /* Bill List Data */
    private BillItemsData billItemsData;
    
    /* The Bill List Table */
    @FXML
    private TableView<BillItem> billListTable;
    @FXML
    private TableColumn<BillItem, String> bl_no;
    @FXML
    private TableColumn<BillItem, String> bl_description;
    @FXML
    private TableColumn<BillItem, FloatProperty> bl_netprice;
    @FXML
    private TableColumn<BillItem, Spinner> bl_qty;
    @FXML
    private TableColumn<BillItem, FloatProperty> bl_value;
    @FXML
    private TableColumn<BillItem, FloatProperty> bl_savings;
    @FXML
    private TableColumn<BillItem, Button> bl_del;
    
    @FXML
    private Label grandTotal;
    @FXML
    private Label totalSavings;
    @FXML
    private Label totalItems;
    @FXML
    private TextField cust_name;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initItemsAvailableList();
        initBillList();
        
        grandTotal.setText("0.0");
        totalSavings.setText("0.0");
        totalItems.setText("0");
    }

    private void initItemsAvailableList() {
        itemsAvailable = new ItemsAvailableData();
        
        // Assign the Columns
        ano.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getProductNumber()));
        aproduct.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getProductName()));
        amanufacturer.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getManufacturerName()));
        amrp.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getMRP()));
        adiscount.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getItem().getDiscount()));
        aperishable.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getPerishableIndicator()));
        
        itemsAvailableTable.setItems(itemsAvailable.getItems());
        
        // Read the data from the CSV File
        try {
            readData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void initBillList() {
        billItemsData = new BillItemsData();
        InvalidationListener listener = (e) -> {
            billItemsData.calculateBill();
            updateBill();
        };
        
        billItemsData.getBillItems().addListener(listener);

        // Assign the Columns
        bl_no.setCellValueFactory(new PropertyValueFactory<>("productNumber"));
        bl_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        bl_netprice.setCellValueFactory(new PropertyValueFactory<>("netPrice"));
        bl_qty.setCellValueFactory(new PropertyValueFactory<>("qtySpinner"));
        bl_value.setCellValueFactory(new PropertyValueFactory<>("value"));
        bl_savings.setCellValueFactory(new PropertyValueFactory<>("savings"));
        bl_del.setCellValueFactory(new PropertyValueFactory<>("delButton"));

        billListTable.setItems(billItemsData.getBillItems());

    }

    @FXML
    private void goToHome(ActionEvent event) throws IOException {
        GlobalUtility.getScene().homeScene();
    }
 
    public void readData() throws IOException, FileNotFoundException, ParseException {
        /* clear all the items first */
        itemsAvailable.getItems().clear();

        GlobalUtility.getDataUtility().readItems().forEach(e -> itemsAvailable.getItems().add(new AvailableItem(e)));
    }

    @FXML
    private void search(KeyEvent event) {
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            itemsAvailable.getFilter().setPredicate((Predicate<? super AvailableItem>) (AvailableItem item) -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                } else if (item.getItem().getProductName().toLowerCase().contains(newValue.toLowerCase())
                        || item.getItem().getProductNumber().contains(newValue)) {
                    return true;
                }
                return false;
            });
        });
        
        itemsAvailable.setSortedList(new SortedList(itemsAvailable.getFilter()));
        itemsAvailable.getSortedList().comparatorProperty().bind(itemsAvailableTable.comparatorProperty());
        itemsAvailableTable.setItems(itemsAvailable.getSortedList());
    }

    @FXML
    private void addList(MouseEvent event) {
        Item _item = itemsAvailableTable.getSelectionModel().getSelectedItem().getItem();
        if (_item != null) {
            /* Check if the item is already in my Billing List */
            Optional<BillItem> result = billItemsData.getBillItems().stream().filter(x -> _item.getProductNumber().equals(x.getProductNumber())).findFirst();
            if (!result.isPresent()) {
                if (_item instanceof PerishableItem) {
                    if (((PerishableItem)_item).getExpiryDate().before(new Date())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Expired Item");
                        alert.setContentText(_item.getProductName() + " has expired on " + ((PerishableItem) _item).getExpiryDate());
                        alert.setHeaderText("The Item has expired");
                        alert.showAndWait();
                        return;
                    }
                }
                BillItem _billItem = new BillItem(_item);
                _billItem.delButton.setOnAction(_event -> {
                    billItemsData.getBillItems().remove(_billItem);
                });
                billItemsData.getBillItems().add(_billItem);
            }
        }
    }

    @FXML
    private void clearBillList(ActionEvent event) {
        billItemsData.getBillItems().clear();
    }

    private void updateBill() {
        grandTotal.setText(String.format("%4.2f", billItemsData.getGrandTotal().getValue()));
        totalSavings.setText(String.format("%4.2f", billItemsData.getTotalSavings().getValue()));
        totalItems.setText(String.format("%d",billItemsData.getTotalItems().getValue()));
    }

    @FXML
    private void generateBill(ActionEvent event) throws FileNotFoundException {
        
        if (cust_name.getText().equals("")) {
            createAlert("Customer Name", "Please Enter Customer Name", "Customer Name Empty");
            return;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
        String fileName = cust_name.getText()+"-"+dateFormat.format(new Date())+".pdf";
        PdfWriter writer = new PdfWriter(fileName);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        Text header = new Text("ACME Buy N Save\n").setFontSize(25);
        Text address = new Text("ACME Land\n");
        Text customerName = new Text("Customer Name : " + cust_name.getText() + "\n\n");
        document.add(new Paragraph(header).setTextAlignment(TextAlignment.CENTER).setBold());
        document.add(new Paragraph(address).setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph(customerName).setTextAlignment(TextAlignment.LEFT));
        
        Table table = new Table(new float[]{4, 1, 1, 1, 1});
        table.setWidth(UnitValue.createPercentValue(100));
        table.addHeaderCell(new Cell().add(new Paragraph("Description")).setBackgroundColor(ColorConstants.LIGHT_GRAY));
        table.addHeaderCell(new Cell().add(new Paragraph("Net Price")).setBackgroundColor(ColorConstants.LIGHT_GRAY));
        table.addHeaderCell(new Cell().add(new Paragraph("Qty")).setBackgroundColor(ColorConstants.LIGHT_GRAY));
        table.addHeaderCell(new Cell().add(new Paragraph("Value")).setBackgroundColor(ColorConstants.LIGHT_GRAY));
        table.addHeaderCell(new Cell().add(new Paragraph("Savings")).setBackgroundColor(ColorConstants.LIGHT_GRAY));
        billItemsData.getBillItems().forEach(billItem -> {
            table.addCell(new Cell().add(new Paragraph(billItem.getDescription())));
            table.addCell(new Cell().add(new Paragraph(String.format("%4.2f",billItem.netPriceProperty().getValue())).setTextAlignment(TextAlignment.RIGHT)));
            table.addCell(new Cell().add(new Paragraph(String.format("%6d",billItem.quantityProperty().getValue())).setTextAlignment(TextAlignment.RIGHT)));
            table.addCell(new Cell().add(new Paragraph(String.format("%4.2f",billItem.valueProperty().getValue())).setTextAlignment(TextAlignment.RIGHT)));
            table.addCell(new Cell().add(new Paragraph(String.format("%4.2f",billItem.savingsProperty().getValue())).setTextAlignment(TextAlignment.RIGHT)));
        });

        document.add(table);
        
        Text balanceDue = new Text("\n\nBalance Due: " + String.format("%.2f", billItemsData.getGrandTotal().getValue())+"\n");
        Text goodsSold = new Text("Total Number of Items Sold: " + billItemsData.getTotalItems().getValue()+"\n");
        Text savings = new Text("You Saved : " + String.format("%.2f", billItemsData.getTotalSavings().getValue()) + " !\n").setFontSize(20);
        Paragraph summary = new Paragraph();
        summary.add(balanceDue);
        summary.add(goodsSold);
        summary.add(savings);
        document.add(summary);
        
        Text dateTimePurchase = new Text("Date Of Purchase : " + new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss").format(new Date())+"\n\n").setTextAlignment(TextAlignment.RIGHT);
        document.add(new Paragraph(dateTimePurchase).setTextAlignment(TextAlignment.RIGHT));
        
        Text thankYouMessage = new Text("\n*Thank You ! Please Visit Again*\n").setFontSize(18);
        document.add(new Paragraph(thankYouMessage).setTextAlignment(TextAlignment.CENTER));
        
        document.add(new LineSeparator(new DottedLine(1, 2)));
        
        document.close();
        
        createAlert("PDF Generated", fileName + " saved Successfully", "PDF Generated Successfully");
        cust_name.setText("");
    }
 
    private void createAlert(String title, String contextText, String headerText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(contextText);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}
