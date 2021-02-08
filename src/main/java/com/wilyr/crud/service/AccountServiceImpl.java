package com.wilyr.crud.service;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.repository.hibernateRepository.HibernateAccountRepository;

public class AccountServiceImpl implements IAccountService {
    HibernateAccountRepository accountRepository = new HibernateAccountRepository();

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Long id) {
        accountRepository.delete(id);
    }

    public Account update(Account account) {
        accountRepository.update(account);
        return accountRepository.get(account.getId());
    }

    public Account get(Long id) {
        return accountRepository.get(id);
    }

}
