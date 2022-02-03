package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class TransactionController {

    @FXML
    private StackPane stackPaneTransaction;

    @FXML
    void btnAddingOneOnAction() throws IOException {

        switchPane("one-transaction-view");

    }

    @FXML
    void btnAddingTowOnAction() throws IOException{

        switchPane("two-transaction-view");

    }

    private void switchPane(String xmlFileName) throws IOException {

        stackPaneTransaction.getChildren().removeAll();
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/example/view/"+xmlFileName.concat(".fxml")));
        if (stackPaneTransaction.getChildren().size() != 0 ) {
            stackPaneTransaction.getChildren().removeAll(stackPaneTransaction.getChildren().get(0));
        }
        stackPaneTransaction.getChildren().addAll(fxml);

    }
}
