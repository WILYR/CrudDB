package com.wilyr.crud.service.hibernateTests.mockito;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.AccountServiceImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class AccountTest {
    @Mock
    AccountServiceImpl accountService = org.mockito.Mockito.mock(AccountServiceImpl.class, Mockito.RETURNS_DEEP_STUBS);
    Account account = new Account("G", "Pass", AccountStatus.BANNED, 0);

    @Test
    public void accountSave() {
        given(accountService.save(account).getLogin()).willReturn(account.getLogin());
        given(accountService.save(account).getPassword()).willReturn(account.getPassword());
        when(accountService.save(account).getAccountStatus()).thenReturn(account.getAccountStatus());
    }

    @Test
    public void accountGet() {
        given(accountService.get(account.getId())).willReturn(account);
    }

    @Test
    public void accountDelete() {
       accountService.delete(account.getId());
        given(accountService.get(account.getId())).willThrow(NullPointerException.class);
    }

    @Test
    public void accountUpdate() {
        account.setPassword("KKKK");
        given(accountService.update(account)).willReturn(account);
    }
}
