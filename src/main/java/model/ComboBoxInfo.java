package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ComboBoxInfo {

    public void fillComboBox(ComboBox comboBox){

        ObservableList<String> list = FXCollections.observableArrayList("cash" , "equipment" , "Rent Expense");
        comboBox.setItems(list);

    }

}
