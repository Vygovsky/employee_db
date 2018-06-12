package ua.ukr.net.Dao;

import ua.ukr.net.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee create(Employee employee);

    Employee update(Employee employee);

    Employee remove(Long id);

    List<Employee> findAll();

    Employee findById(Long id);


    Employee findByEmail(String email);

}
