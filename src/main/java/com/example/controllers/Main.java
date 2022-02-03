package com.example.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage STAGE ;

    @Override
    public void start(Stage stage) throws IOException {
        STAGE = stage ;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/view/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Account Program");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}