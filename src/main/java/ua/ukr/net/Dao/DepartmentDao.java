package ua.ukr.net.Dao;

import ua.ukr.net.model.Department;

import java.util.List;

public interface DepartmentDao {
    create(Department department);

    update(Department department);

    remove(Department department);

    List<Department> findAll();

    Department findByName(String NameDepartment);
}
