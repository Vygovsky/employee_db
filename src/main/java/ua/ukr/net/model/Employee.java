package ua.ukr.net.model;

import com.google.gson.Gson;

import java.util.Date;

public class Employee {
    private long id;
    private String name;
    private String email;
    private Date birthday;


    public Employee() {
    }

    public Employee(long id, String name, String email, Date birthday, long serialNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        return birthday != null ? birthday.equals(employee.birthday) : employee.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
