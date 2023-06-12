package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class ActivityModel {

    private static final Logger LOGGER = Logger.getLogger(ActivityModel.class.getName());


    private Long id;
    private ActivityTypeModel activityType;
    LocalDateTime start;
    LocalDateTime stop;
    private String duration;
    private String label;

    public void chooseActivityType(ActivityTypeModel activityType) {
        LOGGER.info("chooseActivityType("+activityType+")");
        //System.out.println("chooseActivityType(" + activityType + ")");
        this.activityType = activityType;
        LOGGER.info("chooseActivityType(...)");
    }

    public void begin() {
        LOGGER.info("begin()");
        //System.out.println("begin()");
        this.start = LocalDateTime.now();
        LOGGER.info("begin(...)");
    }

    public void end() {
        LOGGER.info("end()");
        //System.out.println("stop()");
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
            //System.out.println("1: " + startTemp);

            long minutes = startTemp.until(this.stop, ChronoUnit.MINUTES);
            //startTemp = startTemp.plusMinutes(minutes);
            //System.out.println("2: " + startTemp);

            long seconds = startTemp.until(this.stop, ChronoUnit.SECONDS);
            //startTemp = startTemp.plusSeconds(seconds);
            //System.out.println("3: " + startTemp);

            System.out.println("Started: " + this.start);
            System.out.println("Finished: " + this.stop);

            String duration = String.format("Duration: %02d:%02d:%02d", hours, minutes, seconds);
            System.out.println(duration);

            this.duration = duration;

            LOGGER.info("duration(...)");
            return duration;
        } else {
            LOGGER.info("duration(...)"); // TODO: 29.05.2023 czy jak gdzieś jest zwracany null, to w loggerze wpisujemy tego nulla
            return null;
        }
    }

    // TODO: 29.05.2023 czy gettery i settery też mają loggery?

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", activityType=" + activityType +
                ", start=" + start +
                ", stop=" + stop +
                ", duration='" + duration + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}