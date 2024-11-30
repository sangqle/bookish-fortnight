package com.sangle.example.controller;

import com.sangle.example.entity.User;
import com.sangle.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<String> getUsers(@RequestParam("start") Optional<Integer> start, @RequestParam("count") Optional<Integer> count, @RequestParam("role") Optional<Integer> role) {
        List<String> userNames = new ArrayList<>();
        List<User> sliceUsers = new ArrayList<>();
        if (role.isPresent()) {
            sliceUsers = userService.getSliceUsersByRole(0, count.orElse(10), role.get());
        } else {
            sliceUsers = userService.getSliceUsers(0, count.orElse(10));
        }
        for (User user : sliceUsers) {
            userNames.add(user.getName());
        }
        return userNames;
    }
}
