package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserModel {

    @Id
    @GeneratedValue
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "user_model")
//    private ActivityModel activityModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void setActivityModel(ActivityModel activityModel) {
//        this.activityModel = activityModel;
//    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                '}';
    }
}
