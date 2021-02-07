package com.wilyr.crud.service.hibernate;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.hibernateRepository.HibernateSkillRepository;
import com.wilyr.crud.service.ISkillService;

public class SkillServiceImpl implements ISkillService {
    HibernateSkillRepository postgreSqlSkillRepository = new HibernateSkillRepository();
    public Skill save(Skill skill) {
        postgreSqlSkillRepository.save(skill);
        return skill;
    }

    public void delete(Long id) {
        postgreSqlSkillRepository.delete(id);
    }

    public  Skill get(Long id) {
        return postgreSqlSkillRepository.get(id);
    }

    public Skill update(Skill skill) {
        postgreSqlSkillRepository.update(skill);
        return postgreSqlSkillRepository.get(skill.getId());
    }
}
