package ru.yandex.sashanc.data.connectiondb;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBCImpl implements ConnectionManager {
    static final Logger logger = Logger.getLogger(ConnectionManagerJDBCImpl.class);

    private static ConnectionManager connectionManager;

    private ConnectionManagerJDBCImpl() {
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerJDBCImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/students_rating",
                    "postgres",
                    "sd456jk+L");
        } catch (ClassNotFoundException | SQLException e) {
            logger.info(e);
        }
        return conn;
    }
}
