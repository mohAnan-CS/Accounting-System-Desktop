module AccountingProgram {

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;

    opens com.example.controllers ;
    opens model;

}