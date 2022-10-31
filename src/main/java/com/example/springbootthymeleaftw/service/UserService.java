package com.example.springbootthymeleaftw.service;

import com.example.springbootthymeleaftw.model.entity.UserEntity;
import com.example.springbootthymeleaftw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* In service lies the code logic, often the bridge between database and controller */
@Service
public class UserService { /* This class can also be converted in a record,
                              but pay attention records are, sometimes, problematic in unit-tests */
    /* *
    * As we can see the @Autowierd annotation can be place both on field and constructor;
    * Is possible but, field injection is not recommended, so try to use it on Constructor
    * or use @RequiredArgsConstructor from Lombok
    * */
    @Autowired @Qualifier("runtimeUser")
    private final UserRepository userRepository;

    /* Here we can choose the preferred database provider, in our case */
    public UserService(@Qualifier("runtimeUser") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> get(String username, String password){
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    public void addUser(UserEntity userEntity) {
        userRepository.addUser(userEntity);
    }

    public void updateUser(String username, String password, UserEntity userEntity) {
        userRepository.updateUser(username, password, userEntity);
    }

    public List<UserEntity> getByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }
}
