package com.wilyr.crud.repository.hibernateRepository;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SingletonHibernateRepository {

    private static SingletonHibernateRepository instance;
    public Session session;

    private SingletonHibernateRepository(Session session) {
        this.session= session;
    }


    public static SingletonHibernateRepository getInstance()  {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Error in load hibernate properties........");
        }
        configuration.setProperties(properties).addAnnotatedClass(Account.class).addAnnotatedClass(Skill.class).addAnnotatedClass(Developer.class);
        instance = new SingletonHibernateRepository(configuration.configure().buildSessionFactory().openSession());
        return instance;
    }

}
