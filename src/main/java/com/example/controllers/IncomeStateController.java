package com.example.controllers;

import com.example.controllers.TableViewClass.IncomeStateTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.CurrencyModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sql.DataBaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class IncomeStateController implements Initializable {

    @FXML
    private Text textFieldTotalRevenue;

    @FXML
    private TableView<IncomeStateTableView> tableViewTotalRevenue;

    @FXML
    private TableColumn<IncomeStateTableView, String> expensesCell;

    @FXML
    private TableColumn<IncomeStateTableView, String> balanceCell;

    @FXML
    private Text textFieldTotalBalance;

    @FXML
    private Text textFieldOperatingIncome;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAllCellValueFactory();
    }

    private void setAllCellValueFactory(){

        this.expensesCell.setCellValueFactory(new PropertyValueFactory<>("expense"));
        this.balanceCell.setCellValueFactory(new PropertyValueFactory<>("balance"));

    }

    private void fillTableView(){



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
