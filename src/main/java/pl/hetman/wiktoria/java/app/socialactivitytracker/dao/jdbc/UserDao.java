package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class UserDao implements DefaultDao<UserEntity> {

    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());

    @Override
    public Optional<UserEntity> create(UserEntity userEntity) {
        LOGGER.info("create(" + userEntity + ")");
        LOGGER.info("create(...)");
        return Optional.empty();
    }

    @Override
    public void update(UserEntity userEntity) {
        LOGGER.info("update(" + userEntity + ")");
        LOGGER.info("update(...)");
    }

    @Override
    public void delete(UserEntity userEntity) {
        LOGGER.info("delete(" + userEntity + ")");
        LOGGER.info("delete(...)");
    }

    @Override
    public Optional<UserEntity> read(Long id) {
        LOGGER.info("read(" + id + ")");
        LOGGER.info("read(...)");
        return Optional.empty();
    }

    @Override
    public List<UserEntity> list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
        return null;
    }
}
