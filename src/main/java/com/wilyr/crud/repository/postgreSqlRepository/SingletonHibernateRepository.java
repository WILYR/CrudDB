package com.wilyr.crud.repository.postgreSqlRepository;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import liquibase.pro.packaged.C;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SingletonHibernateRepository {

    private static SingletonHibernateRepository instance;
    public SessionFactory sessionFactory;

    private SingletonHibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
        instance = new SingletonHibernateRepository(configuration.configure().buildSessionFactory());
        return instance;
    }

}
