package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

public interface Dao<T> {

    T save(T t);

    void update(T t);

    void delete(T t);

    T read(Long id);

}
