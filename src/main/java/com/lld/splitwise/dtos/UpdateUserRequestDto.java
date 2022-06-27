package com.lld.splitwise.dtos;

import lombok.Data;

@Data
public class UpdateUserRequestDto {
    Long userId;
    String password;
}
