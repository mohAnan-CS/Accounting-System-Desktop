package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField textFieldUserName;

    @FXML
    private TextField textFieldUserPass;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException{

        switchStage("home-view");

    }

    private void switchStage(String xmlFileName) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/view/"+xmlFileName.concat(".fxml")));
        Main.STAGE.setScene(new Scene(root));
        Main.STAGE.centerOnScreen();
        Main.STAGE.setMaximized(true);
        Main.STAGE.show();

    }



}
