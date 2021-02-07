package com.wilyr.crud.service;

import com.wilyr.crud.model.Account;

public interface IAccountService {
    Account save(Account account);

    void delete(Long id);

    Account get(Long id);

    Account update(Account account);
}
