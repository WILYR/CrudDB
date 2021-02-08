package com.wilyr.crud.repository.jdbcRepository;

import com.wilyr.crud.model.Skill;
import com.wilyr.crud.repository.ISkillsRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSkillRepositoryJdbc implements ISkillsRepository, JdbcAbstractRepository {


    public Skill save(Skill skill) {
        try (Statement statement = setConnection().createStatement()) {
            String sqlQuery = "INSERT INTO skills VALUES (id,'" + skill.getName() + "');";
            statement.execute(sqlQuery);
            return skill;
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
            return null;
        }
    }

    public void delete(Long id) {
        try (Statement statement = setConnection().createStatement()) {
            Skill skill = new Skill(id, "");
            String sqlQuery = null;
            if (skill.getName() == null) {
                sqlQuery = "DELETE FROM skills WHERE id = '" + skill.getId() + "';";
            } else {
                sqlQuery = "DELETE FROM skills WHERE name = '" + skill.getName() + "';";
            }
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }


    public Skill update(Skill skill) {
        try (Statement statement = setConnection().createStatement()) {
            String sqlQuery = "UPDATE skills\n" +
                    "set name = '" + skill.getName() + "'\n" +
                    "where id = '" + skill.getId() + "';";
            statement.execute(sqlQuery);
            return skill;
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
            return null;
        }
    }

    public Skill get(Long id) {
        try (Statement statement = setConnection().createStatement()) {
            Skill skill = new Skill(id, "");
            String sqlQuery = "select id, name from skills where name = '" + skill.getName() + "';";
            statement.execute(sqlQuery);
            ResultSet rs = statement.getResultSet();
            rs.next();
            Skill returnSkill = new Skill(rs.getLong(1), rs.getString(2));
            return returnSkill;
        } catch (SQLException e) {
            System.out.println("Get error: " + e.getMessage());
            return null;
        }
    }


}
