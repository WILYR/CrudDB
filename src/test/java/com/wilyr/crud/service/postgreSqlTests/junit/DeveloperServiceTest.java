package com.wilyr.crud.service.postgreSqlTests.junit;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlAccountService;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlDeveloperService;
import com.wilyr.crud.service.postgreSqlService.PostgreSqlSkillService;
import liquibase.pro.packaged.A;
import liquibase.pro.packaged.D;
import liquibase.pro.packaged.S;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeveloperServiceTest {
    PostgreSqlDeveloperService postgreSqlDeveloperService = new PostgreSqlDeveloperService();
    PostgreSqlAccountService postgreSqlAccountService = new PostgreSqlAccountService();
    PostgreSqlSkillService postgreSqlSkillService = new PostgreSqlSkillService();
    Skill skill = postgreSqlSkillService.get(new Skill(7,""));
    Skill skill2 = postgreSqlSkillService.get(new Skill(10,""));
    Skill skill3 = postgreSqlSkillService.get(new Skill(4,""));

    Account account = postgreSqlAccountService.save(new Account("asfasf","agsdg", AccountStatus.BANNED,0));
    List<Skill> skillList = new ArrayList<>();
    Developer developer = new Developer();

    @Test
    public void save() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        postgreSqlDeveloperService.save(developer);
        Assert.assertEquals(developer.getDeveloperId(), postgreSqlDeveloperService.get(developer).getDeveloperId());
        Assert.assertEquals(developer.getAccount().getId(), postgreSqlDeveloperService.get(developer).getAccount().getId());
    }

    @Test
    public void delete() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        postgreSqlDeveloperService.save(developer);
        postgreSqlDeveloperService.delete(developer);
        Assert.assertEquals(postgreSqlDeveloperService.get(developer), null);
    }

    @Test
    public void get() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        postgreSqlDeveloperService.save(developer);
        Assert.assertEquals(developer.getDeveloperId(), postgreSqlDeveloperService.get(developer).getDeveloperId());
        Assert.assertEquals(developer.getAccount().getId(),postgreSqlDeveloperService.get(developer).getAccount().getId());
    }

    @Test
    public void update() {
        skillList.add(skill);
        skillList.add(skill2);
        developer.setSkills(skillList);
        developer.setAccount(account);
        postgreSqlDeveloperService.save(developer);
        skillList.add(skill3);
        postgreSqlDeveloperService.update(developer,skillList);
        Assert.assertEquals(developer.getSkills().size(), postgreSqlDeveloperService.get(developer).getSkills().size());
    }
}
