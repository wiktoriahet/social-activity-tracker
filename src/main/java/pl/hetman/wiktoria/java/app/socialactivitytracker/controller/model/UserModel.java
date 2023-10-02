package pl.hetman.wiktoria.java.app.socialactivitytracker.controller.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserModel {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "USER_ID")
    private Set<ActivityModel> activities = new HashSet<>();

    public void addActivity(ActivityModel activityModel) {
        this.activities.add(activityModel);
        activityModel.setUser(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
