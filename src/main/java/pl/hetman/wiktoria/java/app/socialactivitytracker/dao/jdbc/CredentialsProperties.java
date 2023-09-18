package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

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

}

