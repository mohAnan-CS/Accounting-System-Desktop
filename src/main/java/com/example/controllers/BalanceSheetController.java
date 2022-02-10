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
        textFieldCash.setText("recivble " + recivble);
        textFieldCash.setText("supplies " + supplies);
        textFieldCash.setText("supplies " + supplies);
        textFieldCash.setText("equipment " + equipment);
        textFieldCash.setText("notePayable " + notePayable);
        textFieldCash.setText("salary " + salary);



    }
}
