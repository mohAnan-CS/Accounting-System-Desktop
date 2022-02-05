package model;

import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class GeneralJournal {

    String AccountName,date,name,type;
    double value;
    int id,relation;

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "GeneralJournal{" +
                "AccountName='" + AccountName + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", id=" + id +
                ", relation=" + relation +
                '}';
    }

    public GeneralJournal(String AccountName, String date, String name, String type, double value, int id,int relation) {

        this.AccountName = AccountName;
        this.date = date;
        this.name = name;
        this.type = type;
        this.value = value;
        this.id = id;
        this.relation = relation;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountType) {
        AccountName = accountType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
