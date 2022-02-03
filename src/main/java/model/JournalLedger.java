package model;

public class JournalLedger {

    private String date ;
    private String accountType ;
    private String ref ;
    private String debit ;
    private String credit ;

    public JournalLedger(String date, String accountType, String ref, String debit, String credit) {
        this.date = date;
        this.accountType = accountType;
        this.ref = ref;
        this.debit = debit;
        this.credit = credit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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
