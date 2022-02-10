package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class SettingsController {

    @FXML
    private StackPane stackPaneSetting;

    @FXML
    void btnAccountOnAction() throws IOException {
        switchPane("account-view");
    }

    @FXML
    void btnCurrencyOnAction() throws IOException {
        switchPane("currency-view");
    }

    private void switchPane(String xmlFileName) throws IOException {

        stackPaneSetting.getChildren().removeAll();
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/example/view/"+xmlFileName.concat(".fxml")));
        if (stackPaneSetting.getChildren().size() != 0 ) {
            stackPaneSetting.getChildren().removeAll(stackPaneSetting.getChildren().get(0));
        }
        stackPaneSetting.getChildren().addAll(fxml);

    }

}
