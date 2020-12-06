package com.wilyr.crud.controller.mysql;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.DeveloperService;

import java.util.ArrayList;
import java.util.List;

public class MySqlDeveloperController {

    DeveloperService developerService = new DeveloperService();
    MySqlSkillController mySqlSkillController = new MySqlSkillController();
    MySqlAccountController mySqlAccountController = new MySqlAccountController();

    public void save(String login, String listSkills) {
        List<Skill> skillsForSave = new ArrayList<>();
        String[] splitListSkills = listSkills.split(",");
        for (String i : splitListSkills) {
            if (mySqlSkillController.get(i) != null) ;
            skillsForSave.add(mySqlSkillController.get(i));
        }
        Developer developer = new Developer(skillsForSave, mySqlAccountController.get(login));
        developerService.developerSave(developer);
    }

    public void delete(Long id) {
        Developer developer = new Developer(null, new Account(null, null, null, id));
        developerService.developerDelete(developer);
    }

    public void update(Long id, String newSkills) {
        List<Skill> skillsForSave = new ArrayList<>();
        String[] splitListSkills = newSkills.split(",");
        for (String i : splitListSkills) {
            if (mySqlSkillController.get(i) != null) ;
            skillsForSave.add(mySqlSkillController.get(i));
        }
        developerService.developerUpdate(new Developer(null, new Account(null, null, null, id)), skillsForSave);
    }

    public Developer get(long id) {
        Developer developer = new Developer(null, new Account("", "", null, id));
        developer = developerService.developerGet(developer);
        if (developer != null) {
            return developer;
        } else {
            System.out.println("WRONG LOGIN ID! TRY AGAIN");
            return null;
        }
    }
}
