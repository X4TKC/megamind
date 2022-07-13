package org.bootcamp.latam.model;

public class Intent {
    private String name;
    private String state;

    public Intent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Intent{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
