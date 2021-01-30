package com.wilyr.crud.service.mySqlTests.mockito;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.mySqlService.SkillService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class SkillServiceTest {

    @Mock
    SkillService skillService = org.mockito.Mockito.mock(SkillService.class, Mockito.RETURNS_DEEP_STUBS);
    Skill skill = new Skill("Name");

    @Test
    public void skillSave() {
        given(skillService.skillSave(skill)).willReturn(skill);
    }

    @Test
    public void skillGet() {
        given(skillService.skillGet(skill)).willReturn(skill);
    }

    @Test
    public void skillDelete() {
        given(skillService.skillDelete(skill)).willThrow(NullPointerException.class);
    }

    @Test
    public void skillUpdate() {
        skill.setName("KKKK");
        given(skillService.skillUpdate(skill)).willReturn(skill);
    }

}