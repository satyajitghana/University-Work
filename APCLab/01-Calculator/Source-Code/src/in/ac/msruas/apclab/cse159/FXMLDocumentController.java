/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ac.msruas.apclab.cse159;

import java.net.URL;
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
public class FXMLDocumentController implements Initializable {

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
        Integer numClicked = Integer.parseInt(((Button) event.getSource()).getText());
        resultLabel.setText(resultLabel.getText() + numClicked.toString());
        historyLabel.setText(historyLabel.getText() + numClicked.toString());
    }

    @FXML
    private void buttonEqualsClicked(ActionEvent event) {
        parseEquation();
    }
      
    @FXML
    private void buttonOperatorClicked(ActionEvent event) {
        resultLabel.setText(((Button) event.getSource()).getText());
        historyLabel.setText(historyLabel.getText() + " " + ((Button) event.getSource()).getText() + " ");
    }

    private String operators = "-+*/";

    private void parseEquation() {
        /* To Remove thw White Spaces */
        String toParse = historyLabel.getText().replace(" ", "");
        /* Tokenize the String */
        StringTokenizer tokens = new StringTokenizer(toParse, this.operators, true);
        Stack<String> valueStack = new Stack();
        Stack<String> operatorStack = new Stack();

        String _token = tokens.nextToken();
        /* If there is a negative at the beginning */
        if (_token.equals("-")) {
            valueStack.push("-" + Double.parseDouble(tokens.nextToken()));
        } else {
            valueStack.push(_token);
        }
        while (tokens.hasMoreTokens()) {
            _token = tokens.nextToken();
            if (operators.contains(_token)) {
                while (!operatorStack.isEmpty() && (operators.indexOf(_token) <= operators.indexOf(operatorStack.peek()))) {
                    String temp = valueStack.pop();
                    valueStack.push(doCalculation(valueStack.pop(), operatorStack.pop(), temp));
                }
                operatorStack.push(_token);
                _token = tokens.nextToken();
                /* If there is a negative number */
                if (_token.equals("-")) {
                    valueStack.push("-"+Double.parseDouble(tokens.nextToken()));
                } else {
                    valueStack.push(_token);
                }
            } else {
                valueStack.push(_token);
            }
        }
        String answer = evaluateExpression(operatorStack, valueStack);
        resultLabel.setText(answer);
        historyLabel.setText(answer);
    }

    private String evaluateExpression(Stack<String> operatorStack, Stack<String> valueStack) {
        while (!operatorStack.isEmpty()) {
            String temp = valueStack.pop();
            valueStack.push(doCalculation(valueStack.pop(), operatorStack.pop(), temp));
        }
        return valueStack.pop();
    }

    private String doCalculation(String op1, String opr, String op2) {
        Double result = 0d;
        try {
            Double num1 = Double.parseDouble(op1);
            Double num2 = Double.parseDouble(op2);

            switch (opr.charAt(0)) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
        } catch (Exception e) {
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

        return result.toString();
    }

}
