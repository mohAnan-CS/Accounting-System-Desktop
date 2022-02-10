package com.example.controllers.TableViewClass;

public class IncomeStateTableView {

    private String name  , value ;

    public IncomeStateTableView(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IncomeStateTableView{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
