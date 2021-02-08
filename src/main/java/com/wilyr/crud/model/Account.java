package com.wilyr.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "accountstatus")
    private AccountStatus accountStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "account", cascade = CascadeType.REMOVE)
    private Developer developer;


    public Account(String login, String password, AccountStatus accountStatus, long id) {
        this.login = login;
        this.password = password;
        this.accountStatus = accountStatus;
        this.id = id;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account() {
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}