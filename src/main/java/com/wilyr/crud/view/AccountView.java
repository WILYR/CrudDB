package com.wilyr.crud.view;

import com.wilyr.crud.controller.mysql.MySqlAccountController;
import com.wilyr.crud.model.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountView {
    public void accountMenu() {
        MySqlAccountController accountController = new MySqlAccountController();
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
                    System.out.print("Delete account(BY LOGIN): ");
                    String loginForDelete = in.next();
                    accountController.delete(loginForDelete);
                    break;
                case 3:
                    System.out.print("Update account password(BY LOGIN): ");
                    String loginForUpdate = in.next();
                    System.out.print("New Password: ");
                    String newPassword = in.next();
                    accountController.updatePassword(loginForUpdate, newPassword);
                    break;
                case 4:
                    System.out.print("Get account(BY LOGIN): ");
                    Account account = accountController.get(in.next());
                    if (account != null) {
                        System.out.println(account.getId() + " - " + account.getLogin() + " - " + account.getPassword()
                                + " - " + account.getAccountStatus().toString());
                    }
                    break;
            }
        } while (accountMenuNumber != 0);
    }
}