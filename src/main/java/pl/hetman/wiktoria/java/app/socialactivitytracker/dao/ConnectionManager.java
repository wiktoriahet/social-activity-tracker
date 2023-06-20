package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class.getName());

    String driverClassName = "org.h2.Driver";
    String connectionUrl;
    String dbUser;
    String dbPwd;

    private static ConnectionManager connectionManager = null;

    private ConnectionManager() {
        CredentialsProperties credentialsProperties = new CredentialsProperties();
        try {
            Class.forName(driverClassName);
            connectionUrl = credentialsProperties.getProperty("database");
            dbUser = credentialsProperties.getProperty("dbuser");
            dbPwd = credentialsProperties.getProperty("dbpassword");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
// TODO: 15.06.2023 dodać własny wyjątek do metody getConnection
    // meotda musi rzucać własny wyjątek, obsługiwać to except. i runtime
    // refactor całego kodu korzystającego z getConnection

    public Connection getConnection() throws SQLException {
        LOGGER.info("getConnection()");
        Connection connection = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        LOGGER.info("getConnection(...) = " + connection);
        return connection;
    }

    public static ConnectionManager getInstance() {
        LOGGER.info("getInstance()");
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        LOGGER.info("getInstance(...)");
        return connectionManager;
    }
}
