package pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsProperties{

    public void getProperty(){
        Properties properties = new Properties();
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

