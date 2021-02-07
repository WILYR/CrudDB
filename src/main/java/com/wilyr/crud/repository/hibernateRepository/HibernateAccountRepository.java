package com.wilyr.crud.repository.hibernateRepository;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.repository.IAccountRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateAccountRepository implements IAccountRepository {

    @Override
    public Account save(Account account) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            Account returningAccount = session.get(Account.class, account.getId());
            if (returningAccount != null) {
                System.out.println("Account with this id already exist");
            } else {
                session.save(account);
                transaction.commit();
            }
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
        }
        return account;
    }

    @Override
    public void delete(Long id) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Account account = new Account("","", null, id);
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Account.class, account.getId()));
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
        }
    }

    @Override
    public Account get(Long id) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Account account = new Account("","", null, id);
            return session.get(Account.class, account.getId());
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
            return null;
        }
    }

    @Override
    public Account update(Account account) {
        try (Session session = SingletonHibernateRepository.getInstance().session) {
            Transaction transaction = null;
            transaction = session.beginTransaction();
            Account returningAccount = session.get(Account.class, account.getId());
            if (returningAccount == null) {
                System.out.println("Account isn't exist");
                return null;
            } else {
                returningAccount.setLogin(account.getLogin());
                returningAccount.setPassword(account.getPassword());
                returningAccount.setAccountStatus(account.getAccountStatus());
                session.update(returningAccount);
                transaction.commit();
                return returningAccount;
            }
        } catch (HibernateException e) {
            System.out.println("Error in session connection......");
            return null;
        }

    }
}
