package ua.ukr.net.model;

import java.util.Date;

public class Employee {
    private long id;
    private String name;
    private String email;
    private Date birthday;
    private long serialNumber;

    public Employee() {
    }

    public Employee(long id, String name, String email, Date birthday, long serialNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.serialNumber = serialNumber;
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

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (serialNumber != employee.serialNumber) return false;
        if (!name.equals(employee.name)) return false;
        if (!email.equals(employee.email)) return false;
        return birthday.equals(employee.birthday);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + (int) (serialNumber ^ (serialNumber >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
