package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinancialStatementsController implements Initializable {

    @FXML
    private Text text;

    @FXML
    private StackPane stackPaneFinancial;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    @FXML
    void btnBalanceSheetOnAction() throws IOException {
        switchPane("balance-sheet-view");
    }

    @FXML
    void btnIncomeStatementsOnAction( ) throws IOException{
        switchPane("income-state-view");
    }



    private void switchPane(String xmlFileName) throws IOException {

        stackPaneFinancial.getChildren().removeAll();
        Parent fxml = FXMLLoader.load(getClass().getResource("/com/example/view/"+xmlFileName.concat(".fxml")));
        if (stackPaneFinancial.getChildren().size() != 0 ) {
            stackPaneFinancial.getChildren().removeAll(stackPaneFinancial.getChildren().get(0));
        }
        stackPaneFinancial.getChildren().addAll(fxml);

    }2
