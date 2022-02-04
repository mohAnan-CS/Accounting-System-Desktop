package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //pane.getChildren().add(scrollPane);
        //scrollPaneButton.setContent(anchorPaneButton);
        //anchorPaneButton.getChildren().add(vboxButton);

        vboxButton.setSpacing(30);
        for (int i = 0  ; i < 12 ; i++){
            Button button = new Button();
            button.setText(String.valueOf(i));
            button.setPadding(new Insets(12));
            button.setOnAction(actionEvent -> {

                System.out.println(button.getText().toString());

            });
            vboxButton.getChildren().add(button);
        }

    }
}
