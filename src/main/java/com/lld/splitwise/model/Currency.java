package com.lld.splitwise.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Currency extends BaseModel{

    private String name;
    private String symbol;
}
