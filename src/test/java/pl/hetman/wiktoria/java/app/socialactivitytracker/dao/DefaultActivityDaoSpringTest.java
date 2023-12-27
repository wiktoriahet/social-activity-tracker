package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.DefaultActivityDao;

import java.util.Optional;

@SpringBootTest
class DefaultActivityDaoSpringTest {

    @Autowired
    private DefaultActivityDao defaultActivityDao;

    @Test
    void read() throws ActivityException {
        //given
        ActivityEntity activityEntity = new ActivityEntity();

        //when
        Optional<ActivityEntity> optionalActivityModel = defaultActivityDao.read(1L);

        //then
        Assertions.assertNotNull(optionalActivityModel, "optionalActivityModel is null");
    }
}