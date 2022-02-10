package com.example.controllers;

import com.example.controllers.TableViewClass.GeneralLedgerTableView;
import com.example.controllers.TableViewClass.TrialBalanceTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CurrencyModel;
import model.GeneralLedger;
import model.GeneralLedgerModel;
import model.TrialBalanceModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TrialBalanceController implements Initializable {

    @FXML
    private TableView<TrialBalanceTableView> tableViewTrialBalance;

    @FXML
    private TableColumn<TrialBalanceTableView, String> accountCell;

    @FXML
    private TableColumn<TrialBalanceTableView, String> debitCell;

    @FXML
    private TableColumn<TrialBalanceTableView, String> creditCell;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setAllCellValueFactory();
        try {
            fillLedgerList();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    private void setAllCellValueFactory(){

        this.accountCell.setCellValueFactory(new PropertyValueFactory<>("account"));
        this.debitCell.setCellValueFactory(new PropertyValueFactory<>("debit"));
        this.creditCell.setCellValueFactory(new PropertyValueFactory<>("credit"));

    }

    private void fillLedgerList() throws SQLException, IOException {

        TrialBalanceModel trialBalanceModel = new TrialBalanceModel();
        GeneralLedgerModel generalLedgerModel = new GeneralLedgerModel();
        ObservableList<String> listAccount = generalLedgerModel.Accounts();
        ObservableList<TrialBalanceTableView> listTrialBalanceTableView = FXCollections.observableArrayList();

        CurrencyModel c = new CurrencyModel();
        System.out.println(c.getArr());
        double ans =  c.currencyArr.get(c.getArr()).getCurrencyValue();
        for (int i = 0 ; i < listAccount.size() ; i++) {
                int flag1=0,flag2=0;

            if (c.checkNumber(trialBalanceModel.getBalance(listAccount.get(i)).getDebit()) ){

                flag1=1;
            }
            if (c.checkNumber(trialBalanceModel.getBalance(listAccount.get(i)).getCredit()) ){

                flag2=1;
            }
            TrialBalanceTableView trialBalanceTableView = trialBalanceModel.getBalance(listAccount.get(i));
            if ( flag1 == 1 || flag2 == 1 ) {


                    if (flag1 == 1 ) {
                        double ansDebit = Double.parseDouble(trialBalanceTableView.getDebit());
                        double balance1 = ansDebit * ans;
                        trialBalanceTableView.setDebit(balance1 + "");

                    }

                    if (flag2 == 1) {
                        double ansCredit = Double.parseDouble(trialBalanceTableView.getCredit());
                        double balance = ansCredit * ans;
                        trialBalanceTableView.setCredit(balance + ".");

                    }
        }

            listTrialBalanceTableView.add(trialBalanceTableView);

        }

        tableViewTrialBalance.setItems(listTrialBalanceTableView);
    }

}
