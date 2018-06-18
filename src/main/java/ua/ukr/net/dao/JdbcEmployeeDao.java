package ua.ukr.net.dao;

import ua.ukr.net.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao extends AbstractJdbcDao implements EmployeeDao {
    private final String FIND_ALL_EMPL = "SELECT* FROM EMPLOYEE";

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
        List<Employee> listEmployee = new ArrayList<>();
        try {
            Statement statement = createConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_EMPL);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("ID"));
                employee.setName(resultSet.getString("FIRST_NAME"));
                employee.setEmail(resultSet.getString("EMAIL"));
                employee.setBirthday(resultSet.getDate("BIRTHDAY"));
                listEmployee.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployee;
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

