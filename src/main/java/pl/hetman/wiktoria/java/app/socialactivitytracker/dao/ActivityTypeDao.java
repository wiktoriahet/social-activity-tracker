package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ActivityTypeDao implements Dao<ActivityModel>{
    // TODO: 26.06.2023 testy później, jak będzie więcej do testowania
    private static final Logger LOGGER = Logger.getLogger(ActivityTypeDao.class.getName());

    @Override
    public Optional<ActivityModel> create(ActivityModel activityModel) {
        LOGGER.info("create(" + activityModel + ")");
        LOGGER.info("create(...)");
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
    public List<ActivityModel> list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
        return null;
    }
}
