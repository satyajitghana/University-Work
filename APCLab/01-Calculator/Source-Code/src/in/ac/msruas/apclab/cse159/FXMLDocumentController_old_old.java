/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ac.msruas.apclab.cse159;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author shadowleaf
 */
public class FXMLDocumentController_old_old implements Initializable {

    @FXML
    private Label resultLabel;
    
    private Float numOne = null, numTwo = null, result = null;
    private Character operator = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonClicked(ActionEvent event) {
        resultLabel.setText(resultLabel.getText()+((Button)event.getSource()).getText());
        System.out.println(((Button)event.getSource()).getText());
    }

    @FXML
    private void buttonNumClicked(ActionEvent event) {
        Float num = Float.parseFloat(((Button)event.getSource()).getText());
        resultLabel.setText(resultLabel.getText()+num.toString());

        System.out.println(num);
        
        if (operator != null && numOne != null) {
//            Float _res = performOperation(numOne, num, operator);
//            // resultLabel.setText(_res.toString());
//            result = _res;
//            operator = null;
            numTwo = num;
        } else {
            numOne = num;
        }
        
        
    }

    @FXML
    private void buttonEqualsClicked(ActionEvent event) {
        resultLabel.setText(result.toString());
        numOne = null;
                numOne = result;

        result = null;
        
    }

    @FXML
    private void buttonOperatorClicked(ActionEvent event) {
        if (operator == null) {
            operator = ((Button)event.getSource()).getText().charAt(0);
            resultLabel.setText("");
        }
        if (numOne != null && operator != null && numTwo != null) {
            Float _res = performOperation(numOne, numTwo, operator);
            numOne = _res;
            numTwo = null;
            result = null;
            operator = ((Button)event.getSource()).getText().charAt(0);
            resultLabel.setText(numOne.toString());
        }
    }
    
    private Float performOperation(Float numOne, Float numTwo, Character operation) {
        Float res = 0f;
        switch(operation) {
            case '+':
                res = numOne + numTwo;
                break;
            case '-':
                res = numOne - numTwo;
                break;
            case '/':
                res = numOne / numTwo;
                break;
            case '*':
                res = numOne * numTwo;
        }
        return res;
    }
    
}
