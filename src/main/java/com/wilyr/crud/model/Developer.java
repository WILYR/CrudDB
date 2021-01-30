package com.wilyr.crud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long developerId;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "accountid")
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="developer_skills",
            joinColumns=@JoinColumn(name="developer_id",referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name="skill_id"))
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
