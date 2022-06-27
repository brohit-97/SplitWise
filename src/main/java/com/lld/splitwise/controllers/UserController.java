package com.lld.splitwise.controllers;

import com.lld.splitwise.dtos.RegisterUserRequestDto;
import com.lld.splitwise.dtos.RegisterUserResponseDto;
import com.lld.splitwise.dtos.UpdateUserRequestDto;
import com.lld.splitwise.dtos.UpdateUserResponseDto;
import com.lld.splitwise.model.User;
import com.lld.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto registerUserRequestDto){
       User user = userService.registerUser(registerUserRequestDto.getUsername(),
               registerUserRequestDto.getPassword(),
               registerUserRequestDto.getPhoneNumber());
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }

    public UpdateUserResponseDto updateUser(UpdateUserRequestDto updateUserRequestDto){
        Long userId = updateUserRequestDto.getUserId();
        String password = updateUserRequestDto.getPassword();
        User user = userService.updateUser(userId,password);
        System.out.println("djfhsfhs");
        UpdateUserResponseDto updateUserResponseDto = new UpdateUserResponseDto();
        updateUserResponseDto.setUser(user);
        return updateUserResponseDto;
    }
}
