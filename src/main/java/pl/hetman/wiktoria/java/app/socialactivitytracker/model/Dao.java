package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

public interface Dao<T> {

    void save(T t);

    void update(T t,String name, String[] params);

    void delete(T t, String name);

    void read(T t, String name);

}
