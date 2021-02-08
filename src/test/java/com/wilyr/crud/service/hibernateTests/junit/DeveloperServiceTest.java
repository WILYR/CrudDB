package com.wilyr.crud.service.hibernateTests.junit;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.AccountServiceImpl;
import com.wilyr.crud.service.DeveloperServiceImpl;
import com.wilyr.crud.service.SkillServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeveloperServiceTest {
    DeveloperServiceImpl developerServiceImpl = new DeveloperServiceImpl();
    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
    SkillServiceImpl skillServiceImpl = new SkillServiceImpl();
    public long a = 7,b = 10, c = 4;
    Skill skill = skillServiceImpl.get(a);
    Skill skill2 = skillServiceImpl.get(b);
    Skill skill3 = skillServiceImpl.get(c);

    Account account = accountServiceImpl.save(new Account("asfasf","agsdg", AccountStatus.BANNED,0));
    List<Skill> skillList = new ArrayList<>();
    Developer developer = new Developer();

    @Test
    public void save() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        developerServiceImpl.save(developer);
        Assert.assertEquals(developer.getDeveloperId(), developerServiceImpl.get(developer.getDeveloperId()).getDeveloperId());
        Assert.assertEquals(developer.getAccount().getId(), developerServiceImpl.get(developer.getDeveloperId()).getAccount().getId());
    }

    @Test
    public void delete() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        developerServiceImpl.save(developer);
        developerServiceImpl.delete(developer.getDeveloperId());
        Assert.assertEquals(developerServiceImpl.get(developer.getDeveloperId()), null);
    }

    @Test
    public void get() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        developerServiceImpl.save(developer);
        Assert.assertEquals(developer.getDeveloperId(), developerServiceImpl.get(developer.getDeveloperId()).getDeveloperId());
        Assert.assertEquals(developer.getAccount().getId(), developerServiceImpl.get(developer.getDeveloperId()).getAccount().getId());
    }

    @Test
    public void update() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        developerServiceImpl.save(developer);
        skillList.add(skill3);
        developerServiceImpl.update(developer,skillList);
        Assert.assertEquals(developer.getSkills().size(), developerServiceImpl.get(developer.getDeveloperId()).getSkills().size());
    }
}
