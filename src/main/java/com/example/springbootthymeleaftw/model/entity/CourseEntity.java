package com.example.springbootthymeleaftw.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course", schema = "public", catalog = "tw_db")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "credits", nullable = false)
    private String credits;
}
