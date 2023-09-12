package pl.hetman.wiktoria.java.app.socialactivitytracker.controller;

import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.MissingLabelActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.services.ActivityService;

import java.util.logging.Logger;

public class ActivityController {

    private static final Logger LOGGER = Logger.getLogger(ActivityController.class.getName());

    private final ActivityService activityService; //zależność

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // C - create
    public ActivityModel create(ActivityModel activityModel) throws ActivityException {
        LOGGER.info("create(" + activityModel + ")");
        if (activityModel != null) {
            if (activityModel.getLabel() == null) {
                throw new MissingLabelActivityException("Label is null");
            }
        }
        ActivityModel createdActivityModel = activityService.create(activityModel);
        LOGGER.info("create(...) = " + createdActivityModel);
        return createdActivityModel;
    }
}

