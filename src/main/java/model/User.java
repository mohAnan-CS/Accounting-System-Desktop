package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", email='" + email + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    private int id ;
    private String first , last , phone , address , salary , email , permission ;

    public User(int id, String first, String last, String phone, String address, String salary, String email, String permission) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.email = email;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
