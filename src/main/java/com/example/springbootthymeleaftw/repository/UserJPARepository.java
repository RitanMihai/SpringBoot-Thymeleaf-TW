package com.example.springbootthymeleaftw.repository;


import com.example.springbootthymeleaftw.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaUser")
public class UserJPARepository implements UserRepository /* extends JpaRepository<Receipt, Long>*/ {
    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public List<UserEntity> findAllByUsername(String username) {
        return null;
    }

    @Override
    public Optional<UserEntity> findUserByUsernameAndPassword(String username, String password) {
        return Optional.empty();
    }

    @Override
    public void addUser(UserEntity userEntity) {

    }

    @Override
    public void updateUser(String username, String password, UserEntity user) {

    }
}
