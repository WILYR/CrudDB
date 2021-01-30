package com.wilyr.crud.service.postgreSqlService;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.postgreSqlRepository.PostgreSqlSkillRepository;
import liquibase.pro.packaged.S;

public class PostgreSqlSkillService {
    PostgreSqlSkillRepository postgreSqlSkillRepository = new PostgreSqlSkillRepository();
    public Skill save(Skill skill) {
        postgreSqlSkillRepository.save(skill);
        return skill;
    }

    public void delete(Skill skill) {
        postgreSqlSkillRepository.delete(skill);
    }

    public  Skill get(Skill skill) {
        return postgreSqlSkillRepository.get(skill);
    }

    public Skill update(Skill skill) {
        postgreSqlSkillRepository.update(skill);
        return postgreSqlSkillRepository.get(skill);
    }
}
