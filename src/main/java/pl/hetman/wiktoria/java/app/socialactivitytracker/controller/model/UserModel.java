package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserModel {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
//    @JoinColumn(name = "user_model")
    private Set<ActivityModel> activities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ActivityModel> getActivities() {
        return activities;
    }

    public void setActivities(Set<ActivityModel> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                '}';
    }
}
