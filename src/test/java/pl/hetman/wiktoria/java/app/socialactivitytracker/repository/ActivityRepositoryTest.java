package pl.hetman.wiktoria.java.app.socialactivitytracker.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository.ActivityRepository;

import java.util.Optional;

@SpringBootTest
class ActivityRepositoryTest {
    private static final String ACTIVITY_LABEL_RUNNING = "Running";
    public static final String ACTIVITY_LABEL_TENNIS = "Playing tennis";

    public ActivityRepositoryTest() {
    }

    @Autowired
    ActivityRepository activityRepository;

    @Test
    void create() {
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_TENNIS);

        //when
        Optional<ActivityModel> createdActivityModel = activityRepository.create(activityModel);

        //then
        Assertions.assertNotNull(createdActivityModel, "createdActivityModel is null");
        Assertions.assertTrue(createdActivityModel.isPresent(), "createdActivityModel is not present");

    }
}