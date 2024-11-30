package com.sangle.example.jpa;

import com.sangle.example.entity.User;

import java.util.List;

public interface CustomizedUserRepository {
    List<User> getSliceUsers(int start, int count);

    List<User> getSliceUsersByRole(int start, int count, int role);
}
