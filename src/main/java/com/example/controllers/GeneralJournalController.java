package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.JournalLedger;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GeneralJournalController implements Initializable {

    @FXML
    private TableView<JournalLedger> tableViewJournalLedger;

    @FXML
    private TableColumn<JournalLedger, String> dateCell;

    @FXML
    private TableColumn<JournalLedger, String> accountTypeCell;

    @FXML
    private TableColumn<JournalLedger, String> refCell;

    @FXML
    private TableColumn<JournalLedger, String> debitCell;

    @FXML
    private TableColumn<JournalLedger, String> creditCell;

    ObservableList<JournalLedger> listJournal = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fillJournalList();
        setAllCellValueFactory();

    }

    public void setAllCellValueFactory(){

        //this.billTabelPaymentAmount.setCellValueFactory(new PropertyValueFactory("payAmount"));

        this.dateCell.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.accountTypeCell.setCellValueFactory(new PropertyValueFactory<>("accountType"));
        this.refCell.setCellValueFactory(new PropertyValueFactory<>("ref"));
        this.debitCell.setCellValueFactory(new PropertyValueFactory<>("debit"));
        this.creditCell.setCellValueFactory(new PropertyValueFactory<>("credit"));

        tableViewJournalLedger.setItems(listJournal);
    }

    private void fillJournalList(){


        JournalLedger journalLedger = new JournalLedger("10/1/2002" , "cash" , "101" , "192" , "");
        JournalLedger journalLedger2 = new JournalLedger("" , "owner" , "103" , "" , "192");
        listJournal.add(journalLedger);
        listJournal.add(journalLedger2);

    }

}
