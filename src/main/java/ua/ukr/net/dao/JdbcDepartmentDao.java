package ua.ukr.net.dao;

import ua.ukr.net.model.Department;

import java.util.List;

public class JdbcDepartmentDao extends AbstractJdbcDao implements DepartmentDao {

    @Override
    public void create(Department department) {
    }

    @Override
    public void update(Department department) {
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department findByName(String NameDepartment) {
        return null;
    }
}


