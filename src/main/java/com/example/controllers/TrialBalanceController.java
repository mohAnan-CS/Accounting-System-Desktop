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

//        CurrencyModel c = new CurrencyModel();
//        String url = "https://currencies.apps.grandtrunk.net/getlatest/USD/"+c.currentCurrency;
//        double currencyValue = Double.parseDouble( c.readFromWeb( url ) );

        for (int i = 0 ; i < listAccount.size() ; i++){
//            String str;
//            double amount=0;
//
//            if ( ( trialBalanceModel.getBalance(listAccount.get(i)) ).getCredit().isEmpty() ){
//
//                str = ( trialBalanceModel.getBalance(listAccount.get(i)) ).getDebit();
//                amount = Double.parseDouble(str);
//                amount = amount * currencyValue;
//                trialBalanceModel.getBalance(listAccount.get(i)).setDebit(amount+"");
//                System.out.println(amount);
//            }
//            else {
//
//               str = ( trialBalanceModel.getBalance(listAccount.get(i)) ).getCredit();
//                amount = Double.parseDouble(str);
//                amount = amount * currencyValue;
//                trialBalanceModel.getBalance(listAccount.get(i)).setCredit(amount+"");
//            }

            TrialBalanceTableView trialBalanceTableView = trialBalanceModel.getBalance(listAccount.get(i));
            listTrialBalanceTableView.add(trialBalanceTableView);

        }

        tableViewTrialBalance.setItems(listTrialBalanceTableView);
    }

}
