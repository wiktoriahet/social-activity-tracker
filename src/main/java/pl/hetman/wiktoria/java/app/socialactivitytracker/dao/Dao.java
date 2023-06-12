package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import java.util.Optional;

public interface Dao<T> {

    Optional<T> save(T t);

    void update(T t);

    void delete(T t);

    Optional<T> read(Long id);

    void list(T t);

}
