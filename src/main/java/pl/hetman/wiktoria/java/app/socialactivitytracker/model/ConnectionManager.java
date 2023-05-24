package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao.CredentialsProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    String driverClassName = "org.h2.Driver";
    String connectionUrl;
    String dbUser;
    String dbPwd;

    private static ConnectionManager connectionManager = null;

    private ConnectionManager(){
        CredentialsProperties credentialsProperties = new CredentialsProperties();
        try{
            Class.forName(driverClassName);
            connectionUrl = credentialsProperties.getProperty("database");
            dbUser = credentialsProperties.getProperty("dbuser");
            dbPwd = credentialsProperties.getProperty("dbpassword");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    }

    public static ConnectionManager getInstance(){
        if(connectionManager ==null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
}
