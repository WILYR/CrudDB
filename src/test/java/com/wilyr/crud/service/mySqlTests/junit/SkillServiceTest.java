//package com.wilyr.crud.service.mySqlTests.junit;
//
//import com.wilyr.crud.model.Skill;
//import com.wilyr.crud.repository.mySqlRepository.SkillRepository;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class SkillServiceTest {
//
//    SkillRepository skillRepository = new SkillRepository();
//
//    Skill skill = new Skill("NNN");
//    Skill skill2 = new Skill("GGG");
//    Skill skill3 = new Skill("LLL");
//
//
//    @Test
//    public void skillSave() {
//        skillRepository.save(skill);
//        Assert.assertEquals(skill.getName(), skillRepository.get(skill).getName());
//        skillRepository.delete(skill);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void skillDelete() {
//        skillRepository.save(skill2);
//        skillRepository.delete(skill2);
//        Assert.assertEquals(skill2.getName(), skillRepository.get(skill2).getName());
//    }
//
//    @Test
//    public void skillUpdate() {
//        skillRepository.save(skill3);
//        skill3 = skillRepository.get(skill3);
//        skill3.setName("gfgqgwf");
//        skillRepository.update(skill3);
//        System.out.println(skill3.getName());
//        System.out.println(skillRepository.get(skill3).getName());
//        Assert.assertEquals(skill3.getName(), skillRepository.get(skill3).getName());
//        skillRepository.delete(skill3);
//    }
//
//    @Test
//    public void skillGet() {
//        skillRepository.save(skill);
//        Assert.assertEquals(skill.getName(), skillRepository.get(skill).getName());
//        skillRepository.delete(skill);
//    }
//}