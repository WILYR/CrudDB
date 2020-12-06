package com.wilyr.crud.service;

import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.mySqlRepository.DeveloperRepository;

import java.util.List;

public class DeveloperService {

    DeveloperRepository developerRepository = new DeveloperRepository();

    public void developerSave(Developer developer) {
        developerRepository.save(developer);
    }

    public void developerDelete(Developer developer) {
        developerRepository.delete(developer);
    }

    public void developerUpdate(Developer developer, List<Skill> list) {
        developerRepository.update(developer, list);
    }

    public Developer developerGet(Developer developer) {
        return developerRepository.get(developer);
    }
}
