package org.darccona.database;

import javax.persistence.*;

@Entity
public class TaskEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "STATE")
    private boolean finished;

    @Column(name = "TEXT")
    private String text;

    public TaskEntity() {}
    public TaskEntity(String text) {
        this.text = text;
        finished = false;
    }

    public long getId() {
        return id;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getText() {
        return text;
    }
}
