package ua.ukr.net.dao;

import ua.ukr.net.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Db {
    private static List<Employee> employees = new ArrayList<Employee>();

    public static List<Employee> getEmployees() {
        return employees;
    }
}
