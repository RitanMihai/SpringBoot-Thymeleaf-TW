package com.example.springbootthymeleaftw.controller;

import com.example.springbootthymeleaftw.model.entity.CourseEntity;
import com.example.springbootthymeleaftw.service.CourseService;
import com.example.springbootthymeleaftw.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final SecurityService securityService;
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        CourseEntity course = courseService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("course", course);
        return "update-course";
    }

    @GetMapping()
    public String addCourse(Model model){
        if (!securityService.isAuthenticated()) {
            return "login";
        }

        model.addAttribute("course", new CourseEntity());

        return "add-course";
    }

    @PostMapping("/post")
    public String post(CourseEntity courseEntity,
                       BindingResult result, Model models) {
        if (result.hasErrors()) {
            return "add-course";
        }

        courseService.save(courseEntity);
        return "redirect:/courses";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, CourseEntity courseEntity,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            courseEntity.setId(id);
            return "update-course";
        }

        courseService.save(courseEntity);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        CourseEntity course = courseService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        courseService.delete(course);
        return "redirect:/courses";
    }
}
