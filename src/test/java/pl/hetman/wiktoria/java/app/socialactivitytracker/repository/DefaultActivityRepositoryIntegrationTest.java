package pl.hetman.wiktoria.java.app.socialactivitytracker.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.hibernate.repository.DefaultActivityRepository;

import java.util.Optional;

@SpringBootTest
class DefaultActivityRepositoryIntegrationTest {

    private static final String ACTIVITY_LABEL_RUNNING = "Running";
    private static final String ACTIVITY_LABEL_KAYAKING = "Kayaking";

    @Autowired
    private DefaultActivityRepository defaultActivityRepository;

    @Test
    void createAndRead(){
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_KAYAKING);
        Optional<ActivityModel> createdActivityModel = defaultActivityRepository.create(activityModel);

        //when
        Optional<ActivityModel> readActivityModel = defaultActivityRepository.read(createdActivityModel.get().getId());

        //then
        Assertions.assertNotNull(readActivityModel, "readActivityModel is null");


    }

    @Test
    void createAndUpdate() {
        //given
        ActivityModel createActivityModel = new ActivityModel();
        createActivityModel.setLabel(ACTIVITY_LABEL_RUNNING);

        ActivityModel updateActivityModel = new ActivityModel();
        updateActivityModel.setLabel(ACTIVITY_LABEL_KAYAKING);

        //when
        Optional<ActivityModel> optionalCreatedActivityModel = defaultActivityRepository.create(createActivityModel);
        updateActivityModel.setId(optionalCreatedActivityModel.get().getId());
        Optional<ActivityModel> updatedActivityModel = defaultActivityRepository.update(updateActivityModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updatedActivityModel, "updatedActivityModel is null"),
                () -> Assertions.assertNotNull(updatedActivityModel.get().getId(), "updatedActivityModel.getId() is null"),
                () -> Assertions.assertEquals(ACTIVITY_LABEL_KAYAKING, updatedActivityModel.get().getLabel(), "updatedActivityModel.getLabel() is not equal"),
                () -> Assertions.assertNotEquals(ACTIVITY_LABEL_RUNNING, updatedActivityModel.get().getLabel(), "updatedActivityModel.getLabel() is equal")
        );

    }

    @Test
    void createAndDelete(){
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_KAYAKING);
        Optional<ActivityModel> optionalCreatedActivityModel = defaultActivityRepository.create(activityModel);

        //when
        boolean deletedActivityRepository = defaultActivityRepository.delete(optionalCreatedActivityModel.get());

        //then
        Assertions.assertEquals(true, deletedActivityRepository, "Is false");

    }
}