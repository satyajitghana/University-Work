package com.debug.satyajit.billingsystem.controllers;

import com.debug.satyajit.billingsystem.utility.GlobalUtility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HomeScreenController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane rootPane;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToGenerateBill(ActionEvent event) throws IOException {
        GlobalUtility.getScene().generateBillsScene();
    }

    @FXML
    private void goToManageInventory(ActionEvent event) throws IOException {
        GlobalUtility.getScene().manageInventoryScene();
    }
}
