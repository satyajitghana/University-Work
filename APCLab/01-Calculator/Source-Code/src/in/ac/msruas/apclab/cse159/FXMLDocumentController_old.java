/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ac.msruas.apclab.cse159;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.StringTokenizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author shadowleaf
 */
public class FXMLDocumentController_old implements Initializable {

    @FXML
    private Label resultLabel;
    @FXML
    private Label historyLabel;
    
    private Double result;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        historyLabel.setText("");
        resultLabel.setText("");
        result = 0d;
    }    

    @FXML
    private void clearClicked(ActionEvent event) {
        resultLabel.setText("");
        historyLabel.setText("");
        result = 0d;
    }

    @FXML
    private void buttonNumClicked(ActionEvent event) {
        Integer numClicked = Integer.parseInt(((Button)event.getSource()).getText());
        resultLabel.setText(resultLabel.getText()+numClicked.toString());
        historyLabel.setText(historyLabel.getText()+numClicked.toString());
    }

    @FXML
    private void buttonEqualsClicked(ActionEvent event) {
        String operators = "+-*/";
        StringTokenizer tokens = new StringTokenizer(historyLabel.getText(), operators, true);
        Stack valueStack = new Stack();
        while (tokens.hasMoreTokens()) {
            String _token = tokens.nextToken();
            if (operators.contains(_token)) {
                result = doCalculation((String)valueStack.pop() ,_token, (String)tokens.nextToken());
                valueStack.push(result.toString());
            }
            else
                valueStack.push(_token);
        }
        resultLabel.setText(result.toString());
        historyLabel.setText(result.toString());
    }

    private Double doCalculation(String op1, String opr, String op2) {
        Double res = 0d;
        try {
            Double num1 = Double.parseDouble(op1);
            Double num2 = Double.parseDouble(op2);

            switch(opr.charAt(0)) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
            }
        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if (e instanceof NumberFormatException) {
                alert.setTitle("Scientific Notation Detected");
                alert.setHeaderText("Error: cannot parse a Scientific Notation");
            } else {
                alert.setTitle("Unknown Error");
                alert.setHeaderText("Unkown Error");
            }
            alert.setContentText(e.toString());
            alert.showAndWait();
        }
        
        return res;
    }
    
    @FXML
    private void buttonOperatorClicked(ActionEvent event) {
        resultLabel.setText(((Button)event.getSource()).getText());
        historyLabel.setText(historyLabel.getText() + " " + ((Button)event.getSource()).getText() + " ");
    }

}
