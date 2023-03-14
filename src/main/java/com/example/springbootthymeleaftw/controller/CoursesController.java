package com.example.springbootthymeleaftw.controller;

import com.example.springbootthymeleaftw.service.CourseService;
import com.example.springbootthymeleaftw.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CoursesController {
    private final CourseService courseService;
    private final SecurityService securityService;

    @GetMapping()
    public String open(Model model){
        if (!securityService.isAuthenticated()) {
            return "login";
        }

        model.addAttribute("courses", courseService.getAll());

        return "courses";
    }
}
