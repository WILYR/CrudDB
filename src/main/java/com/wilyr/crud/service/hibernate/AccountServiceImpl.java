package com.wilyr.crud.service.hibernate;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.repository.hibernateRepository.HibernateAccountRepository;
import com.wilyr.crud.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    HibernateAccountRepository postgreSqlAccountRepository = new HibernateAccountRepository();

    public Account save(Account account) {
        return postgreSqlAccountRepository.save(account);
    }

    public void delete(Long id) {
        postgreSqlAccountRepository.delete(id);
    }

    public Account update(Account account) {
        postgreSqlAccountRepository.update(account);
        return postgreSqlAccountRepository.get(account.getId());
    }

    public Account get(Long id) {
        return postgreSqlAccountRepository.get(id);
    }

}
