package com.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.LoginModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField textFieldUserId;

    @FXML
    private PasswordField textFieldUserPass;

    Boolean checkTextFieldEmpty = false ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void btnLoginOnAction() throws IOException{

        try {

            checkTextEmpty();
            if (!checkTextFieldEmpty)
                return;

            LoginModel loginModel = new LoginModel();
            int userId = Integer.parseInt(textFieldUserId.getText().trim());
            String userPass = textFieldUserPass.getText().trim();
            boolean checkLogIn = loginModel.checkLogin(userId,userPass);

            if (checkLogIn)
                switchStage();
            else
                throw new IllegalArgumentException("wrong info");


        }catch (SQLException | IOException e) {
            showAlert("Error", "ERROR", e.getMessage());
        } catch (IllegalArgumentException illegalArgumentException){
            showAlert("Warning" , "WARNING" , illegalArgumentException.getMessage());
        } catch (Exception exception){
            showAlert("Error", "ERROR", exception.getMessage());
        }

    }

    private void checkTextEmpty(){

        try {

            if (textFieldUserId.getText().trim().equalsIgnoreCase("") &&
                    textFieldUserPass.getText().trim().equalsIgnoreCase("")) {
                checkTextFieldEmpty=false;
                throw new IllegalArgumentException("text field user name and password is empty");
            }
            else if (textFieldUserId.getText().trim().equalsIgnoreCase("")) {
                checkTextFieldEmpty=false;
                throw new IllegalArgumentException("text filed user name is empty");
            }
            else if (textFieldUserPass.getText().trim().equalsIgnoreCase("")) {
                checkTextFieldEmpty=false;
                throw new IllegalArgumentException("text filed user password is empty");
            }else
                checkTextFieldEmpty=true;

        }catch (IllegalArgumentException illegalArgumentException){
            showAlert("Warning" , "WARNING" , illegalArgumentException.getMessage());
        }

    }

    public void showAlert(String titleAlert , String alertType , String contentText){

        if (alertType.equals("ERROR")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }else if (alertType.equals("WARNING")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(titleAlert);
            alert.setHeaderText(null);
            alert.setContentText(contentText);
            alert.showAndWait();
        }

    }

    private void switchStage() throws IOException{


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/view/home-view.fxml")));
        Main.STAGE.setScene(new Scene(root));
        Main.STAGE.centerOnScreen();
        Main.STAGE.setMaximized(true);
        Main.STAGE.show();

    }



}
