package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserModel {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    //@JoinColumn(name = "user_model")
    private ActivityModel activityModel;

//    private ActivityModel activityModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivityModel(ActivityModel activityModel) {
        this.activityModel = activityModel;
    }
}
