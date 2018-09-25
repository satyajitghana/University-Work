/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.utility;

import com.debug.satyajit.billingsystem.BillingApplication;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

/**
 *
 * @author shadowleaf
 */
public class SceneChanger {
    public void generateBillsScene() throws IOException {
        Stage primaryStage = BillingApplication.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GenerateBill.fxml"));
        new JMetro(JMetro.Style.DARK).applyTheme(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    public void homeScene() throws IOException {
        Stage primaryStage = BillingApplication.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeScreen.fxml"));
        new JMetro(JMetro.Style.DARK).applyTheme(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void manageInventoryScene() throws IOException {
        Stage primaryStage = BillingApplication.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ManageInventory.fxml"));
        new JMetro(JMetro.Style.DARK).applyTheme(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
