package com.example.springbootthymeleaftw.controller;

import com.example.springbootthymeleaftw.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/") // this is default
@RequiredArgsConstructor
public class HomeController {
    private final SecurityService securityService;

    @GetMapping()
    public String open(Model model, String error, String logout){
        if (!securityService.isAuthenticated()) {
            return "login";
        }

        return "index";
    }
}
