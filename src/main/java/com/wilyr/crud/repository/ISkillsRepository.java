package com.wilyr.crud.repository;

import com.wilyr.crud.model.Skill;

public interface ISkillsRepository extends GenericRepository {
    Skill save(Skill skill);

    Skill update(Skill skill);

    void delete(Long id);

    Skill get(Long id);
}
