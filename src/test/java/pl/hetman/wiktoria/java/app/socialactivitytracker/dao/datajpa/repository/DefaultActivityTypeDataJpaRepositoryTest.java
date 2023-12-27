package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;

import java.util.Optional;

@SpringBootTest
class DefaultActivityTypeDataJpaRepositoryTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultActivityTypeDataJpaRepository defaultActivityTypeDataJpaRepository;

    @Test
    public void create() {
        //given
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setCustom(true);
        activityTypeEntity.setName(ACTIVITY_NAME_SNORKELING);

        //when
        ActivityTypeEntity savedActivityTypeEntity = defaultActivityTypeDataJpaRepository.save(activityTypeEntity);

        //then
        Assertions.assertNotNull(savedActivityTypeEntity, "savedActivityTypeModel is null");

    }

    @Test
    public void read(){
        //given
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setCustom(true);
        activityTypeEntity.setName(ACTIVITY_NAME_SNORKELING);
        ActivityTypeEntity savedActivityTypeEntity = defaultActivityTypeDataJpaRepository.save(activityTypeEntity);

        //when
        Optional<ActivityTypeEntity> readActivityTypeModel = defaultActivityTypeDataJpaRepository.findById(savedActivityTypeEntity.getId());

        //then
        Assertions.assertNotNull(readActivityTypeModel, "readActivityTypeModel is null");

    }

    @Test
    public void update(){
        //given
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setCustom(true);
        activityTypeEntity.setName(ACTIVITY_NAME_SNORKELING);
        ActivityTypeEntity savedActivityTypeEntity = defaultActivityTypeDataJpaRepository.save(activityTypeEntity);
        ActivityTypeEntity updateActivityTypeEntity = new ActivityTypeEntity();
        updateActivityTypeEntity.setName(ACTIVITY_NAME_FISHING);
        updateActivityTypeEntity.setId(savedActivityTypeEntity.getId());

        //when
        ActivityTypeEntity updatedActivityTypeEntity = defaultActivityTypeDataJpaRepository.save(updateActivityTypeEntity);

        //then
        Assertions.assertNotNull(updatedActivityTypeEntity, "updatedActivityTypeModel is null");


    }

    @Test
    public void delete(){
        //given
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setCustom(true);
        activityTypeEntity.setName(ACTIVITY_NAME_SNORKELING);

        //when
        ActivityTypeEntity savedActivityTypeEntity = defaultActivityTypeDataJpaRepository.save(activityTypeEntity);
        defaultActivityTypeDataJpaRepository.delete(savedActivityTypeEntity);

        //then
        //Assertions.assertNull(savedActivityTypeModel, "savedActivityTypeModel is not null");

    }
}