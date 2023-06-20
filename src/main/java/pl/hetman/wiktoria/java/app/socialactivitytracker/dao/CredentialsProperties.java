package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class CredentialsProperties {

    private static final Logger LOGGER = Logger.getLogger(CredentialsProperties.class.getName());

    public String getProperty(String key) {
        LOGGER.info("getProperty("+ key +")");
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("credentials.properties");

        try {
            properties.load(inputStream);
            String property = properties.getProperty(key);
            LOGGER.info("getProperty(...)");
            return property;
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("getProperty(...)");
        return null;
    }

    public void setUp() throws IOException {
        LOGGER.info("setUp()");
        Properties defaultProps = new Properties();
        FileInputStream in = new FileInputStream("default.properties");
        defaultProps.load(in);
        in.close();

        Properties applicationProps = new Properties(defaultProps);

        in = new FileInputStream("credentials.properties");
        applicationProps.load(in);
        in.close();

        System.out.println(defaultProps.getProperty("database"));
        System.out.println(defaultProps.getProperty("dbuser"));
        System.out.println(defaultProps.getProperty("dbpassword"));

        System.out.println(applicationProps.getProperty("database"));
        System.out.println(applicationProps.getProperty("dbuser"));
        System.out.println(applicationProps.getProperty("dbpassword"));

        LOGGER.info("setUp(...)");


    }

}

