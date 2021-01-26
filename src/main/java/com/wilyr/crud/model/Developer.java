package com.wilyr.crud.model;

import liquibase.pro.packaged.I;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long developerId;

    @OneToOne
    @JoinColumn(name = "accountid")
    private Account account;

    @ManyToMany
    @JoinTable(name="developers",
            joinColumns=@JoinColumn(name="accountid"),
            inverseJoinColumns=@JoinColumn(name="skillid"))
    private List<Skill> skills;

    public Developer(List<Skill> skills, Account account) {
        this.skills = skills;
        this.account = account;
    }

    public Developer() {
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}