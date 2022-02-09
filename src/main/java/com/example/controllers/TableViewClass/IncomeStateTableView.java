package com.example.controllers.TableViewClass;

public class IncomeStateTableView {

    private String expense , balance ;

    public IncomeStateTableView(String expenseAccount, String balance) {
        this.expense = expenseAccount;
        this.balance = balance;
    }

    public String getExpenseAccount() {
        return expense;
    }

    public void setExpenseAccount(String expenseAccount) {
        this.expense = expenseAccount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
