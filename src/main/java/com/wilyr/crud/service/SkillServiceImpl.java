package com.wilyr.crud.service;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.hibernateRepository.HibernateSkillRepository;

public class SkillServiceImpl implements ISkillService {
    HibernateSkillRepository skillRepository = new HibernateSkillRepository();

    public Skill save(Skill skill) {
        skillRepository.save(skill);
        return skill;
    }

    public void delete(Long id) {
        skillRepository.delete(id);
    }

    public Skill get(Long id) {
        return skillRepository.get(id);
    }

    public Skill update(Skill skill) {
        skillRepository.update(skill);
        return skillRepository.get(skill.getId());
    }
}
