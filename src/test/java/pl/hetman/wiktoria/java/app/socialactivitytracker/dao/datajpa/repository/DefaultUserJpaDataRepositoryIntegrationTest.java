package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.UserEntity;

@SpringBootTest
class DefaultUserJpaDataRepositoryIntegrationTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultUserJpaDataRepository defaultUserJpaDataRepository;

    @Test
//    @Transactional
//    @Rollback(value = false)
    public void create() {
        //given
        ActivityTypeEntity fishingActivityTypeEntity = new ActivityTypeEntity();
        fishingActivityTypeEntity.setName(ACTIVITY_NAME_FISHING);

        ActivityEntity fishingActivityEntity = new ActivityEntity();
        fishingActivityEntity.chooseActivityType(fishingActivityTypeEntity);
        fishingActivityEntity.setLabel("Karp");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("root");
//        userModel.setActivities(Set.of(fishingActivityModel));
        userEntity.addActivity(fishingActivityEntity);

        //when
        UserEntity savedUserEntity = defaultUserJpaDataRepository.save(userEntity);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedUserEntity, "savedUserModel is null"),
                () -> Assertions.assertNotNull(savedUserEntity.getId(), "savedUserModel ID is null"),
                () -> Assertions.assertEquals(1, savedUserEntity.getActivities().size())
        );
    }
}
/*
SELECT *
FROM ACTIVITIES A
JOIN USERS U
ON A.USER_ID = U.ID
JOIN ACTIVITY_TYPES AT
ON A.ACTIVITY_TYPE_ID =AT.ID;

--

SELECT *
FROM ACTIVITIES A
JOIN USERS_ACTIVITIES UA
ON A.ID = UA.ACTIVITIES_ID
JOIN USERS U
ON U.ID = UA.USERMODEL_ID
JOIN ACTIVITY_TYPES AT
ON A.ACTIVITY_TYPE_ID =AT.ID;

----

drop table users_activities ;
drop table activities ;
drop table activity_types ;
drop table users ;
 */