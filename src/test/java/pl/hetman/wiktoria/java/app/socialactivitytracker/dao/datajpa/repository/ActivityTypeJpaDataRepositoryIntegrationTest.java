package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;

import java.util.Optional;

@SpringBootTest
public class ActivityTypeJpaDataRepositoryIntegrationTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultActivityTypeDataJpaRepository defaultActivityTypeDataJpaRepository;

    @Test
    public void delete(){
        //given
        ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
        activityTypeEntity.setCustom(true);
        activityTypeEntity.setName(ACTIVITY_NAME_SNORKELING);

        //when
        ActivityTypeEntity savedActivityTypeEntity = defaultActivityTypeDataJpaRepository.save(activityTypeEntity);
        defaultActivityTypeDataJpaRepository.delete(savedActivityTypeEntity);
        Optional<ActivityTypeEntity> optionalReadActivityTypeModel =
                defaultActivityTypeDataJpaRepository.findById(savedActivityTypeEntity.getId());
        ActivityTypeEntity readActivityTypeEntity = optionalReadActivityTypeModel.orElse(null);


        //then
        Assertions.assertNull(readActivityTypeEntity, "savedActivityTypeModel is not null");

    }
}
