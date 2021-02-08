package com.wilyr.crud.controller;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.SkillServiceImpl;

public class SkillController {
    SkillServiceImpl skillServiceImpl = new SkillServiceImpl();

    public void save(Skill skill) {
        skillServiceImpl.save(skill);
    }

    public void delete(Long id) {
        skillServiceImpl.delete(id);
    }

    public void update(Long id, String str) {
        skillServiceImpl.update(new Skill(id, str));
    }

    public Skill get(Long id) {
        return skillServiceImpl.get(id);
    }
}
