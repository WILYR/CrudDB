package com.wilyr.crud.service;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.mySqlRepository.SkillRepository;

public class SkillService {
    SkillRepository skillRepository = new SkillRepository();

    public void skillSave(Skill skill) {
        skillRepository.save(skill);
    }

    public void skillDelete(Skill skill) {
        skillRepository.delete(skill);
    }

    public void skillUpdate(Skill skill) {
        skillRepository.update(skill);
    }

    public Skill skillGet(Skill skill) {
        return skillRepository.get(skill);
    }
}
