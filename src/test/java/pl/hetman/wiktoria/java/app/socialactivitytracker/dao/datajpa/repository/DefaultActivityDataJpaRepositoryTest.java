package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;

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
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_LABEL_FISHING);
        activityEntity.setStop(LocalDateTime.now());

        //when
        ActivityEntity savedActivityEntity = defaultActivityDataJpaRepository.save(activityEntity);

        //then
        Assertions.assertNotNull(savedActivityEntity, "savedActivityModel is null");

    }

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
        ActivityEntity savedActivityEntity = defaultActivityDataJpaRepository.save(activityEntity);

        //then
        Assertions.assertNotNull(savedActivityEntity, "savedActivityModel is null");

        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedActivityEntity, "savedActivityModel is null")
                //() -> Assertions.assertNotNull(activityTypeModel.getId(), "activityTypeModel.getId() is null")
        );

    }

    @Test
    public void read() {
        //given
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_LABEL_FISHING);
        activityEntity.setStop(LocalDateTime.now());
        ActivityEntity savedActivityEntity = defaultActivityDataJpaRepository.save(activityEntity);

        //when
        ActivityEntity readActivityEntity = defaultActivityDataJpaRepository.getReferenceById(savedActivityEntity.getId());

        //then
        Assertions.assertNotNull(readActivityEntity, "readActivityModel is null");

    }

    @Test
    public void update() {
        //given
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setLabel(ACTIVITY_LABEL_FISHING);
        activityEntity.setStop(LocalDateTime.now());
        ActivityEntity savedActivityEntity = defaultActivityDataJpaRepository.save(activityEntity);
        ActivityEntity updateActivityEntity = new ActivityEntity();
        updateActivityEntity.setLabel(ACTIVITY_LABEL_FISHING);
        updateActivityEntity.setId(savedActivityEntity.getId());

        //when
        ActivityEntity updatedActivityEntity = defaultActivityDataJpaRepository.save(updateActivityEntity);

        //then
        Assertions.assertNotNull(updatedActivityEntity, "updatedActivityModel is null");


    }

}