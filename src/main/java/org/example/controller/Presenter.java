package org.example.controller;
import org.example.models.CourseDAOImpl;
import org.example.view.View;


public class Presenter {
    CourseDAOImpl model;
    View view;

    public Presenter(View view, CourseDAOImpl model) {
        this.model = model;
        this.view = view;
    }

    public void append() {
        view.set("Insert course name:");
        String courseName = view.get();
        view.set("Insert course duration:");
        int courseDuration = checkInteger(view.get());
        model.add(courseName, courseDuration);
        view.set("ok");
    }

    public void show() {
        view.set(model.showAll());
    }

    public void change() {
        show();
        view.set("Insert Course id");
        int courseId = checkInteger(view.get());
        view.set("Insert new title:");
        String title = view.get();
        view.set("Insert new duration:");
        int duration = checkInteger(view.get());
        model.update(courseId, title, duration);
        view.set("ok");
        show();
    }

    public void delete(){
        show();
        view.set("Insert Course id to delete");
        int courseId = checkInteger(view.get());
        model.delete(courseId);
        view.set("ok");
        show();
    }

    public Integer checkInteger(String userData) {
        try {
            return Integer.parseInt(userData);
        } catch (Exception e) {
            throw new IllegalArgumentException("Insert value" + userData + " is not a Integer!");
        }
    }
}

