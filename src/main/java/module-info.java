module AccountingProgram {

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;

    opens sql;
    opens com.example.controllers ;
    opens model;
    opens com.example.controllers.TableViewClass;


}