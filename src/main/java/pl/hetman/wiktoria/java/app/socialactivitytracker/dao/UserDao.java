package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class UserDao implements Dao<ActivityModel>{

    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());

    @Override
    public Optional<ActivityModel> save(ActivityModel activityModel) {
        LOGGER.info("save(" + activityModel + ")");
        LOGGER.info("save(...)");
        return Optional.empty();
    }

    @Override
    public void update(ActivityModel activityModel) {
        LOGGER.info("update(" + activityModel + ")");
        LOGGER.info("update(...)");
    }

    @Override
    public void delete(ActivityModel activityModel) {
        LOGGER.info("delete(" + activityModel + ")");
        LOGGER.info("delete(...)");
    }

    @Override
    public Optional<ActivityModel> read(Long id) {
        LOGGER.info("read(" + id + ")");
        LOGGER.info("read(...)");
        return Optional.empty();
    }

    @Override
    public List<ActivityModel> list(ActivityModel activityModel) {
        LOGGER.info("list(" + activityModel + ")");
        LOGGER.info("list(...)");
        return null;
    }
}
