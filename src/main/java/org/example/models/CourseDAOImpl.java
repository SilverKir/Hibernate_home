package org.example.models;

import org.example.controller.HibernateController;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {


    public void add (String name, int duration){
        save(new Course(name,duration));
    }

    @Override
    public Course findByID(int id) {
        Session session = HibernateController.getSessionFactory(Course.class).openSession();
        return session.get(Course.class, id);
    }

    @Override
    public void save(Course course) {
        Session session = HibernateController.getSessionFactory(Course.class).openSession();
        Transaction transaction= session.beginTransaction();
        session.persist(course);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateController.getSessionFactory(Course.class).openSession();
        Transaction transaction= session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.remove(course);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(int id, String title, int duration) {
        Session session = HibernateController.getSessionFactory(Course.class).openSession();
        Transaction transaction= session.beginTransaction();
        Course course = session.get(Course.class, id);
        course.setTitle(title);
        course.setDuration(duration);
        session.merge(course);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Course> getAll() {
        return (List<Course>) HibernateController.getSessionFactory(Course.class)
                .openSession().createQuery("From Course", Course.class).list();
    }

    public String showAll(){
        StringBuilder sb =new StringBuilder();
        for (Course course: getAll()) {
            sb.append(course.toString()).append("\n");
        }
        return sb.toString();
    }
}
