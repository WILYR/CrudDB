package com.wilyr.crud.service.hibernate;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.hibernateRepository.HibernateDeveloperRepository;
import com.wilyr.crud.service.IDeveloperService;

import java.util.List;

public class DeveloperServiceImpl implements IDeveloperService {
    HibernateDeveloperRepository postgreSqlDeveloperRepository =  new HibernateDeveloperRepository();

    public Developer save(Developer developer) {
        return postgreSqlDeveloperRepository.save(developer);
    }

    public void delete(Long id) {
        postgreSqlDeveloperRepository.delete(id);
    }

    public Developer update (Developer developer, List<Skill> skillList) {
        return postgreSqlDeveloperRepository.update(developer, skillList);
    }

    public Developer get(Long id) {
        return postgreSqlDeveloperRepository.get(id);
    }

}
