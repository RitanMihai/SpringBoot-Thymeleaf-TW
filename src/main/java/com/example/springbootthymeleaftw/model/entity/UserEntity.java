package com.example.springbootthymeleaftw.model.entity;


import lombok.Data;

/* *
* In next lessons this class will pe converted into an @Entity which is a model of an Entity from a database,
* in our case it will be a PostgreSQL database, also DTO models will be added in a separate package.
* */
@Data /* @Getter @Setter @ToString @EqualsAndHashCode */
public class UserEntity {
    private Long id;
    private String username;
    private String password;
}
