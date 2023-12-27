package pl.hetman.wiktoria.java.app.socialactivitytracker.web.controller;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.MissingLabelActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.web.services.ActivityService;

import java.util.logging.Logger;

public class ActivityController {

    private static final Logger LOGGER = Logger.getLogger(ActivityController.class.getName());

    private final ActivityService activityService; //zależność

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // C - create
    public ActivityEntity create(ActivityEntity activityEntity) throws ActivityException {
        LOGGER.info("create(" + activityEntity + ")");
        if (activityEntity != null) {
            if (activityEntity.getLabel() == null) {
                throw new MissingLabelActivityException("Label is null");
            }
        }
        ActivityEntity createdActivityEntity = activityService.create(activityEntity);
        LOGGER.info("create(...) = " + createdActivityEntity);
        return createdActivityEntity;
    }
}

