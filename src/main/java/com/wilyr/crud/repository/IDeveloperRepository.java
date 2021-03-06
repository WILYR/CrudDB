package com.wilyr.crud.repository;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;

import java.util.List;

public interface IDeveloperRepository extends GenericRepository {

    Developer save(Developer developer);

    void delete(Long id);

    Developer get(Long id);

    Developer update(Developer developer, List<Skill> newSkills);

}
