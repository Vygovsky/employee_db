package ua.ukr.net.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class AbstractJdbcDao {
    /*
        private String configFile = "db.properties";
        HikariConfig config = new HikariConfig(configFile);
        HikariDataSource dataSource = new HikariDataSource(config);*/
    private Connection connection = null;

    public Connection createConnection() throws SQLException {
        try {
            connection = new HikariDataSource(getHikariConfig()).getConnection();
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return connection;
   }

    private HikariConfig getHikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(null);
        config.setDriverClassName("org.h2.Driver");
        config.setJdbcUrl("jdbc:h2:~/test");
        config.setUsername("sa");
        config.setPassword("");
        return config;
    }
}