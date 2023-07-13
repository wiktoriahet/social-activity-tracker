package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class ActivityModel {

    // TODO: 06.07.2023 https://github.com/juniorjavadeveloper-pl/hibernate-examples
    // zapoznać się z przykładem https://github.com/juniorjavadeveloper-pl/hibernate-examples/tree/master/src/test/java/pl/juniorjavadeveloper/examples/hibernate/basic/entity/model
    // sklonować repozytorium
    // stworzyć nowy projekt dla getting started z hibernate.org https://docs.jboss.org/hibernate/orm/6.2/quickstart/html_single/#tutorial-native


    private static final Logger LOGGER = Logger.getLogger(ActivityModel.class.getName());


    private Long id;
    private UserModel user;
    private ActivityTypeModel activityType;
    // TODO: 06.07.2023 dodać hermetyzajce localdatetime i poprawic wszystko w kodzie [x]
    private LocalDateTime start;
    private LocalDateTime stop;
    private String duration;
    private String label;

    public ActivityModel() {
    }

    public ActivityModel(UserModel user, ActivityTypeModel activityType) {
        this.user = user;
        this.activityType = activityType;
    }

    public void chooseActivityType(ActivityTypeModel activityType) {
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public ActivityTypeModel getActivityType() {
        return activityType;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getStop() {
        return stop;
    }

    public LocalDateTime setStart(LocalDateTime start) {
        this.start = start;
        return start;
    }

    public LocalDateTime setStop(LocalDateTime stop) {
        this.stop = stop;
        return stop;
    }

    public String getDuration() {
        return duration;
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