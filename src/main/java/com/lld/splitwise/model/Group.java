package com.lld.splitwise.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class Group extends BaseModel {

    private String name;

    @ManyToMany
    private List<User> participants;

    @ManyToMany
    private List<User> admin;

    @ManyToOne
    private User createdBy;

    @OneToMany
    private List<Expense> expenses;

}
