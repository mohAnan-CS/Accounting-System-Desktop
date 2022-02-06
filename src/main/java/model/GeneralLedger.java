package model;

public class GeneralLedger {

    int UserId,relation;
    String UserName;
    String Date;
    String accountName;
    double amount;
    String typ;
    double balance;
    String explanation;

    public GeneralLedger(int userId, int relation, String userName, String date, String accountName, double amount, String typ,double balance,String explanation) {
        UserId = userId;
        this.relation = relation;
        UserName = userName;
        Date = date;
        this.accountName = accountName;
        this.amount = amount;
        this.typ = typ;
        this.balance = balance;
        this.explanation =explanation;
    }

    @Override
    public String toString() {
        return "GeneralLedger{" +
                "UserId=" + UserId +
                ", relation=" + relation +
                ", UserName='" + UserName + '\'' +
                ", Date='" + Date + '\'' +
                ", accountName='" + accountName + '\'' +
                ", amount=" + amount +
                ", typ='" + typ + '\'' +
                ", balance=" + balance +
                ", explanation=" + explanation +
                '}';
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
