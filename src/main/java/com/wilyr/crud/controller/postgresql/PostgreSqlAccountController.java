package com.wilyr.crud.controller.postgresql;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlAccountService;
import liquibase.pro.packaged.A;

public class PostgreSqlAccountController {
    PostgreSqlAccountService postgreSqlAccountService = new PostgreSqlAccountService();

    public Account save(String login, String password,String accountStatus) {
        Account account = new Account(login,password);
        if (accountStatus.equals("ACTIVE")) {
            account.setAccountStatus(AccountStatus.ACTIVE);
        } else if(accountStatus.equals("BANNED")) {
            account.setAccountStatus(AccountStatus.BANNED);
        } else if(account.equals("DELETED")) {
            account.setAccountStatus(AccountStatus.DELETED);
        } else {
            System.out.println("Wrong acc status....");
            return null;
        }
        return postgreSqlAccountService.save(account);
    }

    public void delete(Long idForDelete) {
        postgreSqlAccountService.delete(new Account("","",null,idForDelete));
    }

    public Account updatePassword(Long idForUpdate,String newLogin,String newPassword,String newStatus) {
        if(newStatus.equals("ACTIVE")) {
            return postgreSqlAccountService.update(new Account(newLogin,newPassword,AccountStatus.ACTIVE,idForUpdate));
        } else if(newStatus.equals("BANNED")) {
            return postgreSqlAccountService.update(new Account(newLogin,newPassword,AccountStatus.BANNED,idForUpdate));
        } else if(newStatus.equals("DELETED")) {
            return postgreSqlAccountService.update(new Account(newLogin,newPassword,AccountStatus.DELETED,idForUpdate));
        } else {
            return null;
        }
    }

    public Account get(Long id) {
        return postgreSqlAccountService.get(new Account("","", null, id));
    }


}
