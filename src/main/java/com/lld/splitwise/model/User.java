package com.lld.splitwise.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User extends BaseModel{
    private String userName;
    private String password;
    private String phoneNumber;
}
