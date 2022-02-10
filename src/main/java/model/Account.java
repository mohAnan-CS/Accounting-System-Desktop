package model;

public class Account {
    int ref;
    String name;
    String type;

    public Account(int ref, String name, String type) {
        this.ref = ref;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ref=" + ref +
                ", accountName='" + name + '\'' +
                ", accountType='" + type + '\'' +
                '}';
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
