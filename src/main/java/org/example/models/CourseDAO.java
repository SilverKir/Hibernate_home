package org.example.models;

import org.example.models.Course;

import java.util.List;

public interface CourseDAO {
    public Course findByID(int id);
    public void save(Course course);
    public  void delete(int id);
    public  void update(int id, String title, int duration);
    public  List<Course> getAll();
}
