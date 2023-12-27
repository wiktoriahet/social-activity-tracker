package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.UserEntity;

@SpringBootTest
class DefaultUserJpaDataRepositoryTest {

    private static final String ACTIVITY_NAME_FISHING = "Fishing";
    private static final String ACTIVITY_NAME_SNORKELING = "Snorkeling";

    @Autowired
    private DefaultUserJpaDataRepository defaultUserJpaDataRepository;

    @Test
    public void create() {
        //given
        UserEntity userEntity = new UserEntity();
//        ActivityModel activityModel = new ActivityModel();
//        activityModel.setLabel(ACTIVITY_NAME_SNORKELING);
//        userModel.setActivityModel(activityModel);
        //hibernate onetoone!!!!

        //when
        UserEntity savedUserEntity = defaultUserJpaDataRepository.save(userEntity);

        //then
        Assertions.assertNotNull(savedUserEntity, "savedUserModel is null");

    }

    @Test
    public void read(){
        //given
        UserEntity userEntity = new UserEntity();
        UserEntity savedUserEntity = defaultUserJpaDataRepository.save(userEntity);

        //when
        UserEntity readUserEntity = defaultUserJpaDataRepository.getReferenceById(savedUserEntity.getId());

        //then
        Assertions.assertNotNull(readUserEntity, "readUserModel is null");

    }

    @Test
    public void update(){
        //given
        UserEntity userEntity = new UserEntity();
        UserEntity savedUserEntity = defaultUserJpaDataRepository.save(userEntity);
        UserEntity updateUserEntity = new UserEntity();
        updateUserEntity.setId(savedUserEntity.getId());

        //when
        UserEntity updatedUserEntity = defaultUserJpaDataRepository.save(updateUserEntity);

        //then
        Assertions.assertNotNull(updatedUserEntity, "updatedUserModel is null");

    }
}