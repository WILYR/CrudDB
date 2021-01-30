package com.wilyr.crud.controller.postgresql;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlDeveloperService;

import java.util.ArrayList;
import java.util.List;

public class PostgreSqlDeveloperController {

    PostgreSqlDeveloperService postgreSqlDeveloperService = new PostgreSqlDeveloperService();
    PostgreSqlSkillController postgreSqlSkillController = new PostgreSqlSkillController();
    PostgreSqlAccountController postgreSqlAccountController = new PostgreSqlAccountController();

    public Developer save(Long id, String listSkills) {
        List<Skill> skillsForSave = new ArrayList<>();
        String[] splitListSkills = listSkills.split(",");
        for (String i : splitListSkills) {
            if (postgreSqlSkillController.get(Long.parseLong(i)) != null) ;
            skillsForSave.add(postgreSqlSkillController.get(Long.parseLong(i)));
        }
        return postgreSqlDeveloperService.save(new Developer(skillsForSave, postgreSqlAccountController.get(id)));
    }

    public void delete(Long id) {
        Developer developer = new Developer();
        developer.setDeveloperId(id);
        postgreSqlDeveloperService.delete(postgreSqlDeveloperService.get(developer));
    }

    public Developer get(Long idForGet) {
        Developer developer = new Developer();
        developer.setDeveloperId(idForGet);
        return postgreSqlDeveloperService.get(developer);
    }

    public Developer update(Long idForUpdate, String newSkills) {
        Developer developer = new Developer();
        developer.setDeveloperId(idForUpdate);
        developer = postgreSqlDeveloperService.get(developer);
        List<Skill> skillsForSave = new ArrayList<>();
        String[] splitListSkills = newSkills.split(",");
        for (String i : splitListSkills) {
            if (postgreSqlSkillController.get(Long.parseLong(i)) != null) ;
            skillsForSave.add(postgreSqlSkillController.get(Long.parseLong(i)));
        }
        return postgreSqlDeveloperService.update(developer, skillsForSave);
    }
}
