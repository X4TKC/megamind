package org.bootcamp.latam.model;

public class DialogAction {
    private String type;

    public DialogAction() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DialogAction{" +
                "type='" + type + '\'' +
                '}';
    }
}
