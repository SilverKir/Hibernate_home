package org.example.controller;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateController {

    private static SessionFactory sessionFactory;

    public HibernateController() {
    }

    public static <T> SessionFactory getSessionFactory(Class<T>clazz) {
        if (sessionFactory == null) {
            try {Configuration configuration= new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(clazz);
                sessionFactory=configuration.buildSessionFactory();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
//    // Создание сессии
//    Session session = sessionFactory.getCurrentSession();
//
//    // Начало транзакции
//            session.beginTransaction();
//
//    // Создание объекта
//    Course course = new Course("Java Junior", 20);
//            session.save(course);
//            System.out.println("Object student save successfully");
//            session.getTransaction().commit();
//}
//
//        catch (Exception e){
//        e.printStackTrace();
//        }