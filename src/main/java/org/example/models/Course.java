package org.example.models;

import jakarta.persistence.*;


@Entity
@Table (name="course")
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String title;
private int duration;

public Course(){

};

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ';';
    }
}
