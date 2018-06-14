package ua.ukr.net.dao;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class AbstractJdbcDao {

    public Connection createConnection() throws SQLException {
        return null;
    };


}
