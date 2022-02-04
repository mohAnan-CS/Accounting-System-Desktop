package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.TransactionModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TwoTransactionController implements Initializable {

    @FXML
    private TextField textFieldDebit2;

    @FXML
    private ComboBox comboBoxDebit2;

    @FXML
    private TextField textFieldRemainDebit2;

    @FXML
    private ComboBox comboBoxRemainDebit2;

    @FXML
    private TextField textFieldCredit2;

    @FXML
    private ComboBox comboBoxCredit2;

    @FXML
    private TextField textFieldRemainCredit2;

    @FXML
    private ComboBox comboBoxRemainCredit2;

    private Boolean checkTextEmpty = false, checkComboBoxEmpty = false, checkDebitCreditValid =false, checkComboBoxValid = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    @FXML
    void btnSubmitOnAction() {

        checkTextEmpty();
        if (!checkTextEmpty)
            return;
        checkComboBoxEmpty();
        if (!checkComboBoxEmpty)
            return;
        checkDebitCreditValid();
        if (!checkDebitCreditValid)
            return;
        checkComboBoxValid();
        if(!checkComboBoxValid)
            return;

        TransactionModel transactionModel = new TransactionModel();



    }



    private void populateComboBoxes()throws SQLException {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.fillComboBox(comboBoxDebit2 , comboBoxRemainDebit2 , comboBoxCredit2, comboBoxRemainCredit2);
    }

    private void checkTextEmpty(){

        try {

            if (textFieldDebit2.getText().trim().isEmpty() && textFieldCredit2.getText().isEmpty()
                    && textFieldRemainDebit2.getText().isEmpty() && textFieldRemainCredit2.getText().isEmpty()) {
                checkTextEmpty = false;
                throw new IllegalArgumentException("text field debit and credit is empty");
            } else if (textFieldDebit2.getText().trim().isEmpty() || textFieldRemainDebit2.getText().isEmpty()) {
                checkTextEmpty = false;
                throw new IllegalArgumentException("text field debit is empty");
            } else if (textFieldCredit2.getText().trim().isEmpty() || textFieldRemainCredit2.getText().isEmpty()) {
                checkTextEmpty = false;
                throw new IllegalArgumentException("text field credit is empty");
            }
            else
                checkTextEmpty = true;

        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Error" , "ERROR" , illegalArgumentException.getMessage());
        }

    }

    private void checkComboBoxEmpty(){

        try {

            if (comboBoxCredit2.getSelectionModel().isEmpty() && comboBoxDebit2.getSelectionModel().isEmpty()
                    && comboBoxDebit2.getSelectionModel().isEmpty() && comboBoxRemainCredit2.getSelectionModel().isEmpty()) {
                checkComboBoxEmpty=false ;
                throw new IllegalArgumentException("combo box debit and credit empty ...");
            } else if (comboBoxDebit2.getSelectionModel().isEmpty() || comboBoxRemainDebit2.getSelectionModel().isEmpty()) {
                checkComboBoxEmpty=false;
                throw new IllegalArgumentException("combo box debit is empty");
            } else if (comboBoxCredit2.getSelectionModel().isEmpty() || comboBoxRemainCredit2.getSelectionModel().isEmpty()) {
                checkComboBoxEmpty=false;
                throw new IllegalArgumentException("combo box credit is empty");
            }else
                checkComboBoxEmpty=true;

        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Warning" , "WARNING" , illegalArgumentException.getMessage());
        }

    }

    private void checkDebitCreditValid(){

        try {

            int debitValue = Integer.parseInt(textFieldDebit2.getText().trim());
            int creditValue = Integer.parseInt(textFieldCredit2.getText().trim());

            if (debitValue != creditValue) {
                checkDebitCreditValid = false ;
                throw new IllegalArgumentException("Debit value must be equal Credit value");
            }else
                 checkDebitCreditValid=true;
        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Error" , "ERROR" , illegalArgumentException.getMessage());
        }

    }

    private void checkComboBoxValid(){

        try {

            String debitTypeAccount = (String) comboBoxDebit2.getSelectionModel().getSelectedItem();
            String debitRemainTypeAccount = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem();
            String creditTypeAccount = (String) comboBoxCredit2.getSelectionModel().getSelectedItem();
            String creditRemainTypeAccount = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem();

            String[] arrayComboBox = new String[]{debitTypeAccount, debitRemainTypeAccount, creditTypeAccount, creditRemainTypeAccount};
            String temp = debitTypeAccount;

            for (int i = 1; i < arrayComboBox.length; i++) {
                if (temp.equalsIgnoreCase(arrayComboBox[i])) {
                    checkComboBoxValid=false;
                    throw new IllegalArgumentException("duplicate of type account");
                }else
                    checkComboBoxValid=true;
            }
        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Error" , "ERROR" , illegalArgumentException.getMessage());
        }

    }

    private void showAlert(String titleAlert , String alertType , String contentText){

        if (alertType.equals("ERROR")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }else if (alertType.equals("WARNING")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }

    }


}
