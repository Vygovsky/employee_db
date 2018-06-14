package ua.ukr.net.dao;

import ua.ukr.net.model.Employee;

import java.util.List;

public class JdbcEmployeeDao extends AbstractJdbcDao implements EmployeeDao {

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }
}

