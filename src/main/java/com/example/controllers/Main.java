package com.example.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;


import java.sql.SQLException;


public class Main extends Application {

    public static Stage STAGE ;

    @Override
    public void start(Stage stage) throws IOException, SQLException {

        STAGE = stage ;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/view/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Account Program");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();

    }

    public static void main(String[] args) throws SQLException, IOException {

        CurrencyModel c = new CurrencyModel();
        c.getCurrency();
        c.addCurrency("ILS");
       // launch();
//        Currency c = new Currency();
//        System.out.println(c.readFromWeb("https://currencies.apps.grandtrunk.net/getlatest/USD/KRW"));
//        System.out.println( c.addCurrency("KRW") );

    }

    
}