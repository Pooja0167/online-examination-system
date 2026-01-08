package com.example.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/dashboard")
    public String studentDashboard() {
        // Thymeleaf template: src/main/resources/templates/student-dashboard.html
        return "student-dashboard";
    }
}


