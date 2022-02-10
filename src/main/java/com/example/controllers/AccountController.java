package com.example.controllers;

import com.example.controllers.TableViewClass.AccountTableView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Account;
import model.AccountModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML
    private TableView<Account> tableView;

    @FXML
    private TableColumn<Account, Integer> refCell;

    @FXML
    private TableColumn<Account, String> nameCell;

    @FXML
    private TableColumn<Account, String> typeCell;
    ObservableList<Account> list ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setAllCellValueFactory();
            fillTableView();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    private void setAllCellValueFactory(){

        this.refCell.setCellValueFactory(new PropertyValueFactory<>("ref"));
        this.typeCell.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.nameCell.setCellValueFactory(new PropertyValueFactory<>("name"));


    }


    private void fillTableView()throws SQLException {
        System.out.println("list");

        AccountModel accountModel = new AccountModel();
        list = accountModel.getAccounts();

        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i).toString());
        }

        tableView.setItems(list);
    }
}
