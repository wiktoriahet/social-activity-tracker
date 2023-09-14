package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import java.util.Random;
import java.util.logging.Logger;

public class UniqueIdGenerator {

    private static final Logger LOGGER = Logger.getLogger(UniqueIdGenerator.class.getName());

    public static Long generateId(){
        LOGGER.info("generateId()");
        Random random = new Random();
        long id = random.nextLong(1_000_000L);
        LOGGER.info("generateId(...)");
        return id;
    }

}
