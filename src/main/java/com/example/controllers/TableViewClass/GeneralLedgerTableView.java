package com.example.controllers.TableViewClass;

public class GeneralLedgerTableView {

    String date,ex,id,name,debit,credit,balance;


    public GeneralLedgerTableView(String date, String ex, String id, String name, String debit, String credit, String balance) {
        this.date = date;
        this.ex = ex;
        this.id = id;
        this.name = name;
        this.debit = debit;
        this.credit = credit;
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
