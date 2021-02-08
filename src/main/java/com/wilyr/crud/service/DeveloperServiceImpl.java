package com.wilyr.crud.service;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.hibernateRepository.HibernateDeveloperRepository;

import java.util.List;

public class DeveloperServiceImpl implements IDeveloperService {
    HibernateDeveloperRepository developerRepository = new HibernateDeveloperRepository();

    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    public void delete(Long id) {
        developerRepository.delete(id);
    }

    public Developer update(Developer developer, List<Skill> skillList) {
        return developerRepository.update(developer, skillList);
    }

    public Developer get(Long id) {
        return developerRepository.get(id);
    }

}
