package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneralLedgerController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private ScrollPane scrollPaneButton;

    @FXML
    private AnchorPane anchorPaneButton;

    @FXML
    private VBox vboxButton;

    @FXML
    private Text textTypeAccount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        createButtonsAccountType();


        //pane.getChildren().add(scrollPane);
        //scrollPaneButton.setContent(anchorPaneButton);
        //anchorPaneButton.getChildren().add(vboxButton);

        //vboxButton.setSpacing(30);


    }

    private void createButtonsAccountType(){

        String[] strings = new String[]{"Cash" , "Money" , "Owner" , "Supplies"};

        for (int i = 0  ; i < strings.length ; i++){

            Button button = new Button();
            button.setText(strings[i]);
            button.setPadding(new Insets(12));
            button.setOnAction(actionEvent -> {

                textTypeAccount.setText(button.getText());

            });
            vboxButton.getChildren().add(button);
        }

    }
}
