package com.example.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.GeneralJournalModel;
import model.GeneralLedgerModel;
import model.TransactionModel;
import model.TrialBalanceModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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

    private Boolean checkTextEmpty = false, checkComboBoxEmpty = false, checkDebitCreditValid = false, checkComboBoxValid = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            populateComboBoxes();
        } catch (SQLException e) {
            showAlert("Error", "ERROR", e.getMessage());
        }

    }

    @FXML
    void btnSubmitOnAction() {


//        checkTextEmpty();
//        if (!checkTextEmpty)
//            return;
//        checkComboBoxEmpty();
//        if (!checkComboBoxEmpty)
//            return;
//        checkDebitCreditValid();
//        if (!checkDebitCreditValid)
//            return;
        checkComboBoxValid();
        if (!checkComboBoxValid)
            return;

        if (!textFieldDebit2.getText().trim().equalsIgnoreCase("") && !textFieldCredit2.getText().trim().equalsIgnoreCase("") &&
                !textFieldRemainCredit2.getText().trim().equalsIgnoreCase("") && !textFieldRemainDebit2.getText().trim().equalsIgnoreCase("")) {
            System.out.println("submit if 0");
            storeDebitCreditInDataBase(0);
        }
        else if (!textFieldDebit2.getText().trim().equalsIgnoreCase("") &&!textFieldCredit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldRemainCredit2.getText().trim().equalsIgnoreCase("") ){
            storeDebitCreditInDataBase(1);
        }else if (!textFieldDebit2.getText().trim().equalsIgnoreCase("") &&!textFieldRemainDebit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldCredit2.getText().trim().equalsIgnoreCase("")){
            storeDebitCreditInDataBase(2);
        }else if (!textFieldDebit2.getText().trim().equalsIgnoreCase("") &&!textFieldRemainDebit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldRemainCredit2.getText().trim().equalsIgnoreCase("")){
            storeDebitCreditInDataBase(3);
        }else if (!textFieldDebit2.getText().trim().equalsIgnoreCase("") &&!textFieldRemainDebit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldRemainCredit2.getText().trim().equalsIgnoreCase("")){
            storeDebitCreditInDataBase(4);
        }else if (!textFieldRemainDebit2.getText().trim().equalsIgnoreCase("") &&!textFieldCredit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldRemainCredit2.getText().trim().equalsIgnoreCase("")){
            storeDebitCreditInDataBase(5);
        }else if (!textFieldDebit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldCredit2.getText().trim().equalsIgnoreCase("")){
            storeDebitCreditInDataBase(6);
        }else if (!textFieldDebit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldRemainCredit2.getText().trim().equalsIgnoreCase("")){
            storeDebitCreditInDataBase(7);
        }else if (!textFieldCredit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldRemainDebit2.getText().trim().equalsIgnoreCase("") ){
            storeDebitCreditInDataBase(8);
        }else if (!textFieldRemainDebit2.getText().trim().equalsIgnoreCase("")
                &&!textFieldRemainCredit2.getText().trim().equalsIgnoreCase("")){
            storeDebitCreditInDataBase(9);
        }

    }

    private void storeDebitCreditInDataBase(int flag) {

        //flag = 0 -> debit , remain debit  , credit  , remain credit
        //flag = 1 -> debit , credit , remain credit
        //flag = 2 -> debit , remain debit , credit
        //flag = 3 -> debit , remain debit , remain credit
        //flag = 4 -> debit , credit , remain credit
        //flag = 5 -> remain debit  , credit  , remain credit
        //flag = 6 -> debit , credit
        //flag = 7 -> debit , remain credit
        //flag = 8 -> credit , remain debit
        //flag = 9 -> remain credit , remain debit
        try {

            if (flag == 0) {
                System.out.println("store debit credit data base");
                TransactionModel transactionModel = new TransactionModel();

                double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                        debitRemainValue = Double.parseDouble(textFieldRemainDebit2.getText().trim()),
                        creditValue = Double.parseDouble(textFieldCredit2.getText().trim()),
                        creditRemainValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());

                String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                        creditRemainType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                        debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem(),
                        debitRemainType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem();

                String descriptionDebit = textAreaDesDebit.getText();
                String descriptionRemainDebit = textAreaDesRemainDebit.getText();
                String descriptionCredit = textAreaDesCredit.getText();
                String descriptionRemainCredit = textAreaDesRemainCredit.getText();

                transactionModel.storeDebitCredit2(debitValue, creditValue, debitRemainValue, creditRemainValue,
                        creditRemainType, debitRemainType, debitType, creditType,
                        descriptionDebit, descriptionRemainDebit, descriptionCredit, descriptionRemainCredit);
            } else if (flag == 1) {

                double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                        creditValue = Double.parseDouble(textFieldCredit2.getText().trim()),
                        creditRemainValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());

                String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                        creditRemainType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                        debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem();

                String descriptionDebit = textAreaDesDebit.getText();
                String descriptionCredit = textAreaDesCredit.getText();
                String descriptionRemainCredit = textAreaDesRemainCredit.getText();

                TransactionModel transactionModel = new TransactionModel();
                transactionModel.storeDebitCredit2(debitValue, creditValue, 0, creditRemainValue,
                        creditRemainType, "", debitType, creditType,
                        descriptionDebit, "", descriptionCredit, descriptionRemainCredit);

            }
            else if (flag == 2) {

                double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                        remainDebitValue = Double.parseDouble(textFieldRemainDebit2.getText().trim()),
                        creditValue = Double.parseDouble(textFieldCredit2.getText().trim());

                String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                        debitRemainType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem(),
                        debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem();

                String descriptionDebit = textAreaDesDebit.getText();
                String descriptionCredit = textAreaDesCredit.getText();
                String descriptionRemainDebit = textAreaDesRemainDebit.getText();

                TransactionModel transactionModel = new TransactionModel();
                transactionModel.storeDebitCredit2(debitValue , creditValue , remainDebitValue ,0 ,
                        "" , debitRemainType , debitType , creditType , descriptionDebit , descriptionRemainDebit , descriptionCredit , "");

            }else if (flag == 3){

                double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                        remainDebitValue = Double.parseDouble(textFieldRemainDebit2.getText().trim()),
                        remainCreditValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());

                String remainCreditType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                        debitRemainType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem(),
                        debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem();

                String descriptionDebit = textAreaDesDebit.getText();
                String descriptionRemainCredit = textAreaDesRemainCredit.getText();
                String descriptionRemainDebit = textAreaDesRemainDebit.getText();

                TransactionModel transactionModel = new TransactionModel();
                transactionModel.storeDebitCredit2(debitValue , 0 , remainDebitValue ,remainCreditValue ,
                        remainCreditType , debitRemainType , debitType , "" , descriptionDebit , descriptionRemainDebit , "" , descriptionRemainCredit);

            }
            else if (flag == 4){
                TransactionModel transactionModel = new TransactionModel();

                double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                        creditValue = Double.parseDouble(textFieldCredit2.getText().trim()),
                        creditRemainValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());

                String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                        creditRemainType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                        debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem();

                String descriptionDebit = textAreaDesDebit.getText();
                String descriptionCredit = textAreaDesCredit.getText();
                String descriptionRemainCredit = textAreaDesRemainCredit.getText();

                transactionModel.storeDebitCredit2(debitValue, creditValue, 0, creditRemainValue,
                        creditRemainType, "", debitType, creditType,
                        descriptionDebit, "", descriptionCredit, descriptionRemainCredit);
            }else if (flag==5 ){

                TransactionModel transactionModel = new TransactionModel();

                double debitRemainValue = Double.parseDouble(textFieldRemainDebit2.getText().trim()),
                        creditValue = Double.parseDouble(textFieldCredit2.getText().trim()),
                        creditRemainValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());

                String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                        creditRemainType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                        debitRemainType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem();

                String descriptionRemainDebit = textAreaDesRemainDebit.getText();
                String descriptionCredit = textAreaDesCredit.getText();
                String descriptionRemainCredit = textAreaDesRemainCredit.getText();

                transactionModel.storeDebitCredit2(0, creditValue, debitRemainValue, creditRemainValue,
                        creditRemainType, debitRemainType, "", creditType,
                        "", descriptionRemainDebit, descriptionCredit, descriptionRemainCredit);

            }else if (flag == 6){

                TransactionModel transactionModel = new TransactionModel();

                double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                        creditValue = Double.parseDouble(textFieldCredit2.getText().trim());

                String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                        debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem();


                String descriptionDebit = textAreaDesDebit.getText();
                String descriptionCredit = textAreaDesCredit.getText();


                transactionModel.storeDebitCredit1(debitValue, creditValue ,debitType, creditType,
                        descriptionDebit, descriptionCredit);

            }
            else if (flag == 7){

                TransactionModel transactionModel = new TransactionModel();

                double debitValue = Double.parseDouble(textFieldDebit2.getText().trim()),
                        remainCreditValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());

                String remainCreditType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                        debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem();


                String descriptionDebit = textAreaDesDebit.getText();
                String descriptionRemainCredit = textAreaDesRemainCredit.getText();


                transactionModel.storeDebitCredit1(debitValue, remainCreditValue ,debitType, remainCreditType,
                        descriptionDebit, descriptionRemainCredit);

            }
            else if (flag == 8){
                TransactionModel transactionModel = new TransactionModel();

                double remainDebitValue = Double.parseDouble(textFieldRemainDebit2.getText().trim()),
                        creditValue = Double.parseDouble(textFieldCredit2.getText().trim());

                String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem(),
                        remainDebitType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem();


                String descriptionRemainDebit = textAreaDesRemainDebit.getText();
                String descriptionCredit = textAreaDesCredit.getText();


                transactionModel.storeDebitCredit1(remainDebitValue, creditValue ,remainDebitType, creditType,
                        descriptionRemainDebit, descriptionCredit);
            }
            else if (flag ==9 ){
                TransactionModel transactionModel = new TransactionModel();

                double remainDebitValue = Double.parseDouble(textFieldRemainDebit2.getText().trim()),
                        remainCreditValue = Double.parseDouble(textFieldRemainCredit2.getText().trim());

                String remainCreditType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem(),
                        remainDebitType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem();


                String descriptionRemainDebit = textAreaDesRemainDebit.getText();
                String descriptionRemainCredit = textAreaDesRemainCredit.getText();


                transactionModel.storeDebitCredit1(remainDebitValue, remainCreditValue ,remainDebitType, remainCreditType,
                        descriptionRemainDebit, descriptionRemainCredit);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            showAlert("Error", "ERROR", sqlException.getMessage());
        }


    }


    private void populateComboBoxes() throws SQLException {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.fillComboBox(comboBoxDebit2, comboBoxRemainDebit2, comboBoxCredit2, comboBoxRemainCredit2);
    }

    private void checkTextEmpty() {

        try {

//            if (textFieldDebit2.getText().trim().isEmpty() && textFieldCredit2.getText().isEmpty()
//                    && textFieldRemainDebit2.getText().isEmpty() && textFieldRemainCredit2.getText().isEmpty()) {
//                checkTextEmpty = false;
//                throw new IllegalArgumentException("text field debit and credit is empty");
//            } else if (textFieldDebit2.getText().trim().isEmpty() || textFieldRemainDebit2.getText().isEmpty()) {
//                checkTextEmpty = false;
//                throw new IllegalArgumentException("text field debit is empty");
//            } else if (textFieldCredit2.getText().trim().isEmpty() || textFieldRemainCredit2.getText().isEmpty()) {
//                checkTextEmpty = false;
//                throw new IllegalArgumentException("text field credit is empty");
//            }
//            else
//                checkTextEmpty = true;

            if (textFieldDebit2.getText().isEmpty() && textFieldRemainDebit2.getText().isEmpty()) {
                checkTextEmpty = false;
                throw new IllegalArgumentException("pleas fill debit value");
            } else if (textFieldCredit2.getText().isEmpty() && textFieldRemainCredit2.getText().isEmpty()) {
                checkTextEmpty = false;
                throw new IllegalArgumentException("pleas fill credit value");
            } else
                checkTextEmpty = true;

        } catch (IllegalArgumentException illegalArgumentException) {
            showAlert("Error", "ERROR", illegalArgumentException.getMessage());
        }

    }

    private void checkComboBoxEmpty() {

        try {

//            if (comboBoxCredit2.getSelectionModel().isEmpty() && comboBoxDebit2.getSelectionModel().isEmpty()
//                    && comboBoxDebit2.getSelectionModel().isEmpty() && comboBoxRemainCredit2.getSelectionModel().isEmpty()) {
//                checkComboBoxEmpty=false ;
//                throw new IllegalArgumentException("combo box debit and credit empty ...");
//            } else if (comboBoxDebit2.getSelectionModel().isEmpty() || comboBoxRemainDebit2.getSelectionModel().isEmpty()) {
//                checkComboBoxEmpty=false;
//                throw new IllegalArgumentException("combo box debit is empty");
//            } else if (comboBoxCredit2.getSelectionModel().isEmpty() || comboBoxRemainCredit2.getSelectionModel().isEmpty()) {
//                checkComboBoxEmpty=false;
//                throw new IllegalArgumentException("combo box credit is empty");
//            }else
//                checkComboBoxEmpty=true;

            if (!textFieldDebit2.getText().isEmpty()) {
                if (comboBoxDebit2.getSelectionModel().isEmpty()) {
                    checkComboBoxEmpty = false;
                    throw new IllegalArgumentException("combo box debit is empty");
                }
            } else if (!textFieldRemainDebit2.getText().isEmpty()) {
                if (comboBoxRemainDebit2.getSelectionModel().isEmpty()) {
                    checkComboBoxEmpty = false;
                    throw new IllegalArgumentException("combo box remain debit is empty");
                }
            } else if (!textFieldCredit2.getText().isEmpty()) {
                if (comboBoxCredit2.getSelectionModel().isEmpty()) {
                    checkComboBoxEmpty = false;
                    throw new IllegalArgumentException("combo box credit is empty");
                }
            } else if (!textFieldRemainCredit2.getText().isEmpty()) {
                if (comboBoxCredit2.getSelectionModel().isEmpty()) {
                    checkComboBoxEmpty = false;
                    throw new IllegalArgumentException("combo box remain credit is empty");
                }
            } else
                checkComboBoxEmpty = true;

        } catch (IllegalArgumentException illegalArgumentException) {
            showAlert("Warning", "WARNING", illegalArgumentException.getMessage());
        }

    }

    private void checkDebitCreditValid() {

        try {

            int debitValue = Integer.parseInt(textFieldDebit2.getText().trim()),
                    creditValue = Integer.parseInt(textFieldCredit2.getText().trim()),
                    debitRemainValue = Integer.parseInt(textFieldRemainDebit2.getText().trim()),
                    creditRemainValue = Integer.parseInt(textFieldRemainCredit2.getText().trim()),
                    sumDebit, sumCredit;

            sumDebit = debitValue + debitRemainValue;
            sumCredit = creditValue + creditRemainValue;

            System.out.println("Sum debit = " + sumDebit);
            System.out.println("Sum credit = " + sumCredit);

            if (sumCredit != sumDebit) {
                checkDebitCreditValid = false;
                throw new IllegalArgumentException("Debit value must be equal Credit value");
            } else
                checkDebitCreditValid = true;
        } catch (IllegalArgumentException illegalArgumentException) {
            showAlert("Error", "ERROR", illegalArgumentException.getMessage());
        }

    }

    private void checkComboBoxValid() {

        try {

            System.out.println("check combo box");

            String debitType = (String) comboBoxDebit2.getSelectionModel().getSelectedItem() ;
            String debitRemainType = (String) comboBoxRemainDebit2.getSelectionModel().getSelectedItem() ;
            String creditType = (String) comboBoxCredit2.getSelectionModel().getSelectedItem() ;
            String creditRemainType = (String) comboBoxRemainCredit2.getSelectionModel().getSelectedItem() ;

            String[] arrComboBox = new String[]{debitType , debitRemainType , creditType , creditRemainType};

            checkComboBoxValid =true ;
            for (int i = 0; i < arrComboBox.length; i++) {
                for (int j = i + 1 ; j < arrComboBox.length; j++) {
                    if (arrComboBox[i].trim().equalsIgnoreCase(arrComboBox[j].trim())) {
                        checkComboBoxValid = false ;
                        System.out.println(arrComboBox[i] + " == " + arrComboBox[j]);
                        System.out.println("check false");
                        throw new IllegalArgumentException("Wrong Combo box");
                    }
                    System.out.println(arrComboBox[i] + " = = " + arrComboBox[j]);
                    System.out.println(i);
                    System.out.println("-------------------");
                }
            }


        } catch (IllegalArgumentException illegalArgumentException) {
            showAlert("Error", "ERROR", illegalArgumentException.getMessage());
        }

    }

    private void showAlert(String titleAlert, String alertType, String contentText) {

        if (alertType.equals("ERROR")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        } else if (alertType.equals("WARNING")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }

    }


}
