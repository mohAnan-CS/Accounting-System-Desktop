package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.TransactionModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OneTransactionController implements Initializable {

    @FXML
    private TextField textFieldDebit;

    @FXML
    private ComboBox comboBoxDebit;

    @FXML
    private TextField textFieldCredit;

    @FXML
    private ComboBox comboBoxCredit;

    @FXML
    private TextArea textAreaDescriptionCredit;

    @FXML
    private TextArea textAreaDescriptionDebit;


    public void showAlertError(String errorMessage){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();

    }

    private Boolean checkTextEmpty = false,
            checkComboBoxEmpty = false,
            checkDebitCreditValid =false,
            checkComboBoxValid = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        populateComboBoxes();
    }

    @FXML
    void btnSubmitOneTransactionOnAction() throws SQLException {

        try {

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
            if (!checkComboBoxValid)
                return;

            TransactionModel transactionModel = new TransactionModel();
            double debitValue = Double.parseDouble(textFieldDebit.getText().trim()),
                    creditValue = Double.parseDouble(textFieldCredit.getText().trim());
            String debitType = (String) comboBoxDebit.getSelectionModel().getSelectedItem(),
                    creditType = (String) comboBoxCredit.getSelectionModel().getSelectedItem();
            String ex = textAreaDescriptionDebit.getText();
            String ex1 = textAreaDescriptionCredit.getText();
            transactionModel.storeDebitCredit1(debitValue, creditValue, debitType, creditType,ex,ex1);

        }catch (SQLException sqlException){
            showAlert("Error" , "ERROR" , sqlException.getMessage());
        }

    }

    private void populateComboBoxes(){

        try {
            System.out.println("combo box");
            TransactionModel transactionModel = new TransactionModel();
            transactionModel.fillComboBox(comboBoxDebit , comboBoxCredit);
        }catch (SQLException sqlException){
            showAlert("Error" , "ERROR" , sqlException.getMessage());
        }

    }

    private void checkTextEmpty(){

        try {

            if (textFieldDebit.getText().trim().isEmpty() && textFieldCredit.getText().isEmpty()) {
                checkTextEmpty=false;
                throw new IllegalArgumentException("text field debit and credit is empty");
            } else if (textFieldDebit.getText().trim().isEmpty()) {
                checkTextEmpty=false;
                throw new IllegalArgumentException("text field debit is empty");
            } else if (textFieldCredit.getText().trim().isEmpty()) {
                checkTextEmpty=false;
                throw new IllegalArgumentException("text field credit is empty");
            }else
                checkTextEmpty=true;

        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Warning" , "WARNING" , illegalArgumentException.getMessage());
        }

    }

    private void checkComboBoxEmpty(){

        try {

            if (comboBoxCredit.getSelectionModel().isEmpty() && comboBoxDebit.getSelectionModel().isEmpty()){
                checkComboBoxEmpty=false;
                throw new IllegalArgumentException("combo box debit and credit is empty");
            }
            else if (comboBoxDebit.getSelectionModel().isEmpty()){
                checkComboBoxEmpty=false;
                throw new IllegalArgumentException("combo box debit is empty");
            }
            else if (comboBoxCredit.getSelectionModel().isEmpty()){
                checkComboBoxEmpty=false;
                throw new IllegalArgumentException("combo box credit is empty");
            }else
                checkComboBoxEmpty=true;

        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Error" , "ERROR" , illegalArgumentException.getMessage());
        }


    }

    private void checkDebitCreditValid(){

        try {

            int debitValue = Integer.parseInt(textFieldDebit.getText().trim());
            int creditValue = Integer.parseInt(textFieldCredit.getText().trim());

            if (debitValue != creditValue){
                checkDebitCreditValid=false;
                throw new IllegalArgumentException("Debit value must be equal credit value");
            }else
                checkDebitCreditValid=true;

        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Error" , "ERROR" , illegalArgumentException.getMessage());
        }


    }

    private void checkComboBoxValid(){

        try {

            String debitTypeAccount = comboBoxDebit.getSelectionModel().getSelectedItem().toString();
            String creditTypeAccount = comboBoxCredit.getSelectionModel().getSelectedItem().toString();

            if (debitTypeAccount.equalsIgnoreCase(creditTypeAccount)){
                checkComboBoxValid=false;
                throw new IllegalArgumentException("debit type must be not equal credit type");
            }else
                checkComboBoxValid=true;

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
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("myDialogs.css").toExternalForm());
            dialogPane.getStyleClass().add("myDialog");
            alert.showAndWait();
        }

    }

}
