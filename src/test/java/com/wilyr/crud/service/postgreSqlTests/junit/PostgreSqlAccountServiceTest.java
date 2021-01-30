package com.wilyr.crud.service.postgreSqlTests.junit;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlAccountService;
import liquibase.pro.packaged.A;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PostgreSqlAccountServiceTest {
    PostgreSqlAccountService postgreSqlAccountService = new PostgreSqlAccountService();

    Account account = new Account("login","pass", AccountStatus.ACTIVE, 0);
    Account account2 = new Account("login2","pass2", AccountStatus.BANNED, 0);

    @Test
    public void save(){
        postgreSqlAccountService.save(account);
        Account getAcc = postgreSqlAccountService.get(account);
        Assert.assertEquals(account.getLogin(),getAcc.getLogin());
        Assert.assertEquals(account.getPassword(),getAcc.getPassword());
        Assert.assertEquals(account.getAccountStatus(),getAcc.getAccountStatus());
        postgreSqlAccountService.delete(account);
    }

    @Test
    public void delete() {
        postgreSqlAccountService.save(account);
        postgreSqlAccountService.delete(account);
        Assert.assertEquals(postgreSqlAccountService.get(account),null);
    }

    @Test
    public void get() {
        postgreSqlAccountService.save(account2);
        Assert.assertEquals(account2.getId(), postgreSqlAccountService.get(account2).getId());
        Assert.assertEquals(account2.getPassword(), postgreSqlAccountService.get(account2).getPassword());
        Assert.assertEquals(account2.getLogin(), postgreSqlAccountService.get(account2).getLogin());
        Assert.assertEquals(account2.getAccountStatus(), postgreSqlAccountService.get(account2).getAccountStatus());
        postgreSqlAccountService.delete(account2);
    }

    @Test
    public void update() {
        postgreSqlAccountService.save(account2);
        account2.setLogin("sdqwf");
        account2.setPassword("gweggw");
        account2.setAccountStatus(AccountStatus.BANNED);
        postgreSqlAccountService.update(account2);
        Assert.assertEquals(account2.getLogin(), postgreSqlAccountService.get(account2).getLogin());
        Assert.assertEquals(account2.getPassword(), postgreSqlAccountService.get(account2).getPassword());
        Assert.assertEquals(account2.getAccountStatus(), postgreSqlAccountService.get(account2).getAccountStatus());
        postgreSqlAccountService.delete(account2);
    }
}
