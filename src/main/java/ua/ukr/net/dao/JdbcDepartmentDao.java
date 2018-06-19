package ua.ukr.net.dao;

        import ua.ukr.net.model.Department;

        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;

public class JdbcDepartmentDao extends AbstractJdbcDao implements DepartmentDao {
    final static String BD_FIND_ALL_DEPART = "SELECT*FROM DEPARTMENT";

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
        List<Department> departmentList = new ArrayList<>();
        try {
            Statement statement = createConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(BD_FIND_ALL_DEPART);
            while (resultSet.next()) {
                Department department = new Department(resultSet.getLong("ID"), resultSet.getString("NAME"), null);
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
    public Department findByName(String NameDepartment) {
        return null;
    }
}


