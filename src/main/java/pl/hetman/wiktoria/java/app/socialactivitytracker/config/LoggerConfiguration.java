package pl.hetman.wiktoria.java.app.socialactivitytracker.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

// TODO: 26.06.2023 never used więc nie ma czego testować póki co? +test
public class LoggerConfiguration {
    static {
        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("logging.properties");
            LogManager.getLogManager().readConfiguration(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
