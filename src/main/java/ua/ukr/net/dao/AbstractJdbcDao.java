package ua.ukr.net.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class AbstractJdbcDao {

    private String configFile = "src/db.properties";
    HikariConfig config = new HikariConfig(configFile);
    HikariDataSource dataSource = new HikariDataSource(config);
    Connection connection = null;

    public Connection createConnection() throws SQLException {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("rer");
        }
        return connection;
    }
}