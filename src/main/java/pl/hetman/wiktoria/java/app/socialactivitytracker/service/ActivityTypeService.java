package pl.hetman.wiktoria.java.app.socialactivitytracker.service;

import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.ActivityDao;

import java.util.List;
import java.util.logging.Logger;

public class ActivityTypeService {
    private static final Logger LOGGER = Logger.getLogger(ActivityTypeService.class.getName());

    private final ActivityDao activityDao; //zależność

    public ActivityTypeService(ActivityDao activityDao) { //wstrzykiwanie zależności za pomocą konstr.
        this.activityDao = activityDao;
    }


    // C - create
    public ActivityTypeModel create(ActivityTypeModel activityTypeModel) {
        return null;
    }
    // R - read
    public ActivityTypeModel read(Long id) {
        return null;
    }
    // U - update
    public ActivityTypeModel update(Long id) {
        return null;
    }
    // D - delete
    public void delete(Long id) {
    }
    // L - list
    public List<ActivityTypeModel> list() {
        return null;
    }

}
