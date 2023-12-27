package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
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
        List<ActivityEntity> activityEntityList = defaultActivityDao.list();

        //then
        Assertions.assertNotNull(activityEntityList, "activityModelList is null");


    }
}