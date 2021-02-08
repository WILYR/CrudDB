package com.wilyr.crud.controller;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.DeveloperServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DeveloperController {

    DeveloperServiceImpl developerServiceImpl = new DeveloperServiceImpl();
    SkillController skillController = new SkillController();
    AccountController accountController = new AccountController();

    public Developer save(Long id, String listSkills) {
        List<Skill> skillsForSave = new ArrayList<>();
        String[] splitListSkills = listSkills.split(",");
        for (String i : splitListSkills) {
            if (skillController.get(Long.parseLong(i)) != null) ;
            skillsForSave.add(skillController.get(Long.parseLong(i)));
        }
        return developerServiceImpl.save(new Developer(skillsForSave, accountController.get(id)));
    }

    public void delete(Long id) {
        developerServiceImpl.delete(id);
    }

    public Developer get(Long idForGet) {
        return developerServiceImpl.get(idForGet);
    }

    public Developer update(Long idForUpdate, String newSkills) {
        Developer developer = developerServiceImpl.get(idForUpdate);
        List<Skill> skillsForSave = new ArrayList<>();
        String[] splitListSkills = newSkills.split(",");
        for (String i : splitListSkills) {
            if (skillController.get(Long.parseLong(i)) != null) ;
            skillsForSave.add(skillController.get(Long.parseLong(i)));
        }
        return developerServiceImpl.update(developer, skillsForSave);
    }
}
