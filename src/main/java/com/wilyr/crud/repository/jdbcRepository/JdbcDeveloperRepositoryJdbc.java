package com.wilyr.crud.repository.jdbcRepository;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.Developer;
import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.IDeveloperRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperRepositoryJdbc implements IDeveloperRepository, JdbcAbstractRepository {

    public Developer save(Developer developer) {
        try (Statement statement = setConnection().createStatement()){
            List<Skill> skillList = developer.getSkills();
            for (Skill i : skillList) {
                String sqlQuery = "INSERT INTO developers value ('" + developer.getAccount().getId() +
                        "', '" + i.getId() + "');";
                statement.execute(sqlQuery);
            }
            return developer;
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
            return null;
        }
    }

    public void delete(Long id) {
        try (Statement statement = setConnection().createStatement()){
            Developer developer = new Developer();
            developer.setDeveloperId(id);
            String sqlQuery = "DELETE from developers where accountid = '" + developer.getAccount().getId() + "';";
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }

    public Developer get(Long id) {
        try (Statement statement = setConnection().createStatement()){
            Developer developer = new Developer();
            developer.setDeveloperId(id);
            String sqlQuery = "SELECT accountid, skillid from developers where accountid = '" + developer.getAccount().getId() + "';";
            statement.execute(sqlQuery);
            ResultSet rs = statement.getResultSet();
            Account account = new Account();
            List<Skill> skillList = new ArrayList<>();
            //account.setId(developer.getAccount().getId());
            while (rs.next()) {
                account.setId(rs.getLong("accountid"));
                Skill skill = new Skill();
                skill.setId(rs.getLong("skillid"));
                skillList.add(skill);
            }
            return new Developer(skillList, account);
        } catch (SQLException e) {
            System.out.println("Get error: " + e.getMessage());
            return null;
        }
    }

    public Developer update(Developer developer, List<Skill> newSkills) {
        try (Statement statement = setConnection().createStatement()){
            String sqlQuery = "DELETE FROM developers where accountid = '" + developer.getAccount().getId() + "';";
            statement.execute(sqlQuery);
            JdbcSkillRepositoryJdbc skillRepository = new JdbcSkillRepositoryJdbc();
            for (Skill skill : newSkills) {
                skill = skillRepository.get(skill.getId());
            }
            developer.setSkills(newSkills);
            save(developer);
            return developer;
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
            return null;
        }
    }

}
