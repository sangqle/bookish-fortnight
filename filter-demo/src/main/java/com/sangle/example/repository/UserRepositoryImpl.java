package com.sangle.example.repository;

import com.sangle.example.entity.User;
import com.sangle.example.jpa.CustomizedUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements CustomizedUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getSliceUsers(int start, int count) {
        return entityManager.createQuery("SELECT u FROM User u ORDER BY u.id ASC", User.class)
                .setFirstResult(start)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public List<User> getSliceUsersByRole(int start, int count, int role) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.role = :role ORDER BY u.id ASC", User.class)
                .setParameter("role", role)
                .setFirstResult(start)
                .setMaxResults(count)
                .getResultList();
    }
}
