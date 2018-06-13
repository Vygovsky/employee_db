package ua.ukr.net.dao;

import ua.ukr.net.model.Employee;

import java.util.Iterator;
import java.util.List;

public class JdbcEmployeeDao extends AbstractJdbcDao implements EmployeeDao {
    public List<Employee> findAll() {
        return Db.getEmployees();
    }

    public Employee findById(Long id) {
        for (Employee employee : Db.getEmployees()) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }


    @Override
    public void create(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }


    public void remove(Long id) {
        List<Employee> employees = Db.getEmployees();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            if (next.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public Employee findByEmail(String email) {
        for (Employee employee : Db.getEmployees()) {
            if (employee.getEmail().equals(email)) {
                return employee;
            }
        }
        return null;
    }
}

