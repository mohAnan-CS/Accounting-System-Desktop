package model;

public class Reports {

    double amount;
    String name;

    public Reports(double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
