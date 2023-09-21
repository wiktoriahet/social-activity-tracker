package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ActivityTypeModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean custom;

//    @OneToOne
//    @JoinColumn(name = "activity_model")
//    private ActivityModel activityModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

//    public void setActivityModel(ActivityModel activityModel) {
//        this.activityModel = activityModel;
//    }

    @Override
    public String toString() {
        return "ActivityTypeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", custom=" + custom +
                '}';
    }
}
