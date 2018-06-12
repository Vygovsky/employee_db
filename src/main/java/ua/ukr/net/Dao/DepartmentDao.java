package ua.ukr.net.Dao;

import ua.ukr.net.model.Department;

import java.util.List;

public interface DepartmentDao {
    Department create(Department department);

    Department update(Department department);

    Department remove(long id);

    List<Department> findAll();

    Department findByName(String NameDepartment);
}