package com.wilyr.crud.controller.postgresql;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlSkillService;

public class PostgreSqlSkillController {
    PostgreSqlSkillService postgreSqlSkillService = new PostgreSqlSkillService();

    public void save(Skill skill) {
        postgreSqlSkillService.save(skill);
    }

    public void delete(Skill skill) {
        postgreSqlSkillService.delete(skill);
    }

    public void update(Long id, String str) {
        postgreSqlSkillService.update(new Skill(id, str));
    }

    public Skill get(Long id) {
        Skill skill = postgreSqlSkillService.get(new Skill(id, ""));
        if (skill != null) {
            return skill;
        } else {
            System.out.println("WRONG SKILL! TRY AGAIN");
            return null;
        }
    }
}
