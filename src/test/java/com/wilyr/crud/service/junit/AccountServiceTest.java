package com.wilyr.crud.service.junit;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.repository.mySqlRepository.AccountRepository;
import liquibase.Liquibase;
import liquibase.pro.packaged.A;
import org.junit.Assert;
import org.junit.Test;

public class AccountServiceTest {

    AccountRepository accountRepository = new AccountRepository();
    Account account = new Account("Log", "pass", AccountStatus.BANNED, 0);
    Account account2 = new Account("JJJ", "pass", AccountStatus.ACTIVE, 0);

    @Test
    public void accountSave() {
        accountRepository.save(account);
        Assert.assertEquals(account.getLogin() , accountRepository.get(account).getLogin());
        Assert.assertEquals(account.getPassword() , accountRepository.get(account).getPassword());
        Assert.assertEquals(account.getAccountStatus() , accountRepository.get(account).getAccountStatus());
        accountRepository.delete(account);
    }
    @Test
    public void accountDelete() {
        accountRepository.save(account);
        accountRepository.delete(account);
        Assert.assertEquals(null, accountRepository.get(account));
    }
    @Test
    public void accountUpdate() {
        accountRepository.save(account2);
        account2.setPassword("pass2");
        accountRepository.update(account2);
        Assert.assertEquals(account2.getPassword() , accountRepository.get(account2).getPassword());
        accountRepository.delete(account2);
    }
    @Test
    public void accountGet() {
        accountRepository.save(account);
        Assert.assertEquals(account.getLogin() , accountRepository.get(account).getLogin());
        Assert.assertEquals(account.getPassword() , accountRepository.get(account).getPassword());
        Assert.assertEquals(account.getAccountStatus() , accountRepository.get(account).getAccountStatus());
    }
}