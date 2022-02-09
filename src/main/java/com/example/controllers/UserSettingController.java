package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    public TableView<User> tableViewUser = new TableView<>();

    @FXML
    public TableColumn<User, Integer> id = new TableColumn<>();

    @FXML
    public TableColumn<User, String> phone  = new TableColumn<>();

    @FXML
    public TableColumn<User, String> address = new TableColumn<>();

    @FXML
    public TableColumn<User, String> salary = new TableColumn<>();

    @FXML
    public TableColumn<User, String> firstName = new TableColumn<>();

    @FXML
    public TableColumn<User, String> lastName = new TableColumn<>();

    @FXML
    public TableColumn<User, String> permission = new TableColumn<>();

    public static Stage editUserConfirmStage = new Stage() , newUserStage = new Stage();
    private ObservableList<User> userList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        setAllCellValueFactory();
        try {
            fillUserTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        searchTableViewLive();


    }

    private void searchTableViewLive(){

        FilteredList<User> filteredData = new FilteredList<>(userList, b -> true);

        textFieldSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getFirst().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (user.getLast().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (String.valueOf(user.getSalary()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else if (String.valueOf(user.getId()).indexOf(lowerCaseFilter)!= -1)
                    return true;
                else
                    return false;
            });
        });


        SortedList<User> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewUser.comparatorProperty());

        tableViewUser.setItems(sortedData);

    }


    public void setAllCellValueFactory(){

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("first"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("last"));
        permission.setCellValueFactory(new PropertyValueFactory<>("permission"));

    }

    public void fillUserTable() throws SQLException {

        System.out.println("fill user table");

        UserSettingModel userSettingModel = new UserSettingModel();
        userList = userSettingModel.getAllUser();
        tableViewUser.setItems(userList);

    }



    @FXML
    void btnAddNewUserOnAction(ActionEvent event) throws IOException {

        switchPaneNewUser("new-user-view");

    }

    @FXML
    void btnDeleteUserOnAction(ActionEvent event) throws IOException{

        //openNewStage("delete-user-view");

    }

    @FXML
    void btnEditUserOnAction() throws IOException{

        switchPaneEditUser("edit-user-dialog-view");

    }

    public void switchPaneEditUser(String fxmlFileName ) throws IOException {

        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/com/example/view/"+fxmlFileName.concat(".fxml")));
        editUserConfirmStage.setScene(new Scene(root));
        editUserConfirmStage.show();

    }

    public void switchPaneNewUser(String xmlFileName) throws IOException {

        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/com/example/view/"+xmlFileName.concat(".fxml")));
        newUserStage.setScene(new Scene(root));
        newUserStage.show();

    }
}
