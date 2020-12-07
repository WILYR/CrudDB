package com.wilyr.crud.service;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.mySqlRepository.SkillRepository;

public class SkillService {
    SkillRepository skillRepository = new SkillRepository();

    public Skill skillSave(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill skillDelete(Skill skill) {
        skillRepository.delete(skill);
        return null;
    }

    public Skill skillUpdate(Skill skill) {
        return skillRepository.update(skill);
    }

    public Skill skillGet(Skill skill) {
        return skillRepository.get(skill);
    }
}
