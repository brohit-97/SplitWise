package com.lld.splitwise.commands;

import com.lld.splitwise.controllers.UserController;
import com.lld.splitwise.dtos.UpdateUserRequestDto;
import com.lld.splitwise.dtos.UpdateUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateProfileCommand implements Command{

    @Autowired
    private UserController userController;
    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = List.of(commandLine.split(" "));

        if(commandTokens.size() != 3)
            return false;

        if(!commandTokens.get(1).equals(CommandKeywords.UPDATE_PROFILE_COMMAND))
            return false;

        return true;
    }

    @Override
    public void execute(String command) {
        List<String> commandTokens = List.of(command.split(" "));
        Long userId = Long.valueOf(commandTokens.get(0));
        String newPassword = commandTokens.get(2);
        UpdateUserRequestDto updateUserRequestDto = new UpdateUserRequestDto();
        updateUserRequestDto.setUserId(userId);
        updateUserRequestDto.setPassword(newPassword);

        UpdateUserResponseDto updateUserResponseDto = userController.updateUser(updateUserRequestDto);
        System.out.println(updateUserResponseDto);

    }
}
