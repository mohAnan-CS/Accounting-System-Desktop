package com.example.controllers;

import com.example.controllers.TableViewClass.GeneralLedgerTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.GeneralLedger;
import model.GeneralLedgerModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GeneralLedgerController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private ScrollPane scrollPaneButton;

    @FXML
    private AnchorPane anchorPaneButton;

    @FXML
    private VBox vboxButton;

    @FXML
    private Text textTypeAccount;

    @FXML
    private TableView<GeneralLedgerTableView> tableView;

    @FXML
    private TableColumn<GeneralLedgerTableView, String> dateCell;

    @FXML
    private TableColumn<GeneralLedgerTableView, String> exCell;

    @FXML
    private TableColumn<GeneralLedgerTableView, String> useridCell;

    @FXML
    private TableColumn<GeneralLedgerTableView, String> userNameCell;

    @FXML
    private TableColumn<GeneralLedgerTableView, String> debitCell;

    @FXML
    private TableColumn<GeneralLedgerTableView, String> creditCell;

    @FXML
    private TableColumn<GeneralLedgerTableView, String> balanceCell;

    ObservableList<GeneralLedgerTableView> listLedgerTableView = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setAllCellValueFactory();
            createButtonsAccountType();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void setAllCellValueFactory(){

        this.dateCell.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.exCell.setCellValueFactory(new PropertyValueFactory<>("ex"));
        this.useridCell.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.userNameCell.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.debitCell.setCellValueFactory(new PropertyValueFactory<>("debit"));
        this.creditCell.setCellValueFactory(new PropertyValueFactory<>("credit"));
        this.balanceCell.setCellValueFactory(new PropertyValueFactory<>("balance"));

    }

    private void fillLedgerList(String accountName) throws SQLException {

        GeneralLedgerModel generalLedgerModel = new GeneralLedgerModel();
        ObservableList<GeneralLedger> lisLedger= generalLedgerModel.Search(accountName);


        for (int i = 0 ; i < lisLedger.size() ; i++){

            if (lisLedger.get(i).getTyp().equalsIgnoreCase("debit")) {
                GeneralLedgerTableView generalLedgerTableView =
                        new GeneralLedgerTableView(lisLedger.get(i).getDate(),
                                lisLedger.get(i).getExplanation(),
                                String.valueOf(lisLedger.get(i).getUserId()),
                                lisLedger.get(i).getUserName(),
                                lisLedger.get(i).getTyp(),""
                                , String.valueOf(lisLedger.get(i).getBalance()));
                listLedgerTableView.add(generalLedgerTableView);

            }else {

                GeneralLedgerTableView generalLedgerTableView =
                        new GeneralLedgerTableView(lisLedger.get(i).getDate(),
                                lisLedger.get(i).getExplanation(),
                                String.valueOf(lisLedger.get(i).getUserId()),
                                lisLedger.get(i).getUserName(),
                                "",lisLedger.get(i).getTyp()
                                , String.valueOf(lisLedger.get(i).getBalance()));

                listLedgerTableView.add(generalLedgerTableView);

            }

            tableView.setItems(listLedgerTableView);

        }

    }

    private void createButtonsAccountType()throws SQLException {

        GeneralLedgerModel generalLedgerModel = new GeneralLedgerModel();
        ObservableList listAccountName = generalLedgerModel.Accounts();

        for (int i = 0  ; i < listAccountName.size() ; i++){

            Button button = new Button();
            button.setText(listAccountName.get(i).toString());
            button.setPadding(new Insets(12));
            button.setOnAction(actionEvent -> {
                tableView.getItems().clear();
                textTypeAccount.setText(button.getText());
                try {
                    fillLedgerList(button.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            });
            vboxButton.getChildren().add(button);
        }

    }
}
