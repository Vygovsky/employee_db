package main.java.ua.ukr.net.dao;

import main.java.ua.ukr.net.model.Employee;

import java.util.Iterator;
import java.util.List;

public class JdbcEmployeeDao extends AbstractJdbcDao implements EmployeeDao {
    public List<Employee> findAll() {
        return null;
    }

    public Employee findById(Long id) {
        return null;
    }


    @Override
    public void create(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }


    public void remove(Long id) {
        
    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }
}

