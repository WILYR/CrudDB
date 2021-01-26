package com.wilyr.crud.model;

import liquibase.pro.packaged.I;

import javax.persistence.*;

public enum AccountStatus {
    ACTIVE,
    DELETED,
    BANNED,
}