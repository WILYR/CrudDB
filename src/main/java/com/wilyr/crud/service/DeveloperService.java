package com.wilyr.crud.service;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.mySqlRepository.DeveloperRepository;

import java.util.List;

public class DeveloperService {

    DeveloperRepository developerRepository = new DeveloperRepository();

    public Developer developerSave(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer developerDelete(Developer developer) {
        developerRepository.delete(developer);
        return null;
    }

    public Developer developerUpdate(Developer developer, List<Skill> list) {
        return developerRepository.update(developer, list);
    }

    public Developer developerGet(Developer developer) {
        return developerRepository.get(developer);
    }
}
