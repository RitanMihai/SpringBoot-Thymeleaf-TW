package com.example.springbootthymeleaftw.service;

import com.example.springbootthymeleaftw.model.entity.CourseEntity;
import com.example.springbootthymeleaftw.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseEntity> getAll (){
        return  courseRepository.findAll();
    }

    public void save(CourseEntity courseEntity) {
        courseRepository.save(courseEntity);
    }

    public Optional<CourseEntity> findById(long id) {
        return courseRepository.findById(id);
    }

    public void delete(CourseEntity courseEntity) {
        courseRepository.delete(courseEntity);
    }
}
