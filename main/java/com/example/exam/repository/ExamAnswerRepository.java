package com.example.exam.repository;

import com.example.exam.model.ExamAnswer;
import com.example.exam.model.Question;
import com.example.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExamAnswerRepository extends JpaRepository<ExamAnswer, Long> {

    List<ExamAnswer> findByStudent(User student);

    Optional<ExamAnswer> findByStudentAndQuestion(User student, Question question);
}
