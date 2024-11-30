package com.sangle.example.service;

import com.sangle.example.entity.User;
import com.sangle.example.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getSliceUsers(int start, int count) {
        return userRepository.getSliceUsers(start, count);
    }

    public List<User> getSliceUsersByRole(int start, int count, int role) {
        return userRepository.getSliceUsersByRole(start, count, role);
    }
}
