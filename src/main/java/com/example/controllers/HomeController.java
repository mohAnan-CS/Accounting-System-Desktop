package com.example.controllers;

import javafx.application.Platform;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @FXML
    private Text textTime;

    private volatile boolean stop ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setTimeNow();
        setTextUserName();

    }

    private void setTextUserName(){

        String userFirstName = LoginModel.FName ;
        String userLastName = LoginModel.LName ;
        String userPermission = LoginModel.permission ;

        if (userPermission.equalsIgnoreCase("manager")){
            textUserName.setText(userFirstName + " " + userLastName + " ( Manager )");
            btnTransaction.setDisable(true);
        }
        else if (userPermission.equalsIgnoreCase("chiveaccount")){
            textUserName.setText(userFirstName + " " + userLastName + " ( Chive Account )");
            btnUserSetting.setDisable(true);
        }
        else if (userPermission.equalsIgnoreCase("account")){
            textUserName.setText(userFirstName + " " + userLastName + " ( Account )");
            btnUserSetting.setDisable(true);
        }

    }

    private void setTimeNow(){

        Thread thread = new Thread(() ->{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
            while (!stop){
                try {

                    Thread.sleep(1000);

                }catch (Exception e){
                    System.out.println(e);
                }
                final String timeNow = simpleDateFormat.format(new Date());
                Platform.runLater(() ->{
                    textTime.setText(timeNow);
                });
            }
        });
        thread.start();

    }


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