package com.example.controllers;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import model.UserSettingModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditUserDialogController implements Initializable {

    @FXML
    public static DialogPane dialogPaneEditUser;

    @FXML
    private TextField textFieldUserId;

    public static ObservableList<User> listUser ;
    public static Stage editUserStage = new Stage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnNextOnAction() throws SQLException, IOException {


        int userId = Integer.parseInt(textFieldUserId.getText().trim());
        UserSettingModel userSettingModel = new UserSettingModel();
        listUser = userSettingModel.searchUser(userId);

        UserSettingController.editUserConfirmStage.close();
        openNewStage("edit-user-view");



    }

    public void openNewStage(String fxmlFileName) throws IOException {

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/com/example/view/" + fxmlFileName +".fxml"));
        Scene scene = new Scene(myLoader.load());
        editUserStage.setTitle("Add new user");
        editUserStage.setScene(scene);
        editUserStage.show();

    }



}
