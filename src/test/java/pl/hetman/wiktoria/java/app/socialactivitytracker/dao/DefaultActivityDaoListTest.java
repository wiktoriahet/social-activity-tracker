package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

import java.util.List;

class DefaultActivityDaoListTest {

    @Test
    void list() throws ActivityException {
        //given
        // TODO: 10.07.2023 poprawiony test dla userDao?
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);

        //when
        List<ActivityModel> activityModelList = defaultActivityDao.list();

        //then
        Assertions.assertNotNull(activityModelList, "activityModelList is null");


    }
}