package ru.scherblackoff.springProject.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerFactoryUtil {
    private static SessionFactory sessionFactory;

    private EntityManagerFactoryUtil() {}

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Из фабрики создаем EntityManager
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
}