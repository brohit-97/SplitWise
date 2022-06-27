package com.lld.splitwise.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
public class Expense extends BaseModel{

    private Long amount;

    @ManyToOne
    private User createdBy;

    private String description;

    @ManyToOne
    private Currency baseCurrency;

    @ManyToMany
    private List<User> participants;
}
