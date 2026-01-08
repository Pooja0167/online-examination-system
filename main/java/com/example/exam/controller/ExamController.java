package com.example.exam.controller;

import com.example.exam.model.*;
import com.example.exam.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class ExamController {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;
    private final ExamAnswerRepository examAnswerRepository;
    private final UserRepository userRepository;
    private final ExamResultRepository examResultRepository;

    @PostMapping("/submit/{examId}")
    public String submitExam(
            @PathVariable Long examId,
            @RequestParam List<String> answers,
            Authentication authentication) {

        Optional<User> optionalUser = userRepository.findByUsername(authentication.getName());
        if (optionalUser.isEmpty()) return "redirect:/login";

        User student = optionalUser.get();
        Exam exam = examRepository.findById(examId).orElse(null);
        if (exam == null) return "redirect:/student/index";

        List<Question> questions = questionRepository.findByExam(exam);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            ExamAnswer ans = new ExamAnswer();
            ans.setQuestion(q);
            ans.setStudent(student);
            ans.setSelectedAnswer(answers.get(i));
            examAnswerRepository.save(ans);

            if (q.getCorrectAnswer().equalsIgnoreCase(answers.get(i))) {
                score++;
            }
        }

        ExamResult result = new ExamResult();
        result.setExam(exam);
        result.setStudent(student);
        result.setScore(score);
        examResultRepository.save(result);

        return "redirect:/student/index";
    }
}

