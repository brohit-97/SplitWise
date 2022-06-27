package com.lld.splitwise.services;

import com.lld.splitwise.model.User;
import com.lld.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User registerUser(String username, String password, String phoneNumber){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

    public User updateUser(Long userId, String password){
        User user = userRepository.findUserById(userId);
        user.setPassword(password);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
