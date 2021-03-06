package com.wilyr.crud.view;

import com.wilyr.crud.controller.DeveloperController;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeveloperView {
    public void developerMenu() {
        DeveloperController developerController = new DeveloperController();
        Scanner in = new Scanner(System.in);
        int developerMenuNumber;
        do {
            System.out.println("1.Add developer");
            System.out.println("2.Delete developer");
            System.out.println("3.Update developer skills");
            System.out.println("4.Get developer");
            System.out.println("0.Back");
            System.out.print("Your choice: ");
            developerMenuNumber = in.nextInt();
            switch (developerMenuNumber) {
                case 1:
                    System.out.print("Set Acc id for Developer: ");
                    Long id = in.nextLong();
                    System.out.print("Set skills for developer(id's through ','): ");
                    String listSkills = in.next();
                    developerController.save(id, listSkills);
                    break;
                case 2:
                    try {
                        System.out.print("Set developer id for delete: ");
                        Long idForDelete = in.nextLong();
                        developerController.delete(idForDelete);
                    } catch (InputMismatchException e) {
                        e.getMessage();
                    }
                    break;
                case 3:
                    System.out.print("Set developer id for update: ");
                    Long idForUpdate = in.nextLong();
                    System.out.print("Set new developer skills(id's through ','): ");
                    String newSkills = in.next();
                    developerController.update(idForUpdate, newSkills);
                    break;
                case 4:
                    System.out.print("Set Developer id: ");
                    long idForGet = in.nextLong();
                    Developer developer = developerController.get(idForGet);
                    if (developer != null) {
                        System.out.print("Account id: " + developer.getAccount().getId() + " Skills: ");
                        for (Skill skill : developer.getSkills()) {
                            System.out.print(skill.getId() + ", ");
                        }
                        System.out.println("");
                    }
                    break;
            }
        } while (developerMenuNumber != 0);
    }
}