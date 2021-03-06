package main.java.ua.ukr.net.dao;

import main.java.ua.ukr.net.model.Department;

import java.util.List;

public interface DepartmentDao {
    void create(Department department);

    void update(Department department);

    void remove(Long id);

    List<Department> findAll();

    Department findByName(String NameDepartment);
}
