//package pl.hetman.wiktoria.java.app.socialactivitytracker.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
//import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
//import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.ActivityDao;
//import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;
//
//class ActivityServiceTest {
//
//    @Test
//    void create() throws ActivityException {
//        //given
//        UserDao userDao = new UserDao();
//        ActivityDao activityDao = new ActivityDao(userDao);
//        ActivityService activityService = new ActivityService(activityDao);
//        ActivityModel activityModel = new ActivityModel();
//
//        //when
//        ActivityModel createdActivityModel = activityService.create(activityModel);
//
//        //then
//        Assertions.assertNotNull(createdActivityModel, "createdActivityModel is null");
//
//    }
//
//    @Test
//    void createThrows() {
//        //given
//        UserDao userDao = new UserDao();
//        ActivityDao activityDao = new ActivityDao(userDao);
//        ActivityService activityService = new ActivityService(activityDao);
//        ActivityModel activityModel = new ActivityModel();
//
//        //when
//
//        //then
////        Assertions.assertDoesNotThrow(ActivityException.class,
////                () -> activityService.create(activityModel));
//        Assertions.assertDoesNotThrow(() -> activityService.create(activityModel),
//                "");
//
//
//    }
//}