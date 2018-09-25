/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debug.satyajit.billingsystem.utility;

import com.debug.satyajit.billingsystem.BillingApplication;
import com.debug.satyajit.billingsystem.utility.DataUtility;
import javafx.scene.image.Image;

/**
 *
 * @author shadowleaf
 */
public class GlobalUtility {
    private static final SceneChanger scene = new SceneChanger();
    public static final DataUtility data = new DataUtility("C:\\Users\\shadowleaf\\Documents\\NetBeansProjects\\BillingApplication\\resources\\data\\ItemData.csv");
    public static final String dataFolder = "C:\\Users\\shadowleaf\\Documents\\NetBeansProjects\\BillingApplication\\resources\\data\\";
    //private static DataUtility data;
    public static Image binIcon;

    public GlobalUtility() throws Exception {
        binIcon = new Image(BillingApplication.class.getResource("/images/bin.png").toString());
        //data = new DataUtility(BillingApplication.class.getResource("/data/ItemData.csv").toString());

    }
    /* returns an instance of the current scene */
    public static SceneChanger getScene() {
        return scene;
    }
    
    public static DataUtility getDataUtility() {
        return data;
    }
    
    public static Image getBin() {
        return binIcon;
    }
}
