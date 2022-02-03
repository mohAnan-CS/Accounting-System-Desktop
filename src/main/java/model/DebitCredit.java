package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DebitCredit {

    public ArrayList<DebitCreditInfo> arrayListDebitCredit = new ArrayList<>();

    public void storeDebitCredit(DebitCreditInfo debitCreditInfo){

        arrayListDebitCredit.add(debitCreditInfo);

    }

    public ArrayList getArrayListDebitCredit(){

        return arrayListDebitCredit ;

    }
}
