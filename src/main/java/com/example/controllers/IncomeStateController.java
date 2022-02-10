package com.example.controllers;

import com.example.controllers.TableViewClass.IncomeStateTableView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.AccountModel;
import model.CurrencyModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import sql.DataBaseConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class IncomeStateController implements Initializable {

    @FXML
    private Text textFieldTotalRevenue;

    @FXML
    private TableView<IncomeStateTableView> tableView;

    @FXML
    private TableColumn<IncomeStateTableView, String> accountCell;

    @FXML
    private TableColumn<IncomeStateTableView, String> balanceCell;

    @FXML
    private Text textFieldTotalBalance;

    @FXML
    private Text textFieldOperatingIncome;

    private ObservableList<IncomeStateTableView> list ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setAllCellValueFactory();
            fillTableView();
            AccountModel accountModel = new AccountModel();
            double value = accountModel.fun1();
            double value2 = accountModel.fun2();
            textFieldTotalBalance.setText("Total Balance = " + value);
            textFieldTotalRevenue.setText("Revinue Balance = " + value2);
            textFieldOperatingIncome.setText("Operating Income = " + (value2 - value));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private void setAllCellValueFactory(){

        accountCell.setCellValueFactory(new  PropertyValueFactory<>("name"));
        balanceCell.setCellValueFactory(new PropertyValueFactory<>("value"));


    }

    private void fillTableView()throws SQLException {

        AccountModel accountModel = new AccountModel();
        list = accountModel.fun();
        tableView.setItems(list);

    }

    @FXML
    void btnShowReportOnAction() {

        try {

            CurrencyModel c = new CurrencyModel();
            c.calc();

            DataBaseConnection db = new DataBaseConnection();
            Connection conn = db.getConn();

            String path = "income_state.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,conn);
            JasperViewer.viewReport(jasperPrint , false);
            conn.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
