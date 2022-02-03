package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.ComboBoxInfo;
import model.DebitCredit;
import model.DebitCreditInfo;

import java.net.URL;
import java.util.ArrayList;
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
    void btnSubmitOneTransactionOnAction() {

        checkTextEmpty();
        checkComboBoxEmpty();

        DebitCreditInfo debitCreditInfo = new DebitCreditInfo("Mohammed anan" , "12/12/2022" ,
                Double.parseDouble(textFieldDebit.getText().trim()) , Double.parseDouble(textFieldCredit.getText().trim()) , comboBoxDebit.getValue().toString() ,
                 comboBoxCredit.getValue().toString());
        DebitCredit debitCredit = new DebitCredit();
        debitCredit.storeDebitCredit(debitCreditInfo);

        ArrayList arrayList = new ArrayList();
        arrayList = debitCredit.getArrayListDebitCredit();
        for (int i = 0 ; i< arrayList.size() ; i++){
            System.out.println(arrayList.get(i));
        }

    }

    public void checkTextEmpty(){

        if (textFieldDebit.getText().trim().isEmpty() && textFieldCredit.getText().isEmpty()){
            showAlertError("debit and credit empty");
        }
        else if (textFieldDebit.getText().trim().isEmpty()){
            showAlertError("debit is empty");
        }
        else if (textFieldCredit.getText().trim().isEmpty()){
            showAlertError("credit is empty");
        }

    }

    public void checkComboBoxEmpty(){

        if (comboBoxCredit.getValue().equals(null) && comboBoxDebit.getValue().equals(null)){
            showAlertError("combo box debit and credit empty");
        }
        else if (comboBoxDebit.getValue().equals(null)){
            showAlertError("combo box debit is empty");
        }
        else if (comboBoxCredit.getValue().equals(null)){
            showAlertError("combo box credit is empty");
        }

    }

    public void showAlertError(String errorMessage){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prepareComboBox();


    }

    private void prepareComboBox(){

        ComboBoxInfo comboBoxInfo = new ComboBoxInfo();
        comboBoxInfo.fillComboBox(comboBoxDebit);
        comboBoxInfo.fillComboBox(comboBoxCredit);

    }
}
