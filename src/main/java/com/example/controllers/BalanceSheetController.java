package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import model.BalanceSheetModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BalanceSheetController implements Initializable {

    @FXML
    private Text textFieldCash;

    @FXML
    private Text textFieldRecivble;

    @FXML
    private Text textFieldSupplies;

    @FXML
    private Text textFieldEqipment;

    @FXML
    private Text textFieldPayable;

    @FXML
    private Text textFieldNotePayable;

    @FXML
    private Text textFieldSalary;

    @FXML
    private Text asset;

    @FXML
    private Text lib;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        try {
            setTextFieldValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void setTextFieldValue()throws SQLException {

        double cash , recivble , supplies , equipment , payable , notePayable , salary ;
        BalanceSheetModel balanceSheetModel = new BalanceSheetModel();
        cash = balanceSheetModel.sumOf("cash");
        recivble = balanceSheetModel.sumOf("Equipment");
        supplies = balanceSheetModel.sumOf("Supplise");
        equipment = balanceSheetModel.sumOf("Notes payable");
        payable = balanceSheetModel.sumOf("Salary and wages payable");
        notePayable = balanceSheetModel.sumOf("Accouunt payable");
        salary = balanceSheetModel.sumOf("Account recivble");

        textFieldCash.setText("Cash " + cash);
        textFieldRecivble.setText("recivble " + recivble);
        textFieldSalary.setText("Supplies =  " + supplies);
        textFieldEqipment.setText("Equpment = " + equipment);
        textFieldPayable.setText("Payable = " + payable);
        textFieldNotePayable.setText("notePayable " + notePayable);
        textFieldSalary.setText("salary " + salary);

        asset.setText("Total Asset = " + (cash + recivble + supplies +equipment));
        lib.setText("Total libelities = " + (payable + notePayable + salary));





    }
}
