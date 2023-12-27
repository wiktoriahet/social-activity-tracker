package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UserDao;

import java.util.Optional;

class DefaultActivityDaoTestWithID {

    @Test
    void save() throws ActivityException {
        //given
        UserDao userDao = new UserDao();
        DefaultActivityDao defaultActivityDao = new DefaultActivityDao(userDao);
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();

        activityTypeEntity.setName("cycling");
        activityTypeEntity.setCustom(false);

        ActivityEntity activityEntity = new ActivityEntity();

        //activityModel.setId(UniqueIdGenerator.generateId());
        activityEntity.chooseActivityType(activityTypeEntity);
        activityEntity.begin();
        activityEntity.end();
        String duration = activityEntity.duration();
        activityEntity.setLabel("today's cycling");

        //when
        Optional<ActivityEntity> savedActivityModel = defaultActivityDao.create(activityEntity);
        //ActivityModel savedActivityModel = activityDao.create(activityModel);

        //then

        Assertions.assertAll(
                ()->Assertions.assertNotNull(savedActivityModel, "activityModel is Null"),
                ()->Assertions.assertNotNull(savedActivityModel.get().getId(), "ID is Null")
        );
    }
}