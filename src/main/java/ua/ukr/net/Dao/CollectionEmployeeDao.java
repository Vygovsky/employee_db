package ua.ukr.net.Dao;

import ua.ukr.net.model.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Roman_v on 06.12.2017.
 */
public class CollectionEmployeeDao implements EmployeeDao {

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

    public boolean add(Employee employee) {
        if (null==employee){
            throw new NullPointerException();
        }
        return Db.getEmployees().add(employee);
    }

    public boolean update(Employee employee) {
        for (Employee e : Db.getEmployees()) {
            if (employee.getId() == e.getId()) {
                e.setName(employee.getName());
                e.setEmail(employee.getEmail());
                e.setBirthday(employee.getBirthday());
                return true;
            }
        }
        return false;
    }


    public Employee remove(Long id) {
        List<Employee> employees = Db.getEmployees();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            if (next.getId() == id) {
                iterator.remove();
                return next;
            }
        }
        return null;
    }
}
