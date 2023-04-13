package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

public class ActivityTypeModel {

    private Long id;
    private String name;
    private boolean custom;

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

    @Override
    public String toString() {
        return "ActivityTypeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", custom=" + custom +
                '}';
    }
}
