package main.java.ua.ukr.net.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

import static javafx.scene.input.KeyCode.F;

public abstract class AbstractJdbcDao {
    public static final String BD_DRIVER = "org.h2.Driver";
    public static final String BD_URL = "";
    public static final String BD_LOGIN = "";
    public static final String BD_PASSWORD = "";

    Connection connection;

    public Connection createConnection() throws SQLException {


        return null;
    }

    ;
}
