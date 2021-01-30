package com.wilyr.crud.view.postgreSqlView;

import com.wilyr.crud.controller.mysql.MySqlAccountController;
import com.wilyr.crud.controller.postgresql.PostgreSqlAccountController;
import com.wilyr.crud.model.Account;

import java.util.Scanner;

public class postgreSqlAccountView {
    public void accountMenu() {
        PostgreSqlAccountController accountController = new PostgreSqlAccountController();
        Scanner in = new Scanner(System.in);
        int accountMenuNumber;
        do {
            System.out.println("1.Add account");
            System.out.println("2.Delete account");
            System.out.println("3.Update password");
            System.out.println("4.Get account");
            System.out.println("0.Back");
            System.out.print("Your choice: ");
            accountMenuNumber = in.nextInt();
            switch (accountMenuNumber) {
                case 1:
                    System.out.print("Add account login: ");
                    String login = in.next();
                    System.out.print("Add account password: ");
                    String password = in.next();
                    System.out.print("Add account status: ");
                    String accountStatus = in.next();
                    accountController.save(login, password, accountStatus);
                    break;
                case 2:
                    System.out.print("Delete account(BY ID): ");
                    Long idForDelete = in.nextLong();
                    accountController.delete(idForDelete);
                    break;
                case 3:
                    System.out.print("Update account password(BY ID): ");
                    Long idForUpdate = in.nextLong();
                    System.out.print("New Login: ");
                    String newLogin = in.next();
                    System.out.print("New Password: ");
                    String newPassword = in.next();
                    System.out.print("New Status: ");
                    String newStatus = in.next();
                    accountController.updatePassword(idForUpdate, newLogin, newPassword, newStatus);
                    break;
                case 4:
                    System.out.print("Get account(BY ID): ");
                    Account account = accountController.get(in.nextLong());
                    if (account != null) {
                        System.out.println(account.getId() + " - " + account.getLogin() + " - " + account.getPassword()
                                + " - " + account.getAccountStatus().toString());
                    }
                    break;
            }
        } while (accountMenuNumber != 0);
    }
}