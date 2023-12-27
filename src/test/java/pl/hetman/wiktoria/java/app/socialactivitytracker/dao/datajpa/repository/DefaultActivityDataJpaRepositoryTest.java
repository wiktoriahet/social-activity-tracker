package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

import java.time.LocalDateTime;

@SpringBootTest
class DefaultActivityDataJpaRepositoryTest {

    private static final String ACTIVITY_LABEL_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_FISHING = "Fishing on Friday";

    private static final String ACTIVITY_LABEL_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultActivityDataJpaRepository defaultActivityDataJpaRepository;

    @Test
    public void create() {
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_FISHING);
        activityModel.setStop(LocalDateTime.now());

        //when
        ActivityModel savedActivityModel = defaultActivityDataJpaRepository.save(activityModel);

        //then
        Assertions.assertNotNull(savedActivityModel, "savedActivityModel is null");

    }

    @Test
    //@Transactional
    public void createWithType() {
        //given
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName(ACTIVITY_NAME_FISHING);

        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_FISHING);
        activityModel.setStop(LocalDateTime.now());
        activityModel.chooseActivityType(activityTypeModel);

        //when
        ActivityModel savedActivityModel = defaultActivityDataJpaRepository.save(activityModel);

        //then
        Assertions.assertNotNull(savedActivityModel, "savedActivityModel is null");

        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedActivityModel, "savedActivityModel is null")
                //() -> Assertions.assertNotNull(activityTypeModel.getId(), "activityTypeModel.getId() is null")
        );

    }

    @Test
    public void read() {
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_FISHING);
        activityModel.setStop(LocalDateTime.now());
        ActivityModel savedActivityModel = defaultActivityDataJpaRepository.save(activityModel);

        //when
        ActivityModel readActivityModel = defaultActivityDataJpaRepository.getReferenceById(savedActivityModel.getId());

        //then
        Assertions.assertNotNull(readActivityModel, "readActivityModel is null");

    }

    @Test
    public void update() {
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_FISHING);
        activityModel.setStop(LocalDateTime.now());
        ActivityModel savedActivityModel = defaultActivityDataJpaRepository.save(activityModel);
        ActivityModel updateActivityModel = new ActivityModel();
        updateActivityModel.setLabel(ACTIVITY_LABEL_FISHING);
        updateActivityModel.setId(savedActivityModel.getId());

        //when
        ActivityModel updatedActivityModel = defaultActivityDataJpaRepository.save(updateActivityModel);

        //then
        Assertions.assertNotNull(updatedActivityModel, "updatedActivityModel is null");


    }

}