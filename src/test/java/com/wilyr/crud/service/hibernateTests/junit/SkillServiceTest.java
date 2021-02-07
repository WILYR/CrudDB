package com.wilyr.crud.service.hibernateTests.junit;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.hibernate.SkillServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class SkillServiceTest {
    SkillServiceImpl skillServiceImpl = new SkillServiceImpl();
    Skill skill = new Skill("FF");
    Skill skill2 = new Skill("AA");

    @Test
    public void save() {
        skillServiceImpl.save(skill);
        Assert.assertEquals(skill.getName(), skillServiceImpl.get(skill.getId()).getName());
        Assert.assertEquals(skill.getId(), skillServiceImpl.get(skill.getId()).getId());
        skillServiceImpl.delete(skill.getId());
    }

    @Test
    public void delete() {
        skillServiceImpl.save(skill);
        skillServiceImpl.delete(skill.getId());
        Assert.assertEquals(skillServiceImpl.get(skill.getId()), null);
    }

    @Test
    public void get() {
        skillServiceImpl.save(skill2);
        Assert.assertEquals(skill2.getName(), skillServiceImpl.get(skill2.getId()).getName());
        Assert.assertEquals(skill2.getId(), skillServiceImpl.get(skill2.getId()).getId());
        skillServiceImpl.delete(skill2.getId());
    }

    @Test
    public void update() {
        skillServiceImpl.save(skill2);
        skill2.setName("CCCC");
        skillServiceImpl.update(skill2);
        Assert.assertEquals(skill2.getName(), skillServiceImpl.get(skill2.getId()).getName());
        skillServiceImpl.delete(skill2.getId());
    }
}
