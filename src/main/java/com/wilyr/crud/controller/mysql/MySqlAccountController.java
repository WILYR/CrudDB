package com.wilyr.crud.controller.mysql;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.mySqlService.AccountService;

public class MySqlAccountController {

    AccountService accountService = new AccountService();

    public void save(String login, String password, String accountStatus) {
        Account account = new Account();
        account.setLogin(login);
        account.setPassword(password);
        if (accountStatus.equals("DELETED")) {
            account.setAccountStatus(AccountStatus.DELETED);
        } else if (accountStatus.equals("ACTIVE")) {
            account.setAccountStatus(AccountStatus.ACTIVE);
        } else if (accountStatus.equals("BANNED")) {
            account.setAccountStatus(AccountStatus.BANNED);
        } else {
            System.out.println("WRONG ACCOUNT STATUS! TRY AGAIN");
            return;
        }
        accountService.accountSave(account);
    }

    public void delete(String loginForDelete) {
        Account account = new Account();
        account.setLogin(loginForDelete);
        accountService.accountDelete(account);
    }

    public void updatePassword(String loginForUpdate, String newPassword) {
        Account account = new Account();
        account.setLogin(loginForUpdate);
        if (accountService.accountGet(account) != null) {
            account.setPassword(newPassword);
            accountService.accountUpdate(account);
        } else {
            System.out.println("WRONG ACCOUNT LOGIN TRY AGAIN");
        }
    }

    public Account get(String login) {
        Account account = new Account();
        account.setLogin(login);
        Account retAcc = accountService.accountGet(account);
        if (retAcc != null) {
            return retAcc;
        } else {
            System.out.println("Account isn't exist");
            return null;
        }
    }
}
