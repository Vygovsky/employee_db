package ua.ukr.net.dao;

import ua.ukr.net.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao extends AbstractJdbcDao implements EmployeeDao {
    private final String FIND_ALL_EMPL = "SELECT* FROM employee";
    private final String FIND_BY_ID_EMPL = "SELECT * FROM employee WHERE id=?";
    private final String FIND_BY_EMAIL_EMPL = "SELECT * FROM employee WHERE email=?";

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
        Employee employee = new Employee();

        try {
            PreparedStatement preparedStatement = createConnection().prepareStatement(FIND_BY_ID_EMPL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            employee.setId(resultSet.getLong("ID"));
            employee.setName(resultSet.getString("FIRST_NAME"));
            employee.setEmail(resultSet.getString("EMAIL"));
            employee.setBirthday(resultSet.getDate("BIRTHDAY"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee findByEmail(String email) {
        Employee employeeMail = new Employee();
        try {
            PreparedStatement preparedStatement = createConnection().prepareStatement(FIND_BY_EMAIL_EMPL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            employeeMail.setId(resultSet.getLong("ID"));
            employeeMail.setName(resultSet.getString("FIRST_NAME"));
            employeeMail.setEmail(resultSet.getString("EMAIL"));
            employeeMail.setBirthday(resultSet.getDate("BIRTHDAY"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeMail;
    }
}

