package com.example.controllers;

import com.example.controllers.TableViewClass.GeneralJournalTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.GeneralJournal;
import model.GeneralJournalModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GeneralJournalController implements Initializable {

    @FXML
    private TableView<GeneralJournalTableView> tableViewJournalLedger;

    @FXML
    private TableColumn<GeneralJournalTableView, String> dateCell;

    @FXML
    private TableColumn<GeneralJournalTableView, String> accountTypeCell;

    @FXML
    private TableColumn<GeneralJournalTableView, String> userIdCell;

    @FXML
    private TableColumn<GeneralJournalTableView, String> userNameCell;

    @FXML
    private TableColumn<GeneralJournalTableView, String> debitCell;

    @FXML
    private TableColumn<GeneralJournalTableView, String> creditCell;

    @FXML
    private TableColumn<GeneralJournalTableView, String> descriptionCell;

    ObservableList<GeneralJournal> lisGeneralJournal = FXCollections.observableArrayList();
    ObservableList<GeneralJournalTableView> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setAllCellValueFactory();
            fillJournalList();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void setAllCellValueFactory(){



        this.dateCell.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.accountTypeCell.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.userIdCell.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.debitCell.setCellValueFactory(new PropertyValueFactory<>("debit"));
        this.creditCell.setCellValueFactory(new PropertyValueFactory<>("credit"));
        this.userNameCell.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.descriptionCell.setCellValueFactory(new PropertyValueFactory<>("description"));


    }

    private void fillJournalList()throws SQLException {

        GeneralJournalModel generalJournalModel = new GeneralJournalModel();
        lisGeneralJournal = generalJournalModel.getGeneralJournalInformation();

        System.out.println();
        System.out.println("-------------------");
        System.out.println();

        //ObservableList<GeneralJournalTableView> list = FXCollections.observableArrayList();
        int relation = 1 ;
        for (int i = 0  ; i < lisGeneralJournal.size() ; i++){


            if (lisGeneralJournal.get(i).getRelation() != relation){

                GeneralJournalTableView generalJournalTableView =
                        new GeneralJournalTableView("" ,"" , "" , "" , "" , "" , "");
                list.add(generalJournalTableView);
                relation = relation + 1 ;
                System.out.println("-------------------------");

            }

            //System.out.println(lisGeneralJournal.get(i).toString());
            if (lisGeneralJournal.get(i).getType().equalsIgnoreCase("debit")){
                System.out.println("date = "+lisGeneralJournal.get(i).getDate());
                System.out.println("account type " + lisGeneralJournal.get(i).getAccountName());
                System.out.println("user id " + lisGeneralJournal.get(i).getId());
                System.out.println("user name " + lisGeneralJournal.get(i).getName());
                System.out.println("debit " + lisGeneralJournal.get(i).getValue());
                System.out.println("credit = null" );
                GeneralJournalTableView generalJournalTableView =
                        new GeneralJournalTableView(lisGeneralJournal.get(i).getDate() ,
                                lisGeneralJournal.get(i).getAccountName() ,
                                lisGeneralJournal.get(i).getName() ,
                                String.valueOf(lisGeneralJournal.get(i).getId()),
                                String.valueOf(lisGeneralJournal.get(i).getValue()) ,
                                "" ,
                                lisGeneralJournal.get(i).getExplanation());
                list.add(generalJournalTableView);


            }else{

                System.out.println("date = "+lisGeneralJournal.get(i).getDate());
                System.out.println("account type " + lisGeneralJournal.get(i).getAccountName());
                System.out.println("user id " + lisGeneralJournal.get(i).getId());
                System.out.println("user name " + lisGeneralJournal.get(i).getName());
                System.out.println("debit null");
                System.out.println("credit = " + lisGeneralJournal.get(i).getValue());
                GeneralJournalTableView generalJournalTableView =
                        new GeneralJournalTableView(lisGeneralJournal.get(i).getDate() ,
                                lisGeneralJournal.get(i).getAccountName() ,
                                lisGeneralJournal.get(i).getName() ,
                                String.valueOf(lisGeneralJournal.get(i).getId()),
                                "" ,
                                String.valueOf(lisGeneralJournal.get(i).getValue()) ,
                                lisGeneralJournal.get(i).getExplanation());

                list.add(generalJournalTableView);

            }

        }

        tableViewJournalLedger.setItems(list);

    }


}
