package pl.hetman.wiktoria.java.app.socialactivitytracker.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.MissingLabelActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.ActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.UserDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.service.ActivityService;

import static org.junit.jupiter.api.Assertions.*;

class ActivityControllerTest {

    @Test
    void create() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        ActivityDao activityDao = new ActivityDao(userDao);
        ActivityService activityService = new ActivityService(activityDao);
        ActivityController activityController = new ActivityController(activityService);
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel("Dancing");

        //when
        ActivityModel createdActivityModel = activityController.create(activityModel);


        //then
        Assertions.assertNotNull(createdActivityModel, "createdActivityModel is null");


    }

    @Test
    void createWithMissingLabel() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        ActivityDao activityDao = new ActivityDao(userDao);
        ActivityService activityService = new ActivityService(activityDao);
        ActivityController activityController = new ActivityController(activityService);
        ActivityModel activityModel = new ActivityModel();

        //when


        //then
        MissingLabelActivityException exception = assertThrows(MissingLabelActivityException.class,
                () -> activityController.create(activityModel));
        Assertions.assertNotNull(exception, "Exception is null");

//        final MissingLabelActivityException[] exception = {null};
//        Assertions.assertAll(
//                () -> {
//                    exception[0] = assertThrows(MissingLabelActivityException.class,
//                            () -> activityController.create(activityModel));
//                },
//                () -> Assertions.assertNotNull(exception[0], "Exception is null")
//
//        );


    }
}