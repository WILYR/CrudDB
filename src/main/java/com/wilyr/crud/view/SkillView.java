package com.wilyr.crud.view;

import com.wilyr.crud.controller.mysql.MySqlSkillController;
import com.wilyr.crud.model.Skill;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SkillView {
    public void skillMenu() {
        MySqlSkillController skillController = new MySqlSkillController();
        Scanner in = new Scanner(System.in);
        int skillMenuNumber;
        do {
            System.out.println("1.Add skill");
            System.out.println("2.Delete skill");
            System.out.println("3.Update skill");
            System.out.println("4.Get skill");
            System.out.println("0.Back");
            System.out.print("Your choice: ");
            skillMenuNumber = in.nextInt();
            switch (skillMenuNumber) {
                case 1:
                    System.out.print("Add skill: ");
                    skillController.save(new Skill(in.next()));
                    break;
                case 2:
                    System.out.print("Delete skill(BY NAME): ");
                    skillController.delete(new Skill(in.next()));
                    break;
                case 3:
                    System.out.print("Update skill(BY ID): ");
                    long id = 0;
                    try {
                        id = in.nextLong();
                    }catch (InputMismatchException e) {
                        System.out.println("It's not a number");
                    }
                    System.out.print("New skill name: ");
                    String str = in.next();
                    skillController.update(id, str);
                    break;
                case 4:
                    System.out.print("Get skill(BY NAME): ");
                    Skill skill = skillController.get(in.next());
                    if (skill != null) {
                        System.out.println(skill.getId() + " - " + skill.getName());
                    }
                    break;
            }
        } while (skillMenuNumber != 0);
    }
}