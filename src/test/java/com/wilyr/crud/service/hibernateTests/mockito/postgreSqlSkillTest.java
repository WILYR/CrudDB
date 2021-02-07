package com.wilyr.crud.service.hibernateTests.mockito;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.hibernate.SkillServiceImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class postgreSqlSkillTest {
    @Mock
    SkillServiceImpl skillService = org.mockito.Mockito.mock(SkillServiceImpl.class, Mockito.RETURNS_DEEP_STUBS);
    Skill skill = new Skill("Name");

    @Test
    public void skillSave() {
        given(skillService.save(skill)).willReturn(skill);
    }

    @Test
    public void skillGet() {
        given(skillService.get(skill.getId())).willReturn(skill);
    }

    @Test
    public void skillDelete() {
        skillService.delete(skill.getId());
        given(skillService.get(skill.getId())).willThrow(NullPointerException.class);
    }

    @Test
    public void skillUpdate() {
        skill.setName("KKKK");
        given(skillService.update(skill)).willReturn(skill);
    }
}
