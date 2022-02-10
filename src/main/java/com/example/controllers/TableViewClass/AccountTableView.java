package com.example.controllers.TableViewClass;

public class AccountTableView {

    private String ref , type , name ;

    public AccountTableView(String ref, String type, String name) {
        this.ref = ref;
        this.type = type;
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountTableView{" +
                "ref='" + ref + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
