package ua.ukr.net.Dao;

import ua.ukr.net.model.Employee;

import java.util.List;

public interface EmployeeDao {


    List<Employee> findAll();

    Employee findById(Long id);

    boolean create(Employee employee);

    boolean update(Employee employee);

    Employee remove(Long id);

    Employee findByEmail(String email);

}
