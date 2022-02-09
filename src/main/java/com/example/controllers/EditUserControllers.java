package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.User;
import model.UserSettingModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditUserControllers implements Initializable {

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private TextField textFieldAddress;

    @FXML
    private TextField textFieldSalary;

    @FXML
    private TextField textFieldUserId;

    @FXML
    private ComboBox comboBoxPermission;

    private Boolean checkText = false ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fillDataTextField();

    }

    @FXML
    void btnEditUserOnAction() throws SQLException, IOException {

        if (checkText)
            return;

        updateUserInfo();
        //openStage("user-settings-view");


    }

    private void updateUserInfo() throws SQLException {

        UserSettingModel userSettingModel = new UserSettingModel();
        int userId = Integer.parseInt(textFieldUserId.getText().trim());
        String firstName = textFieldFirstName.getText().trim() ,
        lastName = textFieldLastName.getText().trim() ,
        phone = textFieldPhone.getText().trim() ,
        address = textFieldAddress.getText().trim() ,
        permission = (String) comboBoxPermission.getSelectionModel().getSelectedItem();

        double salary = Double.parseDouble(textFieldSalary.getText().trim());

        userSettingModel.edit(userId , firstName , lastName ,
                phone , address , permission , salary);



        updateTableView();
        EditUserDialogController.editUserStage.close();


    }

    private void updateTableView() throws SQLException {

        UserSettingController userSettingController = new UserSettingController();
        //userSettingController.tableViewUser.getItems().clear();
        userSettingController.setAllCellValueFactory();
        userSettingController.fillUserTable();

    }

    private void fillDataTextField(){

        ObservableList<User> listUser = EditUserDialogController.listUser;
        String userId = String.valueOf(listUser.get(0).getId()) ,
                userFirstName = listUser.get(0).getFirst(),
                userLastName = listUser.get(0).getLast() ,
                userPhone = listUser.get(0).getPhone() ,
                userSalary = String.valueOf(listUser.get(0).getSalary()) ,
                userPermission = listUser.get(0).getPermission();



        textFieldUserId.setText(userId);
        textFieldFirstName.setText(userFirstName);
        textFieldLastName.setText(userLastName);
        textFieldPhone.setText(userPhone);
        textFieldSalary.setText(userSalary);
        comboBoxPermission.setValue((String) userPermission);


    }

    private void prepareComboBox(){

        ObservableList<String> listComboBox = FXCollections.observableArrayList();
        listComboBox.add("Account");
        listComboBox.add("Chive Account");
        comboBoxPermission.setItems(listComboBox);

    }
    private void checkTextEmpty(){

        if (textFieldUserId.getText().trim().equalsIgnoreCase("")){
            checkText = true ;
        }
        else if(textFieldUserId.getText().trim().equalsIgnoreCase("")){
            checkText = true ;
        }
        else if(textFieldFirstName.getText().trim().equalsIgnoreCase("")){
            checkText = true ;
        }
        else if (textFieldLastName.getText().trim().equalsIgnoreCase("")){
            checkText = true ;
        }
        else if (textFieldPhone.getText().trim().equalsIgnoreCase("")){
            checkText = true ;
        }
        else if (textFieldSalary.getText().trim().equalsIgnoreCase("")){
            checkText = true ;
        }
        else
            checkText = false ;


    }

    public void openStage(String fxmlFileName) throws IOException {


        Parent root = FXMLLoader.load(this.getClass().getResource("/com/example/view/" + fxmlFileName +".fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Account system");
        stage.setScene(scene);
        stage.show();

    }


}
