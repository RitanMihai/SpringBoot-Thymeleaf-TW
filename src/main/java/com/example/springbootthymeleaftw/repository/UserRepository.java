package com.example.springbootthymeleaftw.repository;

import com.example.springbootthymeleaftw.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* In ram memory database */
public interface UserRepository {
    List<UserEntity> findAll();
    List<UserEntity> findAllByUsername(String username);
    Optional<UserEntity> findUserByUsernameAndPassword(String username, String password);
    void addUser(UserEntity userEntity);
    void updateUser(String username, String password, UserEntity user);
}
