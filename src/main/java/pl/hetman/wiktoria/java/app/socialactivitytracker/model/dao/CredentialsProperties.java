package pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsProperties {

    public String getProperty(String key) {
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("credentials.properties");

        try {
            properties.load(inputStream);
            String property = properties.getProperty(key);
            return property;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setUp() throws IOException {
        Properties defaultProps = new Properties();
        FileInputStream in = new FileInputStream("src/default.properties");
        defaultProps.load(in);
        in.close();

        Properties applicationProps = new Properties(defaultProps);

        in = new FileInputStream("src/credentials.properties"); //??
        applicationProps.load(in);
        in.close();

        System.out.println(defaultProps.getProperty("database"));
        System.out.println(defaultProps.getProperty("dbuser"));
        System.out.println(defaultProps.getProperty("dbpassword"));

        System.out.println(applicationProps.getProperty("database"));
        System.out.println(applicationProps.getProperty("dbuser"));
        System.out.println(applicationProps.getProperty("dbpassword"));


    }

}

