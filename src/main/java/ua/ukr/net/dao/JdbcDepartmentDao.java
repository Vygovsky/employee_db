package ua.ukr.net.dao;

import ua.ukr.net.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDepartmentDao extends AbstractJdbcDao implements DepartmentDao {
    private final static String BD_FIND_ALL_DEPART = "SELECT*FROM department";
    private final String FIND_BY_NAME_DEPART = "SELECT * FROM department WHERE name=?";
    private final String UPDATE_DEPART = "UPDATE department SET name=? WHERE id=?";
    private final String DELETE_DEPART = "DELETE FROM department WHERE id=?";
    private final String INSERT_DEPART = "INSERT INTO department (id, name) VALUES(?,?)";

    @Override
    public void create(Department department) {
        try {
            PreparedStatement preparedStatement = createConnection().prepareStatement(INSERT_DEPART);
            preparedStatement.setLong(1, department.getId());
            preparedStatement.setString(2, department.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department department) {
        try {
            PreparedStatement preparedStatement = createConnection().prepareStatement(UPDATE_DEPART);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setLong(2, department.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = createConnection().prepareStatement(DELETE_DEPART);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        try {
            Statement statement = createConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(BD_FIND_ALL_DEPART);
            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        null);
                //old code
                /*department.setId(resultSet.getLong("ID"));
                department.setName(resultSet.getString("NAME"));*/
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Department findByName(String nameDepartment) {
        Department department = new Department(0, null, null);

        try {
            PreparedStatement preparedStatement = createConnection().prepareStatement(FIND_BY_NAME_DEPART);
            preparedStatement.setString(1, nameDepartment);
            ResultSet resultSet = preparedStatement.executeQuery();
            department.setId(resultSet.getLong("ID"));
            department.setName(resultSet.getString("NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
}


