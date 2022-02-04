package com.example.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GeneralJournalModel;
import model.TransactionModel;
import model.UserSettingModel;

import java.io.IOException;


import java.sql.SQLException;


public class Main extends Application {

    //Hello

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

    public static void main(String[] args) throws SQLException {



        //launch();
//        UserSettingModel s = new UserSettingModel();
//        s.AddUser(134432,"Obada","Jaras","123","05980284","birzeit","CUST",12422);

//      TransactionModel t =  new TransactionModel();
//       t.GetDebittAndCredit2(100,100,100,100,"Cash","Cash","Cash","Cash");


        launch();



        launch();





    }

    
}