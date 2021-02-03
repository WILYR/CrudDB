package com.wilyr.crud.repository.hibernateRepository;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.IDeveloperRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PostgreSqlDeveloperRepository implements IDeveloperRepository {

    SessionFactory sessionFactory = SingletonHibernateRepository.getInstance().sessionFactory;

    @Override
    public Developer save(Developer developer) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void delete(Developer developer) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Developer.class, developer.getDeveloperId()));
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
            e.printStackTrace();
        }
    }

    @Override
    public Developer get(Developer developer) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Developer.class, developer.getDeveloperId());
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Developer update(Developer developer, List<Skill> newSkills) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Developer returningDeveloper = session.get(Developer.class, developer.getDeveloperId());
            returningDeveloper.setSkills(newSkills);
            session.update(returningDeveloper);
            transaction.commit();
            return returningDeveloper;
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
            e.printStackTrace();
            return null;
        }
    }
}
