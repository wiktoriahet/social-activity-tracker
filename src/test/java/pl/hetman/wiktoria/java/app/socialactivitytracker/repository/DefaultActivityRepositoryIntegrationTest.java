package pl.hetman.wiktoria.java.app.socialactivitytracker.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
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
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_LABEL_KAYAKING);
        Optional<ActivityEntity> createdActivityModel = defaultActivityRepository.create(activityEntity);

        //when
        Optional<ActivityEntity> readActivityModel = defaultActivityRepository.read(createdActivityModel.get().getId());

        //then
        Assertions.assertNotNull(readActivityModel, "readActivityModel is null");


    }

    @Test
    void createAndUpdate() {
        //given
        ActivityEntity createActivityEntity = new ActivityEntity();
        createActivityEntity.setLabel(ACTIVITY_LABEL_RUNNING);

        ActivityEntity updateActivityEntity = new ActivityEntity();
        updateActivityEntity.setLabel(ACTIVITY_LABEL_KAYAKING);

        //when
        Optional<ActivityEntity> optionalCreatedActivityModel = defaultActivityRepository.create(createActivityEntity);
        updateActivityEntity.setId(optionalCreatedActivityModel.get().getId());
        Optional<ActivityEntity> updatedActivityModel = defaultActivityRepository.update(updateActivityEntity);

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
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_LABEL_KAYAKING);
        Optional<ActivityEntity> optionalCreatedActivityModel = defaultActivityRepository.create(activityEntity);

        //when
        boolean deletedActivityRepository = defaultActivityRepository.delete(optionalCreatedActivityModel.get());

        //then
        Assertions.assertEquals(true, deletedActivityRepository, "Is false");

    }
}