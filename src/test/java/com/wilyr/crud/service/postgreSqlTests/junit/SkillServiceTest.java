package com.wilyr.crud.service.postgreSqlTests.junit;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.hibernate.PostgreSqlSkillService;
import org.junit.Assert;
import org.junit.Test;

public class SkillServiceTest {
    PostgreSqlSkillService postgreSqlSkillService = new PostgreSqlSkillService();
    Skill skill = new Skill("FF");
    Skill skill2 = new Skill("AA");

    @Test
    public void save() {
        postgreSqlSkillService.save(skill);
        Assert.assertEquals(skill.getName(), postgreSqlSkillService.get(skill).getName());
        Assert.assertEquals(skill.getId(), postgreSqlSkillService.get(skill).getId());
        postgreSqlSkillService.delete(skill);
    }

    @Test
    public void delete() {
        postgreSqlSkillService.save(skill);
        postgreSqlSkillService.delete(skill);
        Assert.assertEquals(postgreSqlSkillService.get(skill), null);
    }

    @Test
    public void get() {
        postgreSqlSkillService.save(skill2);
        Assert.assertEquals(skill2.getName(), postgreSqlSkillService.get(skill2).getName());
        Assert.assertEquals(skill2.getId(), postgreSqlSkillService.get(skill2).getId());
        postgreSqlSkillService.delete(skill2);
    }

    @Test
    public void update() {
        postgreSqlSkillService.save(skill2);
        skill2.setName("CCCC");
        postgreSqlSkillService.update(skill2);
        Assert.assertEquals(skill2.getName(), postgreSqlSkillService.get(skill2).getName());
        postgreSqlSkillService.delete(skill2);
    }
}
