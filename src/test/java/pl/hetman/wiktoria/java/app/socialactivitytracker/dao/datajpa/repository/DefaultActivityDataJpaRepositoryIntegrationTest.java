package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;

import java.time.LocalDateTime;

@SpringBootTest
class DefaultActivityDataJpaRepositoryIntegrationTest {

    private static final String ACTIVITY_LABEL_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_FISHING = "Fishing on Friday";

    private static final String ACTIVITY_LABEL_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultActivityDataJpaRepository defaultActivityDataJpaRepository;

    @Autowired
    private DefaultActivityTypeDataJpaRepository defaultActivityTypeDataJpaRepository;

    @Test
    //@Transactional
    public void createWithType() {
        //given
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setName(ACTIVITY_NAME_FISHING);

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_LABEL_FISHING);
        activityEntity.setStop(LocalDateTime.now());
        activityEntity.chooseActivityType(activityTypeEntity);

        //when
//        ActivityTypeModel savedActivityTypeModel = activityTypeDataJpaRepository.save(activityTypeModel);
//        activityModel.chooseActivityType(savedActivityTypeModel);
        ActivityEntity savedActivityEntity = defaultActivityDataJpaRepository.save(activityEntity);

        //then
        Assertions.assertNotNull(savedActivityEntity, "savedActivityModel is null");

        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedActivityEntity, "savedActivityModel is null"),
                () -> Assertions.assertNotNull(activityTypeEntity.getId(), "activityTypeModel.getId() is null")
        );

    }

}