package com.wilyr.crud.repository.hibernateRepository;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.ISkillsRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateSkillRepository implements ISkillsRepository {


    @Override
    public Skill save(Skill skill) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Transaction transaction = session.beginTransaction();
            session.save(skill);
            transaction.commit();
            return skill;
        } catch (HibernateException e) {
            System.out.println("Error in session connection........");
            return null;
        }
    }

    @Override
    public Skill update(Skill skill) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Transaction transaction = session.beginTransaction();
            Skill returningSkill = session.get(Skill.class, skill.getId());
            if (returningSkill == null) {
                System.out.println("Skill isn't exist");
                return null;
            } else {
                returningSkill.setName(skill.getName());
                session.update(returningSkill);
                transaction.commit();
                return returningSkill;
            }
        } catch (HibernateException e) {
            System.out.println("Error in session connection........");
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Skill skill = new Skill(id, "");
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Skill.class, skill.getId()));
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Error in session connection........");
        }
    }

    @Override
    public Skill get(Long id) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Skill skill = new Skill(id, "");
            return session.get(Skill.class, skill.getId());
        } catch (HibernateException e) {
            System.out.println("Error in session connection........");
            return null;
        }
    }
}
