package pl.hetman.wiktoria.java.app.socialactivitytracker.services;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.ActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.repositories.ActivityRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ActivityService {

    private static final Logger LOGGER = Logger.getLogger(ActivityService.class.getName());

//    private final ActivityDao activityDao; //zależność
//
//    public ActivityService(ActivityDao activityDao) { //wstrzykiwanie zależności za pomocą konstr.
//        this.activityDao = activityDao;
//    }

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    // C - create
    public ActivityModel create(ActivityModel activityModel) throws ActivityException {
        LOGGER.info("create(" + activityModel + ")");
        Optional<ActivityModel> optionalActivityModel =
                //activityDao.create(activityModel); //delegacja
                activityRepository.create(activityModel);
        ActivityModel createdActivityModel = optionalActivityModel.orElseThrow(
                () -> new ActivityException("Unable to create activity"));

        LOGGER.info("create(...) = " + createdActivityModel);
        return createdActivityModel;
    }

    // R - read
    public ActivityModel read(Long id) {
        return null;
    }

    // U - update
    public ActivityModel update(Long id, ActivityModel activityModel) {
        return null;
    }

    // D - delete
    public void delete(Long id) {
    }

    // L - list
    public List<ActivityModel> list() {
        return null;
    }

}