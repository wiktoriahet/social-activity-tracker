package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc;

import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class UserDao implements Dao<UserModel> {

    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());

    @Override
    public Optional<UserModel> create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");
        LOGGER.info("create(...)");
        return Optional.empty();
    }

    @Override
    public void update(UserModel userModel) {
        LOGGER.info("update(" + userModel + ")");
        LOGGER.info("update(...)");
    }

    @Override
    public void delete(UserModel userModel) {
        LOGGER.info("delete(" + userModel + ")");
        LOGGER.info("delete(...)");
    }

    @Override
    public Optional<UserModel> read(Long id) {
        LOGGER.info("read(" + id + ")");
        LOGGER.info("read(...)");
        return Optional.empty();
    }

    @Override
    public List<UserModel> list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
        return null;
    }
}
