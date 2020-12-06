package com.wilyr.crud.model;


public class Skill {
    private String name;
    private long id;

    public Skill(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Skill() {

    }

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}