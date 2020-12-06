package com.wilyr.crud.repository;

import com.wilyr.crud.model.Account;

public interface IAccountRepository extends GenericRepository {
    Account save(Account account);

    void delete(Account account);

    Account get(Account account);

    Account update(Account account);
}
