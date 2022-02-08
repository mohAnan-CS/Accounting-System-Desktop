package com.example.controllers;

import com.example.controllers.TableViewClass.TrialBalanceTableView;
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
import model.GeneralLedgerModel;
import model.TrialBalanceModel;
import model.User;
import model.UserSettingModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private TableColumn<User, String> firstName;

    @FXML
    private TableColumn<User, String> lastName;

    @FXML
    private TableColumn<User, String> permission;



    private ObservableList<User> userList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        setAllCellValueFactory();
        try {
            fillLedgerList();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private void setAllCellValueFactory(){

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("first"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("last"));
        permission.setCellValueFactory(new PropertyValueFactory<>("permission"));

    }

    private void fillLedgerList() throws SQLException {

        UserSettingModel userSettingModel = new UserSettingModel();
        //userSettingModel
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
