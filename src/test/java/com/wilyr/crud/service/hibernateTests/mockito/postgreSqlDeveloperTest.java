package com.wilyr.crud.service.hibernateTests.mockito;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.hibernate.DeveloperServiceImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;

public class postgreSqlDeveloperTest {
    @Mock
    DeveloperServiceImpl developerService =  org.mockito.Mockito.mock(DeveloperServiceImpl.class, Mockito.RETURNS_DEEP_STUBS);
    Skill[] arr= new Skill[]{new Skill("Name"), new Skill("Name2")};
    Developer developer = new Developer(Arrays.asList(arr), new Account("developer", "passdeveloper"));

    @Test
    public void developerSave() {
        given(developerService.save(developer)).willReturn(developer);
    }

    @Test
    public void developerGet() {
        given(developerService.get(developer.getDeveloperId())).willReturn(developer);
    }

    @Test
    public void developerDelete() {
        developerService.delete(developer.getDeveloperId());
        given(developerService.get(developer.getDeveloperId())).willThrow(NullPointerException.class);
    }

    @Test
    public void developerUpdate() {
        arr[0] = new Skill("MMM");
        given(developerService.update(developer, Arrays.asList(arr))).willReturn(developer);
    }
}
