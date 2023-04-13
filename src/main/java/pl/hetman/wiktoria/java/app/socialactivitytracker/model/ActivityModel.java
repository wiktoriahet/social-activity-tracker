package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ActivityModel {

    private Long id;
    private ActivityTypeModel activityType;
    LocalDateTime start;
    LocalDateTime stop;
    private String duration;
    private String label;

    public void chooseActivityType(ActivityTypeModel activityType) {
        System.out.println("chooseActivityType(" + activityType + ")");
        this.activityType = activityType;
    }

    public void begin() {
        System.out.println("begin()");
        this.start = LocalDateTime.now();
    }

    public void end() {
        System.out.println("stop()");
        this.stop = LocalDateTime.now();
    }

    public String duration() {

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

            return duration;
        } else {
            return null;
        }
    }

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

// TODO: 22.03.2023 na podstawie klasy activityModel storzyć tabele w bazie danych
//  (wszystkie kolumny w typie varchar)


// dokończyć poprawić testy jednostkowe
// dokończyć implementacje metody duration
// (opcjonalnie) napisać klasę DAO z wykorzystaniem jdbc, która zapisze
// activityModel do nowo utworzonej tabeli
// 
/*
CREATE TABLE TEST(
    ID INT PRIMARY KEY,
    NAME VARCHAR(255)
);

public class Test{
    int id;
    String name;
};
 */