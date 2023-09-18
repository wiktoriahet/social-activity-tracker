package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.time.LocalDateTime;

@SpringBootTest
class ActivityDataJpaRepositoryTest {

    private static final String ACTIVITY_LABEL_FISHING = "Fishing";
    private static final String ACTIVITY_LABEL_SNORKELING = "Snorkeling";

    @Autowired
    private ActivityDataJpaRepository activityDataJpaRepository;

    @Test
    public void create(){
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.setLabel(ACTIVITY_LABEL_FISHING);
        activityModel.setStop(LocalDateTime.now());

        //when
        ActivityModel savedActivityModel = activityDataJpaRepository.save(activityModel);

        //then
        Assertions.assertNotNull(savedActivityModel, "savedActivityModel is null");

    }

}