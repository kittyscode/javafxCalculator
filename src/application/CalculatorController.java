package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField displayField;

    private double firstNumber;
    private String operator;
    

    @FXML
    private void handleNumber(ActionEvent event) {

        Button btn = (Button) event.getSource();

        if (displayField.getText().equals("0")) {
            displayField.setText(btn.getText());
        } else {
            displayField.setText(displayField.getText() + btn.getText());
        }
    }

    @FXML
    private void handleClear() {
        displayField.setText("0");
        firstNumber = 0;
        operator = null;
    }

    @FXML
    private void handleOperator(ActionEvent event) {

        if (displayField.getText().isEmpty()) {
            return;
        }

        Button btn = (Button) event.getSource();

        firstNumber = Double.parseDouble(displayField.getText());

        operator = btn.getText();

        displayField.setText("0");
        
    }

    @FXML
    private void handleEqual() {

        if (displayField.getText().isEmpty() || operator == null) {
            return;
        }

        double secondNumber = Double.parseDouble(displayField.getText());

        double result = 0;

        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
        } 
        else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        } 
        else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
        } 
        else if (operator.equals("/")) {

            if (secondNumber == 0) {
                displayField.setText("Error");
                return;
            }

            result = firstNumber / secondNumber;
        }

        if (result == (int) result) {
            displayField.setText(String.valueOf((int) result));
        } else {
            displayField.setText(String.valueOf(result));
        }

        firstNumber = result;
        operator = null;
    }
}