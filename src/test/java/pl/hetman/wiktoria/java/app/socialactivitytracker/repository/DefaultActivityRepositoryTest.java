package pl.hetman.wiktoria.java.app.socialactivitytracker.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository.DefaultActivityRepository;

import java.util.Optional;

@SpringBootTest
class DefaultActivityRepositoryTest {
    private static final String ACTIVITY_LABEL_RUNNING = "Running";
    public static final String ACTIVITY_LABEL_TENNIS = "Playing tennis";

    public DefaultActivityRepositoryTest() {
    }

    @Autowired
    DefaultActivityRepository defaultActivityRepository;

    @Test
    void create() {
        //given
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_LABEL_TENNIS);

        //when
        Optional<ActivityEntity> createdActivityModel = defaultActivityRepository.create(activityEntity);

        //then
        Assertions.assertNotNull(createdActivityModel, "createdActivityModel is null");
        Assertions.assertTrue(createdActivityModel.isPresent(), "createdActivityModel is not present");

    }
}