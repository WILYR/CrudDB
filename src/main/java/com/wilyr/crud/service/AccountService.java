package com.wilyr.crud.service;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.repository.mySqlRepository.AccountRepository;

public class AccountService {

    AccountRepository accountRepository = new AccountRepository();

    public void accountSave(Account account) {
        accountRepository.save(account);
    }

    public void accountDelete(Account account) {
        accountRepository.delete(account);
    }

    public void accountUpdate(Account account) {
        accountRepository.update(account);
    }

    public Account accountGet(Account account) {
        return accountRepository.get(account);
    }

}
