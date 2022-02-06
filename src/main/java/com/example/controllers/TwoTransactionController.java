package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.TransactionModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TwoTransactionController implements Initializable {


    @FXML
    private TextField textFieldDebit2;

    @FXML
    private ComboBox<?> comboBoxDebit2;

    @FXML
    private TextArea textAreaDesDebit;

    @FXML
    private TextField textFieldRemainDebit2;

    @FXML
    private ComboBox comboBoxRemainDebit2;

    @FXML
    private TextArea textAreaDesRemainDebit;

    @FXML
    private TextField textFieldCredit2;

    @FXML
    private ComboBox comboBoxCredit2;

    @FXML
    private TextArea textAreaDesCredit;

    @FXML
    private TextField textFieldRemainCredit2;

    @FXML
    private ComboBox comboBoxRemainCredit2;

    @FXML
    private TextArea textAreaDesRemainCredit;

    private Boolean checkTextEmpty = false, checkComboBoxEmpty = false, checkDebitCreditValid =false, checkComboBoxValid = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            populateComboBoxes();
        } catch (SQLException e) {
            showAlert("Error" , "ERROR" , e.getMessage());
        }

    }

    @FXML
    void btnSubmitOnAction() {

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

            double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                    debitRemainValue = Double.parseDouble(textFieldRemainDebit2.getText().trim()),
                    creditValue = Double.parseDouble(textFieldCredit2.getText().trim()),
                    creditRemainValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());
            String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                    creditRemainType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                    debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem(),
                    debitRemainType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem();


            transactionModel.storeDebitCredit2(debitValue, creditValue, debitRemainValue, creditRemainValue,
                    creditRemainType, debitRemainType, debitType, creditType);

        }catch (SQLException sqlException){
            showAlert("Error" , "ERROR" , sqlException.getMessage());
        }

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

            int debitValue = Integer.parseInt(textFieldDebit2.getText().trim()),
                    creditValue = Integer.parseInt(textFieldCredit2.getText().trim()) ,
                    debitRemainValue = Integer.parseInt(textFieldRemainDebit2.getText().trim()) ,
                    creditRemainValue = Integer.parseInt(textFieldRemainCredit2.getText().trim()) ,
                    sumDebit , sumCredit;

            sumDebit = debitValue + debitRemainValue ;
            sumCredit = creditValue + creditRemainValue ;

            System.out.println("Sum debit = " + sumDebit);
            System.out.println("Sum credit = " + sumCredit);

            if (sumCredit != sumDebit) {
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
                System.out.println("hi");
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
