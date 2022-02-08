package com.example.controllers.TableViewClass;

public class TrialBalanceTableView {

    private String account , debit , credit ;

    public TrialBalanceTableView(String account, String debit, String credit) {
        this.account = account;
        this.debit = debit;
        this.credit = credit;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
