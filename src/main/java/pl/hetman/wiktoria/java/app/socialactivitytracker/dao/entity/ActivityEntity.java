package pl.hetman.wiktoria.java.app.socialactivitytracker.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

@Entity
@Table(name = "ACTIVITIES")
public class ActivityEntity {

    private static final Logger LOGGER = Logger.getLogger(ActivityEntity.class.getName());

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserEntity user;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ACTIVITY_TYPE_ID")
    private ActivityTypeEntity activityType; // <- przez to null pointer

    @Column(name = "START")
    private LocalDateTime start;
    @Column(name = "STOP")
    private LocalDateTime stop;
    @Column(name = "DURATION")
    private String duration;
    @Column(name = "LABEL")
    private String label;

    public ActivityEntity() {
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
                ", activityType=" + activityType +
                ", start=" + start +
                ", stop=" + stop +
                ", duration='" + duration + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}