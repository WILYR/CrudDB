package com.wilyr.crud.controller.postgresql;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.SkillService;

public class PostgreSqlSkillController {
    SkillService skillService = new SkillService();

    public void save(Skill skill) {
        skillService.skillSave(skill);
    }

    public void delete(Skill skill) {
        skillService.skillDelete(skill);
    }

    public void update(Long id, String str) {
        skillService.skillUpdate(new Skill(id, str));
    }

    public Skill get(String name) {
        Skill skill = skillService.skillGet(new Skill(name));
        if (skill != null) {
            return skill;
        } else {
            System.out.println("WRONG SKILL! TRY AGAIN");
            return null;
        }
    }
}
