package model;

public class Account {
    int ref;
    String accountName;
    String accountType;

    public Account(int ref, String accountName, String accountType) {
        this.ref = ref;
        this.accountName = accountName;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ref=" + ref +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
