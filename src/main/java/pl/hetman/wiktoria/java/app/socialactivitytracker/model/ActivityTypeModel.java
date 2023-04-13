package pl.hetman.wiktoria.java.app.socialactivitytracker.model;

public class ActivityTypeModel {

    private String name;
    private boolean custom;

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
}
