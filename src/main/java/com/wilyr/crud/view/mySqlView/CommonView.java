package com.wilyr.crud.view.mySqlView;

import com.wilyr.crud.view.mySqlView.AccountView;
import com.wilyr.crud.view.mySqlView.DeveloperView;
import com.wilyr.crud.view.mySqlView.SkillView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonView {
    DeveloperView developerView = new DeveloperView();
    SkillView skillView = new SkillView();
    AccountView accountView = new AccountView();

    public void showMainMenu() {
        Scanner in = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("1.Account menu");
            System.out.println("2.Skill menu");
            System.out.println("3.Developer menu");
            System.out.println("0.Exit");
            System.out.print("Your choice: ");
            try {
                menu = in.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("It's not a number");
            }
            switch (menu) {
                case 1:
                    accountView.accountMenu();
                    break;
                case 2:
                    skillView.skillMenu();
                    break;
                case 3:
                    developerView.developerMenu();
                    break;
            }
        } while (menu != 0);
    }
}