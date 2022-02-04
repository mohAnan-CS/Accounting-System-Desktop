package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSettingController implements Initializable {

    @FXML
    private TextField textFieldSearch;

    @FXML
    private TableView<User> tableViewUser;

    @FXML
    private TableColumn<User, Integer> id;

    @FXML
    private TableColumn<User, String> name;

    @FXML
    private TableColumn<User, String> phone;

    @FXML
    private TableColumn<User, String> address;

    @FXML
    private TableColumn<User, String> salary;

    @FXML
    private TableColumn<User, String> email;

    @FXML
    private TableColumn<User, String> permission;



    private ObservableList<User> userList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        permission.setCellValueFactory(new PropertyValueFactory<>("permission"));


        User user = new User(1, "Mohammad Anan" , "059324345" , "Tulkarm" , "1400$" ,
                "mohammad@hotmail.com" , "maneger");


        userList.add(user);

        tableViewUser.setItems(userList);

    }

    @FXML
    void btnAddNewUserOnAction(ActionEvent event) throws IOException {

        openNewStage("new-user-view");

    }

    @FXML
    void btnDeleteUserOnAction(ActionEvent event) throws IOException{

        openNewStage("delete-user-view");

    }

    @FXML
    void btnEditUserOnAction(ActionEvent event) throws IOException{

        openNewStage("edit-user-view");

    }

    public void openNewStage(String fxmlFileName) throws IOException {

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/com/example/view/" + fxmlFileName +".fxml"));
        Scene scene = new Scene(myLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Add new user");
        stage.setScene(scene);
        stage.show();

    }
}
