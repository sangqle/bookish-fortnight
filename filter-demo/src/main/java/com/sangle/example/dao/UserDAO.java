package com.sangle.example.dao;

import com.sangle.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDAO {
    List<User> findSlice(int start, int end);
}
