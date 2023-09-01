package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActivityDaoSpringTest {

//    @Autowired
//    private ActivityDao activityDao;
//
//    @Test
//    void read() throws ActivityException {
//        //given
//        ActivityModel activityModel = new ActivityModel();
//
//        //when
//        Optional<ActivityModel> optionalActivityModel = activityDao.read(1L);
//
//        //then
//        Assertions.assertNotNull(optionalActivityModel, "optionalActivityModel is null");
//    }
}