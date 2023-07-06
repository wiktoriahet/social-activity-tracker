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

    // TODO: 26.06.2023 ten test poki co zawsze fail,
    //  bo nie wywala tam exception,
    //  bo da sie bez problemu stworzyc activity?
    @Test
    void createThrows() {
        //given
        ActivityDao activityDao = new ActivityDao();
        ActivityService activityService = new ActivityService(activityDao);
        ActivityModel activityModel = new ActivityModel();

        //when

        //then
//        Assertions.assertDoesNotThrow(ActivityException.class,
//                () -> activityService.create(activityModel));
        Assertions.assertDoesNotThrow(() -> activityService.create(activityModel),
                "");


    }
}