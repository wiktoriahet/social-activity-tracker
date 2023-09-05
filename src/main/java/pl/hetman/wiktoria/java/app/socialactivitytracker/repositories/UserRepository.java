package pl.hetman.wiktoria.java.app.socialactivitytracker.repositories;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.Dao;

import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<ActivityModel> {
    @Override
    public Optional<ActivityModel> create(ActivityModel activityModel) throws ActivityException {
        return Optional.empty();
    }

    @Override
    public Optional<ActivityModel> read(Long id) throws ActivityException {
        return Optional.empty();
    }

    @Override
    public void update(ActivityModel activityModel) throws ActivityException {

    }

    @Override
    public void delete(ActivityModel activityModel) throws ActivityException {

    }

    @Override
    public List<ActivityModel> list() throws ActivityException {
        return null;
    }
}
