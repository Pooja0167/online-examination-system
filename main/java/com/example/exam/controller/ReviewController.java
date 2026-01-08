package com.example.exam.controller;

import com.example.exam.model.User;
import com.example.exam.repository.ExamResultRepository;
import com.example.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ExamResultRepository examResultRepository;
    private final UserRepository userRepository;

    @GetMapping("/student/results")
    public String viewResults(Authentication authentication, Model model) {

        Optional<User> optionalUser =
                userRepository.findByUsername(authentication.getName());

        if (optionalUser.isEmpty()) {
            return "redirect:/login";
        }

        User student = optionalUser.get();
        model.addAttribute("results",
                examResultRepository.findByStudent(student));

        return "student/result";
    }
}

