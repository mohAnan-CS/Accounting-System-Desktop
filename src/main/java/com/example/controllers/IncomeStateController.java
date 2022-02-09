package com.example.controllers;

import com.example.controllers.TableViewClass.IncomeStateTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class IncomeStateController implements Initializable {

    @FXML
    private Text textFieldTotalRevenue;

    @FXML
    private TableView<IncomeStateTableView> tableViewTotalRevenue;

    @FXML
    private TableColumn<IncomeStateTableView, String> expensesCell;

    @FXML
    private TableColumn<IncomeStateTableView, String> balanceCell;

    @FXML
    private Text textFieldTotalBalance;

    @FXML
    private Text textFieldOperatingIncome;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAllCellValueFactory();
    }

    private void setAllCellValueFactory(){

        this.expensesCell.setCellValueFactory(new PropertyValueFactory<>("expense"));
        this.balanceCell.setCellValueFactory(new PropertyValueFactory<>("balance"));

    }

    private void fillTableView(){



    }

}
