package com.example.springbootthymeleaftw.repository;

import com.example.springbootthymeleaftw.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("runtimeUser")
public class UserRunTimeRepository implements UserRepository {
    List<UserEntity> users = new ArrayList<>();

    public List<UserEntity> findAll(){
        return users;
    }

    public List<UserEntity> findAllByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).toList();
    }

    public Optional<UserEntity> findUserByUsernameAndPassword(String username, String password){
        return users.stream().filter(
                        user -> user.getUsername().equals(username) &&
                                user.getPassword().equals(password))
                .findAny();
    }

    public void addUser(UserEntity userEntity) {
        users.add(userEntity);
    }

    public void updateUser(String username, String password, UserEntity user) {
        UserEntity userEntity = this.findUserByUsernameAndPassword(username, password).orElseThrow();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setId(user.getId());
    }
}
