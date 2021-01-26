package com.wilyr.crud;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.postgreSqlRepository.PostgreSqlAccountRepository;
import com.wilyr.crud.repository.postgreSqlRepository.PostgreSqlDeveloperRepository;
import com.wilyr.crud.repository.postgreSqlRepository.PostgreSqlSkillRepository;
import liquibase.pro.packaged.A;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
//        CommonView commonView = new CommonView();
//        commonView.showMainMenu();
        PostgreSqlDeveloperRepository postgreSqlDeveloperRepository = new PostgreSqlDeveloperRepository();
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill(1,"NLLLLL"));
        Developer developer = new Developer(skillList, new Account("jjj", "alsflqw", AccountStatus.ACTIVE, 12));
        postgreSqlDeveloperRepository.save(developer);
    }
}
