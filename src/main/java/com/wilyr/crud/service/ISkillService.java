package com.wilyr.crud.service;

import com.wilyr.crud.model.Skill;

public interface ISkillService {
    Skill save(Skill skill);

    Skill update(Skill skill);

    void delete(Long id);

    Skill get(Long id);
}
