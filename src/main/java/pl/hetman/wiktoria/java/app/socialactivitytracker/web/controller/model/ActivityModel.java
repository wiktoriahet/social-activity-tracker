package pl.hetman.wiktoria.java.app.socialactivitytracker.web.controller.model;

import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.ActivityTypeEntity;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity.UserEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class ActivityModel {

    private static final Logger LOGGER = Logger.getLogger(ActivityModel.class.getName());

    private Long id;
    private UserEntity user;
    private ActivityTypeEntity activityType;
    private LocalDateTime start;
    private LocalDateTime stop;
    private String duration;
    private String label;

    public ActivityModel() {
    }

    public void chooseActivityType(ActivityTypeEntity activityType) {
        LOGGER.info("chooseActivityType(" + activityType + ")");
        this.activityType = activityType;
        LOGGER.info("chooseActivityType(...)");
    }

    public void begin() {
        LOGGER.info("begin()");
        this.start = LocalDateTime.now();
        LOGGER.info("begin(...)");
    }

    public void end() {
        LOGGER.info("end()");
        this.stop = LocalDateTime.now();
        LOGGER.info("end(...)");
    }

    public String duration() {

        LOGGER.info("duration()");

        if (this.start != null && this.stop != null) {

            System.out.println("Difference()");

            LocalDateTime startTemp = LocalDateTime.from(this.start);

            long hours = startTemp.until(this.stop, ChronoUnit.HOURS);
            startTemp = startTemp.plusHours(hours);

            long minutes = startTemp.until(this.stop, ChronoUnit.MINUTES);

            long seconds = startTemp.until(this.stop, ChronoUnit.SECONDS);

            System.out.println("Started: " + this.start);
            System.out.println("Finished: " + this.stop);

            String duration = String.format("Duration: %02d:%02d:%02d", hours, minutes, seconds);
            System.out.println(duration);

            this.duration = duration;

            LOGGER.info("duration(...)");
            return duration;
        } else {
            LOGGER.info("duration(...)");
            return null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ActivityTypeEntity getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityTypeEntity activityType) {
        this.activityType = activityType;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStop() {
        return stop;
    }

    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ActivityModel{" +
                "id=" + id +
                ", user=" + user +
                ", activityType=" + activityType +
                ", start=" + start +
                ", stop=" + stop +
                ", duration='" + duration + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
