package com.example.controllers.TableViewClass;

public class GeneralJournalTableView {

    private String date , type , name , debit , credit  , id;
    //private int id ;
//    private double debit  , credit;

    public GeneralJournalTableView(String date, String type, String name, String id, String debit, String credit) {
        this.date = date;
        this.type = type;
        this.name = name;
        this.id = id;
        this.debit = debit;
        this.credit = credit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
