package com.wilyr.crud.service.junit;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.mySqlRepository.AccountRepository;
import com.wilyr.crud.repository.mySqlRepository.DeveloperRepository;
import com.wilyr.crud.repository.mySqlRepository.SkillRepository;
import liquibase.pro.packaged.A;
import liquibase.pro.packaged.D;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeveloperServiceTest {

    SkillRepository skillRepository = new SkillRepository();
    DeveloperRepository developerRepository = new DeveloperRepository();
    AccountRepository accountRepository = new AccountRepository();
    List<Skill> list = new ArrayList<>();
    Developer developer;


    public Developer developerSet() {
        skillRepository.save(new Skill("GGG"));
        skillRepository.save(new Skill("III"));
        accountRepository.save(new Account("LoGG", "pass", AccountStatus.BANNED, 0));
        list.add(skillRepository.get(new Skill("GGG")));
        list.add(skillRepository.get(new Skill("III")));
        developer = new Developer(list, accountRepository.get(new Account("LoGG", "")));
        return developer;
    }

    public void clearResources() {
        skillRepository.delete(new Skill("GGG"));
        skillRepository.delete(new Skill("III"));
        accountRepository.delete(new Account("LoGG", "pass", AccountStatus.BANNED, 0));
        list.remove(skillRepository.get(new Skill("GGG")));
        list.remove(skillRepository.get(new Skill("III")));
    }
    @Test
    public void developerSave() {
        developer = developerSet();
        developerRepository.save(developer);
        Assert.assertEquals(developer.getAccount().getId(), developerRepository.get(developer).getAccount().getId());
        Assert.assertEquals(developer.getSkills().size(), developerRepository.get(developer).getSkills().size());
        developerRepository.delete(developer);
        clearResources();
    }

    @Test
    public void developerDelete() {
        developer = developerSet();
        developerRepository.save(developer);
        developerRepository.delete(developer);
        Assert.assertEquals(0, developerRepository.get(developer).getAccount().getId());
        Assert.assertEquals(0, developerRepository.get(developer).getSkills().size());
        clearResources();
    }

    @Test
    public void developerUpdate() {
        developer = developerSet();
        developerRepository.save(developer);
        List<Skill> list2 = new ArrayList<>();
        list2.add(new Skill(10, ""));
        developerRepository.update(developer, list2);
        Assert.assertEquals(developer.getAccount().getId(), developerRepository.get(developer).getAccount().getId());
        Assert.assertEquals(developer.getSkills().size(), developerRepository.get(developer).getSkills().size());
        developerRepository.delete(developer);
        clearResources();
    }

    @Test
    public void developerGet() {
        developer = developerSet();
        developerRepository.save(developer);
        Assert.assertEquals(developer.getAccount().getId(), developerRepository.get(developer).getAccount().getId() );
        Assert.assertEquals(developer.getSkills().size(), developerRepository.get(developer).getSkills().size());
        developerRepository.delete(developer);
        clearResources();
    }
}
