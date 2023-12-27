package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityTypeModel;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.UserModel;

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
        ActivityTypeModel fishingActivityTypeModel = new ActivityTypeModel();
        fishingActivityTypeModel.setName(ACTIVITY_NAME_FISHING);

        ActivityModel fishingActivityModel = new ActivityModel();
        fishingActivityModel.chooseActivityType(fishingActivityTypeModel);
        fishingActivityModel.setLabel("Karp");

        UserModel userModel = new UserModel();
        userModel.setUsername("root");
//        userModel.setActivities(Set.of(fishingActivityModel));
        userModel.addActivity(fishingActivityModel);

        //when
        UserModel savedUserModel = defaultUserJpaDataRepository.save(userModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedUserModel, "savedUserModel is null"),
                () -> Assertions.assertNotNull(savedUserModel.getId(), "savedUserModel ID is null"),
                () -> Assertions.assertEquals(1, savedUserModel.getActivities().size())
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