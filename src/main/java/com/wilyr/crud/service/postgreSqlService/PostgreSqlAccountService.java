package com.wilyr.crud.service.postgreSqlService;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.repository.postgreSqlRepository.PostgreSqlAccountRepository;

public class PostgreSqlAccountService {
    PostgreSqlAccountRepository postgreSqlAccountRepository = new PostgreSqlAccountRepository();

    public Account save(Account account) {
        return postgreSqlAccountRepository.save(account);
    }

    public void delete(Account account) {
        postgreSqlAccountRepository.delete(account);
    }

    public Account update(Account account) {
        postgreSqlAccountRepository.update(account);
        return postgreSqlAccountRepository.get(account);
    }

    public Account get(Account account) {
        return postgreSqlAccountRepository.get(account);
    }

}
