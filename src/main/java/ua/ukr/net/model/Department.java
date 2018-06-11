package ua.ukr.net.model;

import java.util.List;

public class Department {
    private String name;
    List<Employee> employeeDepartment;

    public Department(String name, List<Employee> employeeDepartment) {
        this.name = name;
        this.employeeDepartment = employeeDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(List<Employee> employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return employeeDepartment != null ? employeeDepartment.equals(that.employeeDepartment) : that.employeeDepartment == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (employeeDepartment != null ? employeeDepartment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employeeDepartment=" + employeeDepartment +
                '}';
    }
}
