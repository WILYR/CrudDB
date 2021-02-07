package com.wilyr.crud.service;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;

import java.util.List;

public interface IDeveloperService {
    Developer save(Developer developer);

    void delete(Long id);

    Developer get(Long id);

    Developer update(Developer developer, List<Skill> newSkills);
}
