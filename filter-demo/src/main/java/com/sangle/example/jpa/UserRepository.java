package com.sangle.example.jpa;

import com.sangle.example.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>, CustomizedUserRepository {
}

