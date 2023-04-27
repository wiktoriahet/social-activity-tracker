package pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao;

import java.util.Random;

public class UniqueIdGenerator {

    public static Long generateId(){
        Random random = new Random();
        long id = random.nextLong(1_000_000L);
        return id;
    }

}
