package com.wilyr.crud.service.postgreSqlService;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.postgreSqlRepository.PostgreSqlDeveloperRepository;

import java.util.List;

public class PostgreSqlDeveloperService {
    PostgreSqlDeveloperRepository postgreSqlDeveloperRepository =  new PostgreSqlDeveloperRepository();

    public Developer save(Developer developer) {
        return postgreSqlDeveloperRepository.save(developer);
    }

    public void delete(Developer developer) {
        postgreSqlDeveloperRepository.delete(developer);
    }

    public Developer update (Developer developer, List<Skill> skillList) {
        return postgreSqlDeveloperRepository.update(developer, skillList);
    }

    public Developer get(Developer developer) {
        return postgreSqlDeveloperRepository.get(developer);
    }

}
