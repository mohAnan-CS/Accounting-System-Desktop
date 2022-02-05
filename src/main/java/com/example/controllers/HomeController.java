package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.LoginModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button btnTransaction;

    @FXML
    private Button btnUserSetting;

    @FXML
    private StackPane stackPane;

    @FXML
    private Text textUserName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    private static void setTextUserName(){

        LoginModel loginModel = new LoginModel();
        String userFirstName = loginModel.FName ;
        String userLastName = loginModel.LName ;
        String userPermission = loginModel.permission ;

    }

    private void che

    @FXML
    void btnFinancialOnAction(ActionEvent event) throws IOException{

        switchPane("financial-statements-view");

    }

    @FXML
    void btnGeneralJournalOnAction(ActionEvent event) throws IOException{

        switchPane("general-journal-view");

    }

    @FXML
    void btnGeneralLedgerOnAction(ActionEvent event) throws IOException{

        switchPane("general-ledger-view");

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {

        switchStage("login-view");

    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) throws IOException{

        switchPane("settings-view");

    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) throws IOException{

        switchPane("transaction-view");

    }

    @FXML
    void btnTrialBalanceOnAction(ActionEvent event) throws IOException{

        switchPane("trial-balance-view");

    }

    @FXML
    void btnUserSettingsOnAction(ActionEvent event) throws IOException{

        switchPane("user-setting-view");

    }


    private void switchStage(String xmlFileName) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/view/"+xmlFileName.concat(".fxml")));
        Main.STAGE.setScene(new Scene(root));
        Main.STAGE.centerOnScreen();
        Main.STAGE.show();

    }

    private void switchPane(String xmlFileName) throws IOException{

        stackPane.getChildren().removeAll();
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/example/view/"+xmlFileName.concat(".fxml")));
        if (stackPane.getChildren().size() != 0 ) {
            stackPane.getChildren().removeAll(stackPane.getChildren().get(0));
        }
        stackPane.getChildren().addAll(fxml);

    }



}