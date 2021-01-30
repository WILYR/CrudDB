package com.wilyr.crud.service.mockito;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.service.mySqlService.DeveloperService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;

public class DeveloperServiceTest {

    @Mock
    DeveloperService developerService =  org.mockito.Mockito.mock(DeveloperService.class, Mockito.RETURNS_DEEP_STUBS);
    Skill[] arr= new Skill[]{new Skill("Name"), new Skill("Name2")};
    Developer developer = new Developer(Arrays.asList(arr), new Account("developer", "passdeveloper"));

    @Test
    public void developerSave() {
        given(developerService.developerSave(developer)).willReturn(developer);
    }

    @Test
    public void developerGet() {
        given(developerService.developerGet(developer)).willReturn(developer);
    }

    @Test
    public void developerDelete() {
        given(developerService.developerDelete(developer)).willThrow(NullPointerException.class);
    }

    @Test
    public void developerUpdate() {
        arr[0] = new Skill("MMM");
        given(developerService.developerUpdate(developer, Arrays.asList(arr))).willReturn(developer);
    }

}