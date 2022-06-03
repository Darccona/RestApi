package org.darccona.model;

public class TaskModel {
    private String text;

    public TaskModel() {}
    public TaskModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
