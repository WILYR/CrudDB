package com.wilyr.crud.service.mockito;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.mySqlService.AccountService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

   @Mock
    AccountService accountService = org.mockito.Mockito.mock(AccountService.class, Mockito.RETURNS_DEEP_STUBS);
    Account account = new Account("G", "Pass", AccountStatus.BANNED, 0);

    @Test
    public void accountSave() {
        given(accountService.accountSave(account).getLogin()).willReturn(account.getLogin());
        given(accountService.accountSave(account).getPassword()).willReturn(account.getPassword());
        when(accountService.accountSave(account).getAccountStatus()).thenReturn(account.getAccountStatus());
    }

    @Test
    public void accountGet() {
        given(accountService.accountGet(account)).willReturn(account);
    }

    @Test
    public void accountDelete() {
        given(accountService.accountDelete(account)).willThrow(NullPointerException.class);
    }

    @Test
    public void accountUpdate() {
        account.setPassword("KKKK");
        given(accountService.accountUpdate(account)).willReturn(account);
    }

}
