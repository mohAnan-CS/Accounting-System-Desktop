package model;

public class LoginTable {


    String UserName ;
    int id ;
    String perm ;
    String salary ;
    String add;
    String phone;
    String state ;

    @Override
    public String toString() {
        return "LoginTable{" +
                "UserName='" + UserName + '\'' +
                ", id=" + id +
                ", perm='" + perm + '\'' +
                ", salary='" + salary + '\'' +
                ", add='" + add + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public LoginTable(String userName, int id, String perm, String salary, String add, String phone, String state) {
        UserName = userName;
        this.id = id;
        this.perm = perm;
        this.salary = salary;
        this.add = add;
        this.phone = phone;
        this.state = state;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
