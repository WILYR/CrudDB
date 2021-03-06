package com.wilyr.crud.repository;

import com.wilyr.crud.model.Account;

public interface IAccountRepository extends GenericRepository {
    Account save(Account account);

    void delete(Long id);

    Account get(Long id);

    Account update(Account account);
}
