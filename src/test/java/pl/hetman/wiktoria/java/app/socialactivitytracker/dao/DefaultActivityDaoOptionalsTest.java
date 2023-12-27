package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DefaultActivityDaoOptionalsTest {

    public static final String ACTIVITY_MODEL_LABEL_DANCE = "today's dancing";

    @Test
    void save() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);

        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setName("playing zbijak");
        activityTypeEntity.setCustom(false);

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.chooseActivityType(activityTypeEntity);
        activityEntity.begin();
        activityEntity.setLabel("today's zbijak");

        //when
        Optional<ActivityEntity> savedActivity = defaultActivityDao.create(activityEntity);

        //then
        Assertions.assertAll(
                ()-> assertTrue(savedActivity.isPresent(), "Optional is not present"),
                ()-> assertNotNull(savedActivity, "Optional is null")
        );
    }

}