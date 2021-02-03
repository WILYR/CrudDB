package com.wilyr.crud.repository.jdbcRepository;

import com.wilyr.crud.model.Account;
import com.wilyr.crud.model.AccountStatus;
import com.wilyr.crud.repository.IAccountRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountRepository implements IAccountRepository,AbstractRepository {




    public Account save(Account account) {
        try (Statement statement = setConnection().createStatement()){
            String sqlQuery = "INSERT into accounts values(id, '" + account.getLogin() + "', " +
                    "'" + account.getPassword() + "', '" + account.getAccountStatus() + "');";
            statement.execute(sqlQuery);
            return account;
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
            return null;
        }
    }

    public void delete(Account account) {
        try (Statement statement = setConnection().createStatement()){
            String sqlQuery = "DELETE FROM accounts WHERE login = '" + account.getLogin() + "';";
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }

    public Account get(Account account) {
        try (Statement statement = setConnection().createStatement()){
            String sqlQuery = "SELECT id, login, password, accountstatus from accounts where login = '" + account.getLogin() + "';";
            statement.execute(sqlQuery);
            ResultSet rs = statement.getResultSet();
            rs.next();
            Account returnAccount = new Account(rs.getString(2), rs.getString(3),
                    AccountStatus.valueOf(rs.getString(4)), rs.getLong(1));
            return returnAccount;
        } catch (SQLException e) {
            System.out.println("Get error: " + e.getMessage());
            return null;
        }
    }

    public Account update(Account account) {
        try (Statement statement = setConnection().createStatement()){
            String sqlQuery = "UPDATE accounts set password = '" + account.getPassword() + "'" +
                    ", accountstatus = '" + account.getAccountStatus() + "'";
            statement.execute(sqlQuery);
            return account;
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
            return null;
        }
    }
}
