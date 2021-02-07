package com.wilyr.crud.service.hibernateTests.junit;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.hibernate.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class AccountServiceImplTest {
    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

    Account account = new Account("login","pass", AccountStatus.ACTIVE, 0);
    Account account2 = new Account("login2","pass2", AccountStatus.BANNED, 0);

    @Test
    public void save(){
        accountServiceImpl.save(account);
        Account getAcc = accountServiceImpl.get(account.getId());
        Assert.assertEquals(account.getLogin(),getAcc.getLogin());
        Assert.assertEquals(account.getPassword(),getAcc.getPassword());
        Assert.assertEquals(account.getAccountStatus(),getAcc.getAccountStatus());
        accountServiceImpl.delete(account.getId());
    }

    @Test
    public void delete() {
        accountServiceImpl.save(account);
        accountServiceImpl.delete(account.getId());
        Assert.assertEquals(accountServiceImpl.get(account.getId()),null);
    }

    @Test
    public void get() {
        accountServiceImpl.save(account2);
        Assert.assertEquals(account2.getId(), accountServiceImpl.get(account2.getId()).getId());
        Assert.assertEquals(account2.getPassword(), accountServiceImpl.get(account2.getId()).getPassword());
        Assert.assertEquals(account2.getLogin(), accountServiceImpl.get(account2.getId()).getLogin());
        Assert.assertEquals(account2.getAccountStatus(), accountServiceImpl.get(account2.getId()).getAccountStatus());
        accountServiceImpl.delete(account2.getId());
    }

    @Test
    public void update() {
        accountServiceImpl.save(account2);
        account2.setLogin("sdqwf");
        account2.setPassword("gweggw");
        account2.setAccountStatus(AccountStatus.BANNED);
        accountServiceImpl.update(account2);
        Assert.assertEquals(account2.getLogin(), accountServiceImpl.get(account2.getId()).getLogin());
        Assert.assertEquals(account2.getPassword(), accountServiceImpl.get(account2.getId()).getPassword());
        Assert.assertEquals(account2.getAccountStatus(), accountServiceImpl.get(account2.getId()).getAccountStatus());
        accountServiceImpl.delete(account2.getId());
    }
}
