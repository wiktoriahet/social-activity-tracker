package pl.hetman.wiktoria.java.app.socialactivitytracker.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.ActivityDao;

class ActivityServiceTest {

    @Test
    void create() throws ActivityException {
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityService activityService = new ActivityService(activityDao);
        ActivityModel activityModel = new ActivityModel();

        //when
        ActivityModel createdActivityModel = activityService.create(activityModel);

        //then
        Assertions.assertNotNull(createdActivityModel, "createdActivityModel is null");

    }

    @Test
    void createThrows() {
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityService activityService = new ActivityService(activityDao);
        ActivityModel activityModel = new ActivityModel();

        //when

        //then
        Assertions.assertThrows(ActivityException.class,
                () -> activityService.create(activityModel));

    }
}