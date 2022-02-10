package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.CurrencyModel;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable {

    @FXML
    private ComboBox comboBoxCurrency;

    @FXML
    private TextField textFieldCurrency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fillComboBox();

    }

    @FXML
    void btnCurrencyOnAction() {

    }

    @FXML
    void btnChangeOnAction() {


        if (!comboBoxCurrency.getSelectionModel().isEmpty()) {
            CurrencyModel.currentCurrency = (String) comboBoxCurrency.getSelectionModel().getSelectedItem();
            System.out.println(CurrencyModel.currentCurrency);
        }



    }

    private void fillComboBox(){

        CurrencyModel currencyModel = new CurrencyModel();
        ObservableList<String> list = FXCollections.observableArrayList();

        for (int i = 0 ; i < CurrencyModel.currencyArr.size() ; i++){

            list.add(CurrencyModel.currencyArr.get(i).getCurrencyType());

        }

        comboBoxCurrency.setItems(list);

    }

}
