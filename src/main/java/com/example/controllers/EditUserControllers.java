package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class EditUserControllers {

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private TextField textFieldAddress;

    @FXML
    private ComboBox<?> comboBoxPermission;

    @FXML
    private Spinner<?> spinnerSalary;

    @FXML
    void btnEditUserOnAction(ActionEvent event) {

    }
}
