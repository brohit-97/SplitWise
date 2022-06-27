package com.lld.splitwise.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ExpensePayingUser extends  BaseModel{

    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    private Long amount;
}
