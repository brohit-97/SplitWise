package com.lld.splitwise.commands;

import com.lld.splitwise.controllers.UserController;
import com.lld.splitwise.dtos.RegisterUserRequestDto;
import com.lld.splitwise.dtos.RegisterUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command{

    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = List.of(commandLine.split(" "));

        if(commandTokens.size() != 4)
            return false;

        if(!commandTokens.get(0).equals(CommandKeywords.REGISTER_USER_COMMAND))
            return false;

        return true;

    }

    @Override
    public void execute(String command) {
        List<String> commandTokens = List.of(command.split(" "));
        String username = commandTokens.get(0);
        String password = commandTokens.get(1);
        String phoneNumber = commandTokens.get(2);

        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setUsername(username);
        registerUserRequestDto.setPassword(password);
        registerUserRequestDto.setPhoneNumber(phoneNumber);

        RegisterUserResponseDto registerUserResponseDto = userController.registerUser(registerUserRequestDto);
        System.out.println(registerUserResponseDto.getUser());

    }
}
