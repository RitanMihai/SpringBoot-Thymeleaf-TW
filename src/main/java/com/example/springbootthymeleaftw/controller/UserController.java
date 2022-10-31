package com.example.springbootthymeleaftw.controller;

import com.example.springbootthymeleaftw.model.entity.UserEntity;
import com.example.springbootthymeleaftw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/* This is our endpoint, here the user connects (via a frontend/direct call) with our backend */
/* This particular endpoint is called "api/user", and will be accessible at localhost:8085/api/user as full address  */
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    /* As we can see the @Autowierd annotation can be place both on field and constructor */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserEntity> getAll(){
        return userService.getAll();
    }

    @GetMapping(path="/credentials")
    public ResponseEntity<?> getUser(@RequestParam String username, @RequestParam String password){
        Optional<UserEntity> optionalUser = userService.get(username, password);
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;
        UserEntity userEntity = optionalUser.orElseGet(null);

        if(optionalUser.isPresent())
            httpStatus = HttpStatus.OK;

        return new ResponseEntity<>(userEntity, httpStatus);
    }

    /***
     * @param username is a variable in the request URI mapping
     *                 ex of http request:
     *                 - http://localhost:8085/api/user/Ritan
     *                 - http://localhost:8085/api/user/Mihai
     * @return the list of all users with a specific username
     */
    @GetMapping(path="/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        List<UserEntity> users = userService.getByUsername(username);
        HttpStatus httpStatus = ObjectUtils.isEmpty(users) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(users, httpStatus);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserEntity userEntity) {
        System.out.println(userEntity);
        userService.addUser(userEntity);
    }

    /***
     * @param username of the user
     * @param password of the user
     * @param userEntity is the new data of the user identified by their credentials
     *
     * params are parameters in the request URI mapping.
     *             In this example we have only one parameter, but there can be more.
     *             ex of http request:
     *             - http://localhost:8085/api/user?username=Ritan&password=123456
     *             - http://localhost:8085/api/user?username=Mihai&password=123456
     */
    @PatchMapping()
    public void updateUser(@RequestParam String username, @RequestParam String password, @RequestBody UserEntity userEntity){
        userService.updateUser(username, password, userEntity);
    }

    @DeleteMapping()
    public void deleteUser() {
        /* TODO: Delete Logic */
    }
}
