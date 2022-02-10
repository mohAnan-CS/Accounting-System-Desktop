package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML
    private TableView<?> tableViewAccount;

    @FXML
    private TableColumn<?, ?> refCell;

    @FXML
    private TableColumn<?, ?> typeCell;

    @FXML
    private TableColumn<?, ?> nameCell;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
