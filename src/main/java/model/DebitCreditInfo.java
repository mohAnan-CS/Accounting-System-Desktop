package model;

public class DebitCreditInfo {

    private String userAccount ;
    private String dateNow ;
    private double debitValue ;
    private double creditValue ;
    private String debitAccountType ;
    private String creditAccountType ;

    public DebitCreditInfo(String userAccount, String dateNow, double debitValue, double creditValue, String debitAccountType,
                           String creditAccountType) {
        this.userAccount = userAccount;
        this.dateNow = dateNow;
        this.debitValue = debitValue;
        this.creditValue = creditValue;
        this.debitAccountType = debitAccountType;
        this.creditAccountType = creditAccountType;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getDateNow() {
        return dateNow;
    }

    public void setDateNow(String dateNow) {
        this.dateNow = dateNow;
    }

    public double getDebitValue() {
        return debitValue;
    }

    public void setDebitValue(double debitValue) {
        this.debitValue = debitValue;
    }

    public double getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(double creditValue) {
        this.creditValue = creditValue;
    }

    public String getDebitAccountType() {
        return debitAccountType;
    }

    public void setDebitAccountType(String debitAccountType) {
        this.debitAccountType = debitAccountType;
    }

    public String getCreditAccountType() {
        return creditAccountType;
    }

    public void setCreditAccountType(String creditAccountType) {
        this.creditAccountType = creditAccountType;
    }

    @Override
    public String toString() {
        return "DebitCreditInfo{" +
                "userAccount='" + userAccount + '\'' +
                ", dateNow='" + dateNow + '\'' +
                ", debitValue=" + debitValue +
                ", creditValue=" + creditValue +
                ", debitAccountType='" + debitAccountType + '\'' +
                ", creditAccountType='" + creditAccountType + '\'' +
                '}';
    }
}
