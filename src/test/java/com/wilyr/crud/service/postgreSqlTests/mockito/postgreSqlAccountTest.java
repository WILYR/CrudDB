package com.wilyr.crud.service.postgreSqlTests.mockito;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.mySqlService.AccountService;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlAccountService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class postgreSqlAccountTest {
    @Mock
    PostgreSqlAccountService accountService = org.mockito.Mockito.mock(PostgreSqlAccountService.class, Mockito.RETURNS_DEEP_STUBS);
    Account account = new Account("G", "Pass", AccountStatus.BANNED, 0);

    @Test
    public void accountSave() {
        given(accountService.save(account).getLogin()).willReturn(account.getLogin());
        given(accountService.save(account).getPassword()).willReturn(account.getPassword());
        when(accountService.save(account).getAccountStatus()).thenReturn(account.getAccountStatus());
    }

    @Test
    public void accountGet() {
        given(accountService.get(account)).willReturn(account);
    }

    @Test
    public void accountDelete() {
       accountService.delete(account);
        given(accountService.get(account)).willThrow(NullPointerException.class);
    }

    @Test
    public void accountUpdate() {
        account.setPassword("KKKK");
        given(accountService.update(account)).willReturn(account);
    }
}
