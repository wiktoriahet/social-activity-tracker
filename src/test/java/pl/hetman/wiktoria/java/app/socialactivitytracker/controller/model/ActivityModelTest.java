package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model.ActivityModel;

import java.time.LocalDateTime;
import java.time.Month;

class ActivityModelTest {
    // TODO: 10.07.2023 poprawione LocalDateTime z ActivityModel
    @Test
    void begin() {
        //given
        ActivityModel activityModel = new ActivityModel();

        //when
        activityModel.begin();

        //then
        //Assertions.assertNotNull(activityModel.start, "activity start is null");
        Assertions.assertNotNull(activityModel.getStart(), "activity start is null");

    }

    @Test
    void end() {
        //given
        ActivityModel activityModel = new ActivityModel();

        //when
        activityModel.end();

        //then
        //Assertions.assertNotNull(activityModel.stop, "activity stop is null");
        Assertions.assertNotNull(activityModel.getStop(), "activity stop is null");


    }


/*
    @Test
    void durationStartStop(){
        //given
        ActivityModel activityModel = new ActivityModel();
        activityModel.start = LocalDateTime.of(2023, Month.MARCH, 22, 11, 30, 10);
        activityModel.stop = LocalDateTime.of(2023, Month.APRIL, 23, 11, 53, 45);

        //when
        LocalDateTime duration = activityModel.duration();

        //then
        //Assertions.assertEquals();
    }

 */

    @Test
    void difference(){
        //given
        ActivityModel activityModel = new ActivityModel();
//        activityModel.start = LocalDateTime.of(2023, Month.MARCH, 22, 11, 30, 10);
//        activityModel.stop = LocalDateTime.of(2023, Month.MARCH, 22, 11, 31, 9);
        LocalDateTime start = LocalDateTime.of(2023, Month.MARCH, 22, 11, 30, 10);
        activityModel.setStart(start);
        LocalDateTime stop = LocalDateTime.of(2023, Month.MARCH, 22, 12, 30, 10);
        activityModel.setStop(stop);

        //when
        String difference = activityModel.duration();

        //then
        Assertions.assertNotNull(difference, "Difference is null");

    }



}