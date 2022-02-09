package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.UserSettingModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewUserController implements Initializable {

    @FXML
    private TextField textFieldId;

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
    private ComboBox comboBoxPermission;

    @FXML
    private TextField textFieldSalary;

    private Boolean checkComboBox = false , checkTextField = false ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prepareComboBox();


    }

    @FXML
    void btnAddUserOnAction() {

        checkTextFieldEmpty();
        if (checkTextField)
            return;
        checkComboBoxEmpty();
        if(checkComboBox)
            return;

        storeUserInformation();
        UserSettingController.newUserStage.close();


    }

    private void storeUserInformation(){

        try {
            UserSettingModel userSettingModel = new UserSettingModel();
            int userId = Integer.parseInt(textFieldId.getText().trim());
            String userFirstName= textFieldFirstName.getText().trim() ,
                    userLastName = textFieldLastName.getText().trim() ,
                    userPassword = textFieldPassword.getText().trim() ,
                    userAddress = textFieldAddress.getText().trim() ,
                    userPermission = (String) comboBoxPermission.getValue() ,
                    userPhone = textFieldPhone.getText().trim();
            double userSalary = Double.parseDouble(textFieldSalary.getText().trim());

            userSettingModel.addUser(userId , userFirstName , userLastName ,
                    userPassword , userPhone , userAddress , userPermission , userSalary);
        }catch (SQLException e){
            showAlert("Error" , "ERROR" , e.getMessage());
        }catch (Exception exception){
            showAlert("Error" , "ERROR" , exception.getMessage());
        }

    }

    private void checkTextFieldEmpty(){

        if (textFieldId.getText().trim().isEmpty()) {
            checkTextField = true;
            showAlert("Error", "ERROR", "pleas fill user id field");
        }else if (textFieldFirstName.getText().trim().isEmpty()){
            checkTextField = true;
            showAlert("Error", "ERROR", "pleas fill user first name field");
        }else if (textFieldLastName.getText().trim().isEmpty()){
            checkTextField = true;
            showAlert("Error", "ERROR", "pleas fill user last name field");
        }else if (textFieldSalary.getText().trim().isEmpty()){
            checkTextField = true;
            showAlert("Error", "ERROR", "pleas fill user Salary field");
        }else if (textFieldAddress.getText().trim().isEmpty()) {
            checkTextField = true;
            showAlert("Error", "ERROR", "pleas fill user address field");
        }else if (textFieldPhone.getText().trim().isEmpty()) {
            checkTextField = true;
            showAlert("Error", "ERROR", "pleas fill user phone field");
        }else if (textFieldPassword.getText().trim().isEmpty()) {
            checkTextField = true;
            showAlert("Error", "ERROR", "pleas fill user password field");
        }else
            checkTextField = false ;


        }

    private void checkComboBoxEmpty(){

        if (comboBoxPermission.getSelectionModel().isEmpty()) {
            checkComboBox =true ;
            showAlert("Error", "ERROR", "Combo box is empty");
        }else
            checkComboBox = false ;


    }

    private void prepareComboBox(){

        ObservableList<String> listAccountComboBox = FXCollections.observableArrayList();
        listAccountComboBox.add("Account");
        listAccountComboBox.add("Chive Account");

        comboBoxPermission.setItems(listAccountComboBox);

    }

    private void showAlert(String titleAlert , String alertType , String contentText){

        if (alertType.equals("ERROR")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }else if (alertType.equals("WARNING")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }

    }

}
