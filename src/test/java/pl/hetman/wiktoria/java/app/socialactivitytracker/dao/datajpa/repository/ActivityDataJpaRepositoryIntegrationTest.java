package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;

import java.time.LocalDateTime;

@SpringBootTest
class ActivityDataJpaRepositoryIntegrationTest {

    private static final String ACTIVITY_LABEL_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_FISHING = "Fishing on Friday";

    private static final String ACTIVITY_LABEL_SNORKELING = "Snorkeling";

    @Autowired
    private ActivityDataJpaRepository activityDataJpaRepository;

    @Autowired
    private ActivityTypeDataJpaRepository activityTypeDataJpaRepository;

    @Test
    //@Transactional
    public void createWithType() {
        //given
        ActivityTypeModel activityTypeModel = new ActivityTypeModel();
        activityTypeModel.setName(ACTIVITY_NAME_FISHING);

        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_FISHING);
        activityModel.setStop(LocalDateTime.now());
        //activityModel.chooseActivityType(activityTypeModel);

        //when
        ActivityTypeModel savedActivityTypeModel = activityTypeDataJpaRepository.save(activityTypeModel);
        activityModel.chooseActivityType(savedActivityTypeModel);
        ActivityModel savedActivityModel = activityDataJpaRepository.save(activityModel);

        //then
        Assertions.assertNotNull(savedActivityModel, "savedActivityModel is null");

        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedActivityModel, "savedActivityModel is null"),
                () -> Assertions.assertNotNull(activityTypeModel.getId(), "activityTypeModel.getId() is null")
        );

    }

}