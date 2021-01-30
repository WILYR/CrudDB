package com.wilyr.crud.service.mySqlService;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.repository.mySqlRepository.AccountRepository;

public class AccountService {

    AccountRepository accountRepository = new AccountRepository();

    public Account accountSave(Account account) {
        return accountRepository.save(account);
    }

    public Account accountDelete(Account account) {
        accountRepository.delete(account);
        return null;
    }

    public Account accountUpdate(Account account) {
        return accountRepository.update(account);
    }

    public Account accountGet(Account account) {
        return accountRepository.get(account);
    }

}
