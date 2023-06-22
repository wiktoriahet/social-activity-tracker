package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.api.exception.ActivityException;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoListTest {
    // TODO: 20.06.2023 test dla listy
    @Test
    void list() throws ActivityException {
        //given
        ActivityDao activityDao = new ActivityDao();

        //when
        List<ActivityModel> activityModelList = activityDao.list();

        //then
        Assertions.assertNotNull(activityModelList, "activityModelList is null");


    }
}