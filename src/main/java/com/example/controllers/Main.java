package com.example.controllers;

import com.example.controllers.TableViewClass.IncomeStateTableView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

        AccountModel a = new AccountModel();
       // a.addAccount("ss","sss",1223);


        AccountModel accountModel = new AccountModel();
        ObservableList<IncomeStateTableView> list = accountModel.fun();

        for(int  i = 0  ; i < list.size() ; i++ ){

            System.out.println(list.get(i).toString());

        }

        launch();
    }



    
}