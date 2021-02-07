package com.wilyr.crud.controller.hibernate;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.hibernate.AccountServiceImpl;

public class AccountController {
    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

    public Account save(String login, String password,String accountStatus) {
        Account account = new Account(login,password);
        try {
            account.setAccountStatus(AccountStatus.valueOf(accountStatus));
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong account status");
            return null;
        }
        return accountServiceImpl.save(account);
    }

    public void delete(Long idForDelete) {
        accountServiceImpl.delete(idForDelete);
    }

    public Account updatePassword(Long idForUpdate,String newLogin,String newPassword,String newStatus) {
        try {
            return accountServiceImpl.update(new Account(newLogin,newPassword,AccountStatus.valueOf(newStatus),idForUpdate));
        }catch (IllegalArgumentException e) {
            System.out.println("Wrong account status");
            return null;
        }
    }

    public Account get(Long id) {
        return accountServiceImpl.get(id);
    }


}
